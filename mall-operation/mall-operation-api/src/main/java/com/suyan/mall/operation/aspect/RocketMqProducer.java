/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.aspect;

import com.google.common.base.Preconditions;
import com.suyan.exception.CommonException;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class RocketMqProducer {

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;
    @Value("${rocketmq.producer-group}")
    private String producerGroup;

    private static final int PRODUCER_RETRY_TIMES = 3;

    public SendResult sendSimpleMessage(String topic, String tag, String key, String body, Integer delayLevel) {
        if (delayLevel == null) {
            delayLevel = 0;
        }
        Message message = checkMessage(body, topic, tag, key);
        if (delayLevel < 0 || delayLevel > 18) {
            throw new CommonException(ResultCode.MESSAGE_902_ERROR, topic, key);
        }
        message.setDelayTimeLevel(delayLevel);
        return retrySendMessage(message);
    }

    private SendResult retrySendMessage(Message msg) {
        int iniCount = 1;
        SendResult result;
        while (true) {
            try {

                DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
                producer.setNamesrvAddr(namesrvAddr);
                producer.setVipChannelEnabled(false);
                producer.start();
                result = producer.send(msg);
                break;
            } catch (Exception e) {
                log.error("发送消息失败:", e);
                if (iniCount++ >= PRODUCER_RETRY_TIMES) {
                    throw new CommonException(ResultCode.MESSAGE_901_ERROR, PRODUCER_RETRY_TIMES, msg.getTopic(), msg.getKeys());
                }
            }
        }
        log.info("<== 发送MQ SendResult={}", result);
        return result;
    }

    public Message checkMessage(String body, String topic, String tag, String key) {
        log.info("checkMessage-校验MQ producerGroup={}, body={}, topic={}, tag={}, key={}", producerGroup, body, topic, tag, key);
        checkMessage(topic, key, body);
        return buildMessage(body, topic, tag, key);
    }

    public void checkMessage(String topic, String key, String body) {

        Preconditions.checkArgument(!StringUtils.isEmpty(topic), "发送消息失败, 消息主题不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(key), "发送消息失败, 消息关键字不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(body), "发送消息失败, 消息体不能为空");
    }

    private Message buildMessage(String body, String topic, String tag, String key) {
        Message message = new Message();
        try {
            message.setBody(body.getBytes(RemotingHelper.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            log.error("编码转换,出现异常={}", e.getMessage(), e);
            throw new CommonException(ResultCode.MESSAGE_901_ERROR, key);
        }
        message.setKeys(key);
        message.setTopic(topic);
        message.setTags(tag);
        return message;
    }

}

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.service.impl;

import com.suyan.mall.message.biz.ChannelBiz;
import com.suyan.mall.message.biz.MessageRecordBiz;
import com.suyan.mall.message.constant.Constant;
import com.suyan.mall.message.convertor.MessageRecordConvertor;
import com.suyan.mall.message.model.Channel;
import com.suyan.mall.message.req.MessageRecordQueryDTO;
import com.suyan.mall.message.req.SmsMessageDTO;
import com.suyan.mall.message.resp.MessageRecordVO;
import com.suyan.mall.message.service.IMessageRecordService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 短信消息记录管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service("messageRecordService")
public class MessageRecordServiceImpl implements IMessageRecordService {

    @Value("${sms.default.verCode:000000}")
    private String code;

    @Autowired
    private MessageRecordBiz messageRecordBiz;
    @Autowired
    private ChannelBiz channelBiz;


    /**
     * 发送验证码短信
     *
     * @param smsMessageDTO
     * @return
     */
    public Result<String> sendVerCode(SmsMessageDTO smsMessageDTO) {
        Result<String> result = Result.newSuccess();

        // 验证渠道、签名
        Channel channel = channelBiz.getChannel(smsMessageDTO.getChannel());
        if (channel == null) {
            result.setErrorCode(ResultCode.COMMON_PARAM_INVALID, "渠道");
            return result;
        }
        if (StringUtils.isEmpty(channel.getSupportType()) || !channel.getSupportType().contains(Constant.VERIFY_SUPPORT_TYPE)) {
            result.setErrorCode(ResultCode.COMMON_PARAM_INVALID, "渠道");
            return result;
        }
        if (!smsMessageDTO.getSign().equalsIgnoreCase(DigestUtils.md5Hex(smsMessageDTO.getMobile() + smsMessageDTO.getChannel() + channel.getSecretKey()))) {
            result.setErrorCode(ResultCode.COMMON_PARAM_INVALID, "签名");
            return result;
        }

        smsMessageDTO.setVerCode(code);
        smsMessageDTO.setChannelId(channel.getId());

        messageRecordBiz.sendVerCode(smsMessageDTO);
        result.setData(code);
        return result;
    }

    public QueryResultVO<MessageRecordVO> queryMessageRecord(MessageRecordQueryDTO messageRecordQueryDTO) {
        return MessageRecordConvertor.toQueryResult(messageRecordBiz.queryMessageRecord(messageRecordQueryDTO));
    }

}
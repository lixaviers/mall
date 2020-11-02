/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service.impl;

import com.suyan.exception.CommonException;
import com.suyan.mall.operation.aspect.RocketMqProducer;
import com.suyan.mall.operation.enums.MqMessageTypeEnum;
import com.suyan.mall.operation.feignClient.b.MqMessageDataFeignClient;
import com.suyan.mall.operation.req.MqMessageDataDTO;
import com.suyan.mall.operation.service.IMqMessageService;
import com.suyan.result.ResultCode;
import com.suyan.service.BaseInterface;
import com.suyan.utils.StringUtils;
import com.suyan.utils.ValidateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MqMessageServiceImpl implements IMqMessageService {

    @Autowired
    private MqMessageDataFeignClient mqMessageDataFeignClient;

    @Autowired
    private RocketMqProducer rocketMqProducer;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveWaitConfirmMessage(MqMessageDataDTO mqMessageDataDTO) {
        this.saveMqProducerMessage(mqMessageDataDTO);
        // TODO 发送预发送状态的消息给消息中心
        log.info("saveWaitConfirmMessage存储预发送消息成功messageKey={}", mqMessageDataDTO.getMessageKey());
    }

    @Override
    public void saveAndSendMessage(MqMessageDataDTO mqMessageDataDTO) {
        // this.saveMqProducerMessage(mqMessageDataDTO);
        // 先发送消息，在保存消息数据
        rocketMqProducer.sendSimpleMessage(mqMessageDataDTO.getMessageTopic(), mqMessageDataDTO.getMessageTag(),
                mqMessageDataDTO.getMessageKey(), mqMessageDataDTO.getMessageBody(), mqMessageDataDTO.getDelayLevel());
        mqMessageDataFeignClient.add(mqMessageDataDTO);
        log.info("saveAndSendMessage保存并送消息成功messageKey={}", mqMessageDataDTO.getMessageKey());
    }

    private void saveMqProducerMessage(MqMessageDataDTO mqMessageDataDTO) {
        mqMessageDataDTO.setMessageType(MqMessageTypeEnum.PRODUCER_MESSAGE.getValue());
        String errorMessage = ValidateUtil.validate(mqMessageDataDTO, "", BaseInterface.class);
        if (StringUtils.isNotEmpty(errorMessage)) {
            throw new CommonException(ResultCode.COMMON_MESSAGE, errorMessage);
        }
        mqMessageDataDTO.setMessageType(MqMessageTypeEnum.PRODUCER_MESSAGE.getValue());
    }


}

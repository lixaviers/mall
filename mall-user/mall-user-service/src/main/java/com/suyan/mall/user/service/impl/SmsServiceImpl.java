/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service.impl;

import com.suyan.mall.message.feignClient.SmsSendFeignClient;
import com.suyan.mall.message.req.SmsMessageDTO;
import com.suyan.mall.user.constants.RedisKey;
import com.suyan.mall.user.req.SmsMessageSendDTO;
import com.suyan.mall.user.service.ISmsService;
import com.suyan.mall.user.utils.RedisUtil;
import com.suyan.result.Result;
import com.suyan.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("smsService")
public class SmsServiceImpl implements ISmsService {

    @Autowired
    private SmsSendFeignClient smsSendFeignClient;

    public Result<String> sendVerifyCode(SmsMessageSendDTO smsMessageSendDTO) {
        String redisKey = RedisKey.getMobileCodeKey(smsMessageSendDTO.getMobile(), smsMessageSendDTO.getSource());
        Object object = RedisUtil.get(redisKey);
        smsMessageSendDTO.setVerCode(object == null ? null : String.valueOf(object));
        SmsMessageDTO smsMessageDTO = BeanUtil.fastBeanCopy(smsMessageSendDTO, SmsMessageDTO.class);
        Result<String> result = smsSendFeignClient.verifyCode(smsMessageDTO);
        if (result.isSuccess()) {
            String code = result.getData();
            if (object != null) {
                RedisUtil.expire(redisKey, 15, TimeUnit.MINUTES);
            } else {
                RedisUtil.set(redisKey, code, 15, TimeUnit.MINUTES);
            }
        } else {
            return result;
        }
        return Result.newSuccess();
    }

}

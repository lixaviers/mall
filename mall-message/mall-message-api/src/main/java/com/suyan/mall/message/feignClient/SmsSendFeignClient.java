/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.feignClient;

import com.suyan.mall.message.req.SmsMessageDTO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "mall-message-web", path = "/feign/v1/sms")
public interface SmsSendFeignClient {

    /**
     * 发送验证码短信 -- 外部
     *
     * @param smsMessageDTO
     * @return
     */
    @PostMapping(value = "/verifyCode")
    Result<String> verifyCode(@RequestBody SmsMessageDTO smsMessageDTO);


}

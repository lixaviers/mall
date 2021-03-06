/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.controller;

import com.suyan.annotation.PassLogin;
import com.suyan.mall.user.req.SmsMessageSendDTO;
import com.suyan.mall.user.service.ISmsService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/c/sms")
@RestController
@Api(value = "/c/sms", tags = "发送短信接口")
public class SmsController {

    @Autowired
    private ISmsService smsService;

    @ApiOperation(value = "发送验证码", notes = "发送验证码(15分钟有效)")
    @PostMapping("sendVerifyCode")
    @PassLogin
    public Result send(@Valid @RequestBody SmsMessageSendDTO smsMessageSendDTO) {
        return smsService.sendVerifyCode(smsMessageSendDTO);
    }

}

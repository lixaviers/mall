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

@RequestMapping("/b/sms")
@RestController
@Api(value = "/b/sms", tags = "发送短信接口")
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

package com.suyan.mall.message.feigncontroller;

import com.suyan.mall.message.feignClient.SmsSendFeignClient;
import com.suyan.mall.message.req.SmsMessageDTO;
import com.suyan.mall.message.service.IMessageRecordService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/feign/v1/sms")
@RestController
@Api(value = "/feign/v1/sms", tags = "SMS短信消息记录管理接口")
public class SmsSendFeignController implements SmsSendFeignClient {

    @Autowired
    private IMessageRecordService messageRecordService;

    @ApiOperation(value = "verifyCode", notes = "发送验证码短信")
    @PostMapping("verifyCode")
    @Override
    public Result<String> verifyCode(@Valid @RequestBody SmsMessageDTO smsMessageDTO) {
        return messageRecordService.sendVerCode(smsMessageDTO);
    }


}

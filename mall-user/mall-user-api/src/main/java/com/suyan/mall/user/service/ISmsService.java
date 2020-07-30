package com.suyan.mall.user.service;

import com.suyan.mall.user.req.SmsMessageSendDTO;
import com.suyan.result.Result;
import org.springframework.stereotype.Service;

@Service
public interface ISmsService {

    Result<String> sendVerifyCode(SmsMessageSendDTO smsMessageSendDTO);

}

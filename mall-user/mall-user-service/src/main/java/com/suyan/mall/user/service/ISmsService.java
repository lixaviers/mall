/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service;

import com.suyan.mall.user.req.SmsMessageSendDTO;
import com.suyan.result.Result;
import org.springframework.stereotype.Service;

public interface ISmsService {

    Result<String> sendVerifyCode(SmsMessageSendDTO smsMessageSendDTO);

}

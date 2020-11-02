/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.model.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * 验证码mq实体
 */
@Data
public class SmsVerifyMqBean implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 渠道id
     */
    private Integer channelId;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 验证码
     */
    private String verCode;

}

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.resp;

import lombok.Data;

/**
 * 验证码发送结果
 */
@Data
public class VerifyResultVO {

    /**
     * 返回本次任务的序列ID
     */
    private String taskID;

    /**
     * 错误信息
     */
    private String error;


}

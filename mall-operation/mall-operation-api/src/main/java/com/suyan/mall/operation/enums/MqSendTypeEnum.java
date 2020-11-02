/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.enums;

/**
 * MQ发送类型
 */
public enum MqSendTypeEnum {
    /**
     * 等待确认.
     */
    WAIT_CONFIRM,

    /**
     * 直接发送.
     */
    SAVE_AND_SEND,
}

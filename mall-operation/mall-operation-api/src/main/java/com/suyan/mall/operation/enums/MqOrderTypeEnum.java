/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：MqOrderTypeEnum.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.enums;

/**
 * MQ顺序类型
 */
public enum MqOrderTypeEnum {

    /**
     * 有序.
     */
    ORDER((byte) 1),
    /**
     * 无序.
     */
    DIS_ORDER((byte) 0);

    byte orderType;

    MqOrderTypeEnum(final byte orderType) {
        this.orderType = orderType;
    }

    public byte orderType() {
        return orderType;
    }
}

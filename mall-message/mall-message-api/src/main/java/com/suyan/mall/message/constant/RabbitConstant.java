/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.constant;

public interface RabbitConstant {

    /**
     * exchange
     */
    String EXCHANGE = "suyan.mall.message.exchange";
    /**
     * routingKey
     */
    String ROUTING_KEY = "suyan.mall.message.routingKey";

    /**
     * 默认队列超时时间
     */
    long DEFAULT_QUEUE_TTL = 300000L;// 5分钟

    /**
     * 延迟队列 TTL 名称
     */
    String DELAY_QUEUE = "suyan.mall.message.delay.queue";


}

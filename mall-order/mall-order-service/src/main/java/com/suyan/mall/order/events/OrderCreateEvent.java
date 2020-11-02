/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.events;

import org.springframework.context.ApplicationEvent;

public class OrderCreateEvent extends ApplicationEvent {

    private OrderCreateEventContext context;

    public OrderCreateEvent(Object source, OrderCreateEventContext context) {
        super(source);
        this.context = context;
    }

    public OrderCreateEventContext getContext() {
        return context;
    }

}

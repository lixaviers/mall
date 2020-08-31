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

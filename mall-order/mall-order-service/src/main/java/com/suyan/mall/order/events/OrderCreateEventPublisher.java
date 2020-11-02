/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.events;

import com.suyan.mall.order.model.Order;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 订单创建事件发布器，通知相关业务组件处理对应数据
 * 使用事件机制是为了各业务逻辑解耦
 *
 * @see com.suyan.mall.order.events.listener.OrderListener 创建订单
 * @see com.suyan.mall.order.events.listener.OrderGoodsListener 创建订单商品
 * @see com.suyan.mall.order.events.listener.OrderGoodsInventoryListener 商品库存扣减
 */
@Component
@Slf4j
public class OrderCreateEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * 创建订单
     *
     * @param user
     * @param order
     * @return
     */
    public OrderVO createOrder(UserInfoVO user, Order order) {
        OrderCreateEventContext context = OrderCreateEventContext.builder().user(user).order(order).build();
        log.info("创建订单-入参={}", JsonUtil.toJsonString(context));
        applicationEventPublisher.publishEvent(new OrderCreateEvent(this, context));
        return context.getOrderVO();
    }

}

package com.suyan.mall.order.events.listener;

import com.suyan.mall.order.biz.OrderGoodsBiz;
import com.suyan.mall.order.events.OrderCreateEvent;
import com.suyan.mall.order.events.OrderCreateEventContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建订单商品
 */
@Component
@Order(3)
@Slf4j
public class OrderGoodsListener implements ApplicationListener<OrderCreateEvent> {

    @Autowired
    private OrderGoodsBiz orderGoodsBiz;

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        log.info("创建订单-创建订单商品");
        OrderCreateEventContext context = event.getContext();
        orderGoodsBiz.createOrderGoods(context.getOrder().getOrderGoodsList(), context.getUser(), context.getOrder().getOrderNumber());
    }

}

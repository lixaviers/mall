package com.suyan.mall.order.events.listener;

import com.suyan.mall.order.biz.OrderBiz;
import com.suyan.mall.order.events.OrderCreateEvent;
import com.suyan.mall.order.events.OrderCreateEventContext;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建订单
 */
@Component
@Order(2)
@Slf4j
public class OrderListener implements ApplicationListener<OrderCreateEvent> {

    @Autowired
    private OrderBiz orderBiz;

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        log.info("创建订单-生成订单");
        OrderCreateEventContext context = event.getContext();
        OrderVO orderVO = orderBiz.createOrder(context.getOrder(), context.getUser());
        context.setOrderVO(orderVO);
        log.info("生成订单信息:{}", JsonUtil.toJsonString(orderVO));
    }

}

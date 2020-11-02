/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.events.listener;

import com.suyan.exception.CommonException;
import com.suyan.mall.order.events.OrderCreateEvent;
import com.suyan.mall.user.feignClient.c.DeliverAddressCFeignClient;
import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.result.Result;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 获取收货人信息
 */
@Component
@Order(1)
@Slf4j
public class OrderDeliverAddressListener implements ApplicationListener<OrderCreateEvent> {

    @Autowired
    private DeliverAddressCFeignClient deliverAddressCFeignClient;

    @Override
    public void onApplicationEvent(OrderCreateEvent event) {
        log.info("创建订单-获取收货人信息");
        com.suyan.mall.order.model.Order order = event.getContext().getOrder();
        Long deliverAddressId = order.getDeliverAddressId();
        log.info("调用用户获取收货地址信息入参={}", deliverAddressId);
        Result<DeliverAddressVO> result = deliverAddressCFeignClient.get(deliverAddressId);
        log.info("调用用户获取收货地址信息出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(result.getCode(), result.getMessage());
        }
        DeliverAddressVO data = result.getData();
        // 设置收货人信息
        order.setConsignee(data.getConsignee());
        order.setMobile(data.getMobile());
        order.setAddress(data.getAddress());
    }

}

package com.suyan.mall.order.events;

import com.suyan.mall.order.model.Order;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import lombok.Builder;
import lombok.Data;

/**
 * 创建订单用到的数据
 */
@Data
@Builder
public class OrderCreateEventContext {

    /**
     * 用户信息
     */
    private UserInfoVO user;

    /**
     * 订单入参
     */
    private Order order;

    /**
     * 订单出参
     */
    private OrderVO orderVO;

}

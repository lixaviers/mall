package com.suyan.mall.order.service.impl;

import com.suyan.mall.order.biz.OrderBiz;
import com.suyan.mall.order.convertor.OrderConvertor;
import com.suyan.mall.order.events.OrderCreateEventPublisher;
import com.suyan.mall.order.req.OrderDTO;
import com.suyan.mall.order.req.OrderQueryDTO;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.mall.order.service.IOrderService;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 订单管理类>
 */
@Slf4j
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderBiz orderBiz;

    @Autowired
    private OrderCreateEventPublisher orderCreateEventPublisher;

    @Override
    public int deleteOrder(Long id) {
        return orderBiz.deleteOrder(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public OrderVO createOrder(OrderDTO orderDTO) {
        UserInfoVO user = UserUtil.getUser();
        // 观察者模式，通过事件机制通知相关业务组件保存数据
        return orderCreateEventPublisher.createOrder(user, OrderConvertor.toOrder(orderDTO));
    }

    @Override
    public int updateOrder(OrderDTO orderDTO) {
        return orderBiz.updateOrder(OrderConvertor.toOrder(orderDTO));
    }

    @Override
    public OrderVO getOrder(String orderNumber) {
        return OrderConvertor.toOrderVO(orderBiz.getOrder(orderNumber));
    }

    @Override
    public QueryResultVO<OrderVO> queryOrder(OrderQueryDTO orderQueryDTO) {
        return OrderConvertor.toQueryResult(orderBiz.queryOrder(orderQueryDTO));
    }

}
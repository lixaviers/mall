package com.suyan.mall.order.convertor;

import com.suyan.mall.order.model.Order;
import com.suyan.mall.order.req.OrderDTO;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class OrderConvertor {

    private static final BeanCopier beanCopierForOrderVO = BeanCopier.create(Order.class, OrderVO.class, false);
    private static final BeanCopier beanCopierForOrder = BeanCopier.create(OrderDTO.class, Order.class, false);

    public static OrderVO toOrderVO(Order order) {
        if (order == null) {
            return null;
        }
        OrderVO orderVO = new OrderVO();
        beanCopierForOrderVO.copy(order, orderVO, null);
        return orderVO;
    }

    public static Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        beanCopierForOrder.copy(orderDTO, order, null);
        order.setOrderGoodsList(OrderGoodsConvertor.toOrderGoodsList(orderDTO.getOrderGoodsList()));
        return order;
    }

    public static List<OrderVO> toOrderVOList(List<Order> orderList) {
        if (orderList == null || orderList.isEmpty()) {
            return null;
        }
        List<OrderVO> orderInfoList = new ArrayList<OrderVO>(orderList.size());
        for (Order order : orderList) {
            orderInfoList.add(toOrderVO(order));
        }
        return orderInfoList;
    }

    public static List<Order> toOrderList(List<OrderDTO> orderDTOList) {
        if (orderDTOList == null || orderDTOList.isEmpty()) {
            return null;
        }
        List<Order> orderList = new ArrayList<Order>(orderDTOList.size());
        for (OrderDTO orderDTO : orderDTOList) {
            orderList.add(toOrder(orderDTO));
        }
        return orderList;
    }

    public static QueryResultVO<OrderVO> toQueryResult(QueryResultVO<Order> queryResult) {
        QueryResultVO<OrderVO> queryResultInfo = new QueryResultVO<OrderVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toOrderVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.service;

import com.suyan.mall.order.req.OrderDTO;
import com.suyan.mall.order.req.OrderQueryDTO;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IOrderService {

    /**
     * 删除订单
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteOrder(Long id);
    
    /**
     * 创建订单
     * 
     * @param orderDTO
     * @return
     */
    OrderVO createOrder(OrderDTO orderDTO);


    /**
     * 更新订单
     * 
     * @param orderDTO
     * @return
     */
    int updateOrder(OrderDTO orderDTO);
    
    /**
     * 根据订单号获取订单信息
     * 
     * @param orderNumber
     * @return
     */
    OrderVO getOrder(String orderNumber);

    /**
     * 分页查询订单信息
     * 
     * @param orderQueryDTO
     * @return
     */
    QueryResultVO<OrderVO> queryOrder(OrderQueryDTO orderQueryDTO);



}
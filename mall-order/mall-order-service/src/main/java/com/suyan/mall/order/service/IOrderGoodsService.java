/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.service;

import com.suyan.mall.order.req.OrderGoodsDTO;
import com.suyan.mall.order.req.OrderGoodsQueryDTO;
import com.suyan.mall.order.resp.OrderGoodsVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IOrderGoodsService {

    /**
     * 删除订单商品
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteOrderGoods(Long id);
    
    /**
     * 根据ID获取订单商品信息
     * 
     * @param id
     * @return
     */
    OrderGoodsVO getOrderGoods(Long id);

    /**
     * 分页查询订单商品信息
     * 
     * @param orderGoodsQueryDTO
     * @return
     */
    QueryResultVO<OrderGoodsVO> queryOrderGoods(OrderGoodsQueryDTO orderGoodsQueryDTO);



}
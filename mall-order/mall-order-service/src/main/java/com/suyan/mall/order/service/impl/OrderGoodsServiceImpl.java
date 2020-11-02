/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.service.impl;

import com.suyan.mall.order.service.IOrderGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.order.biz.OrderGoodsBiz;
import com.suyan.mall.order.convertor.OrderGoodsConvertor;
import com.suyan.mall.order.model.OrderGoods;
import com.suyan.mall.order.req.OrderGoodsDTO;
import com.suyan.mall.order.req.OrderGoodsQueryDTO;
import com.suyan.mall.order.resp.OrderGoodsVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 订单商品管理类>
 */
@Slf4j
@Service("orderGoodsService")
public class OrderGoodsServiceImpl implements IOrderGoodsService {

    @Autowired
    private OrderGoodsBiz orderGoodsBiz;

    @Override
    public int deleteOrderGoods(Long id) {
        return orderGoodsBiz.deleteOrderGoods(id);
    }

    @Override
    public OrderGoodsVO getOrderGoods(Long id ) {
        return OrderGoodsConvertor.toOrderGoodsVO(orderGoodsBiz.getOrderGoods(id));
    }

    @Override
    public QueryResultVO<OrderGoodsVO> queryOrderGoods(OrderGoodsQueryDTO orderGoodsQueryDTO) {
        return OrderGoodsConvertor.toQueryResult(orderGoodsBiz.queryOrderGoods(orderGoodsQueryDTO));
    }

}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.dao;

import com.suyan.mall.order.model.Order;
import com.suyan.mall.order.model.OrderExample;
import com.suyan.mall.order.req.OrderQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderMapper {
    
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Order selectByPrimaryKeyForUpdate(Long id);

    List<Order> queryOrder(OrderQueryDTO orderQuery);

    int insertBatch(@Param("modelList") List<Order> modelList);


    Order selectByOrderNumber(@Param("orderNumber") String orderNumber);    
    
    List<Order> selectByShopId(@Param("shopId") Long shopId);
    
    List<Order> selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);


}
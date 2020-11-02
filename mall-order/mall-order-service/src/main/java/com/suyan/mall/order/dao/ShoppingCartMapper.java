/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.dao;

import com.suyan.mall.order.model.ShoppingCart;
import com.suyan.mall.order.model.ShoppingCartExample;
import com.suyan.mall.order.req.ShoppingCartQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShoppingCartMapper {
    
    long countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    ShoppingCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    ShoppingCart selectByPrimaryKeyForUpdate(Long id);

    List<ShoppingCart> queryShoppingCart(ShoppingCartQueryDTO shoppingCartQuery);

    int insertBatch(@Param("modelList") List<ShoppingCart> modelList);

    
    List<ShoppingCart> selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);


}
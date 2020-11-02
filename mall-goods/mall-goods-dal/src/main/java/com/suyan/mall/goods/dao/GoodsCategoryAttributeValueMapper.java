/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsCategoryAttributeValue;
import com.suyan.mall.goods.model.GoodsCategoryAttributeValueExample;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsCategoryAttributeValueMapper {
    
    long countByExample(GoodsCategoryAttributeValueExample example);

    int deleteByExample(GoodsCategoryAttributeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategoryAttributeValue record);

    int insertSelective(GoodsCategoryAttributeValue record);

    List<GoodsCategoryAttributeValue> selectByExample(GoodsCategoryAttributeValueExample example);

    GoodsCategoryAttributeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCategoryAttributeValue record, @Param("example") GoodsCategoryAttributeValueExample example);

    int updateByExample(@Param("record") GoodsCategoryAttributeValue record, @Param("example") GoodsCategoryAttributeValueExample example);

    int updateByPrimaryKeySelective(GoodsCategoryAttributeValue record);

    int updateByPrimaryKey(GoodsCategoryAttributeValue record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsCategoryAttributeValue selectByPrimaryKeyForUpdate(Long id);

    List<GoodsCategoryAttributeValue> queryGoodsCategoryAttributeValue(GoodsCategoryAttributeValueQueryDTO goodsCategoryAttributeValueQuery);

    int insertBatch(@Param("modelList") List<GoodsCategoryAttributeValue> modelList);

    
    List<GoodsCategoryAttributeValue> selectByGoodsCategoryAttributeId(@Param("goodsCategoryAttributeId") Long goodsCategoryAttributeId);


}
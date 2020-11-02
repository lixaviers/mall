/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsAttribute;
import com.suyan.mall.goods.model.GoodsAttributeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsAttributeMapper {

    long countByExample(GoodsAttributeExample example);

    int deleteByExample(GoodsAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsAttribute record);

    int insertSelective(GoodsAttribute record);

    List<GoodsAttribute> selectByExample(GoodsAttributeExample example);

    GoodsAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsAttribute record, @Param("example") GoodsAttributeExample example);

    int updateByExample(@Param("record") GoodsAttribute record, @Param("example") GoodsAttributeExample example);

    int updateByPrimaryKeySelective(GoodsAttribute record);

    int updateByPrimaryKey(GoodsAttribute record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsAttribute selectByPrimaryKeyForUpdate(Long id);

    int insertBatch(@Param("modelList") List<GoodsAttribute> modelList);


    List<GoodsAttribute> selectByGoodsCategoryAttributeId(@Param("goodsCategoryAttributeId") Long goodsCategoryAttributeId);

    List<GoodsAttribute> selectByGoodsCategoryAttributeValueId(@Param("goodsCategoryAttributeValueId") Long goodsCategoryAttributeValueId);

    List<GoodsAttribute> selectByGoodsId(@Param("goodsId") Long goodsId);


}
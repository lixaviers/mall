/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsDescription;
import com.suyan.mall.goods.model.GoodsDescriptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDescriptionMapper {

    long countByExample(GoodsDescriptionExample example);

    int deleteByExample(GoodsDescriptionExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsDescription record);

    int insertSelective(GoodsDescription record);

    List<GoodsDescription> selectByExampleWithBLOBs(GoodsDescriptionExample example);

    List<GoodsDescription> selectByExample(GoodsDescriptionExample example);

    GoodsDescription selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") GoodsDescription record, @Param("example") GoodsDescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsDescription record, @Param("example") GoodsDescriptionExample example);

    int updateByExample(@Param("record") GoodsDescription record, @Param("example") GoodsDescriptionExample example);

    int updateByPrimaryKeySelective(GoodsDescription record);

    int updateByPrimaryKeyWithBLOBs(GoodsDescription record);


    GoodsDescription selectByPrimaryKeyForUpdate(Long goodsId);


}
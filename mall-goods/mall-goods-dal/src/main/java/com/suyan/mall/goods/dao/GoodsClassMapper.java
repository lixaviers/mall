/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsClass;
import com.suyan.mall.goods.model.GoodsClassExample;
import com.suyan.mall.goods.req.GoodsClassQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsClassMapper {
    
    long countByExample(GoodsClassExample example);

    int deleteByExample(GoodsClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsClass record);

    int insertSelective(GoodsClass record);

    List<GoodsClass> selectByExample(GoodsClassExample example);

    GoodsClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsClass record, @Param("example") GoodsClassExample example);

    int updateByExample(@Param("record") GoodsClass record, @Param("example") GoodsClassExample example);

    int updateByPrimaryKeySelective(GoodsClass record);

    int updateByPrimaryKey(GoodsClass record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsClass selectByPrimaryKeyForUpdate(Long id);

    List<GoodsClass> queryGoodsClass(GoodsClassQueryDTO goodsClassQuery);

    int insertBatch(@Param("modelList") List<GoodsClass> modelList);



}
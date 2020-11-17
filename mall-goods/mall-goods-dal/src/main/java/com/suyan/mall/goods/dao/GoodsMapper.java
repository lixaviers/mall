/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsExample;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Goods selectByPrimaryKeyForUpdate(Long id);

    List<Goods> queryGoods(GoodsQueryDTO goodsQuery);

    int insertBatch(@Param("modelList") List<Goods> modelList);

    
    List<Goods> selectByGoodsClassId(@Param("goodsClassId") Long goodsClassId);


}
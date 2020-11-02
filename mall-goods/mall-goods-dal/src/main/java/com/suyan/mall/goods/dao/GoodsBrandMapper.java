/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.model.GoodsBrandExample;
import com.suyan.mall.goods.req.GoodsBrandQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsBrandMapper {
    
    long countByExample(GoodsBrandExample example);

    int deleteByExample(GoodsBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsBrand record);

    int insertSelective(GoodsBrand record);

    List<GoodsBrand> selectByExample(GoodsBrandExample example);

    GoodsBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByExample(@Param("record") GoodsBrand record, @Param("example") GoodsBrandExample example);

    int updateByPrimaryKeySelective(GoodsBrand record);

    int updateByPrimaryKey(GoodsBrand record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Integer id
    );

    GoodsBrand selectByPrimaryKeyForUpdate(Integer id);

    List<GoodsBrand> queryGoodsBrand(GoodsBrandQueryDTO goodsBrandQuery);

    int insertBatch(@Param("modelList") List<GoodsBrand> modelList);



}
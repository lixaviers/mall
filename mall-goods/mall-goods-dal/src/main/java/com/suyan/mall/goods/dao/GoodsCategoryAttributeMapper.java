/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import com.suyan.mall.goods.model.GoodsCategoryAttributeExample;
import com.suyan.mall.goods.req.GoodsCategoryAttributeQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsCategoryAttributeMapper {
    
    long countByExample(GoodsCategoryAttributeExample example);

    int deleteByExample(GoodsCategoryAttributeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategoryAttribute record);

    int insertSelective(GoodsCategoryAttribute record);

    List<GoodsCategoryAttribute> selectByExample(GoodsCategoryAttributeExample example);

    GoodsCategoryAttribute selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCategoryAttribute record, @Param("example") GoodsCategoryAttributeExample example);

    int updateByExample(@Param("record") GoodsCategoryAttribute record, @Param("example") GoodsCategoryAttributeExample example);

    int updateByPrimaryKeySelective(GoodsCategoryAttribute record);

    int updateByPrimaryKey(GoodsCategoryAttribute record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsCategoryAttribute selectByPrimaryKeyForUpdate(Long id);

    List<GoodsCategoryAttribute> queryGoodsCategoryAttribute(GoodsCategoryAttributeQueryDTO goodsCategoryAttributeQuery);

    int insertBatch(@Param("modelList") List<GoodsCategoryAttribute> modelList);

    
    List<GoodsCategoryAttribute> selectByCategoryId(@Param("categoryId") Integer categoryId);


}
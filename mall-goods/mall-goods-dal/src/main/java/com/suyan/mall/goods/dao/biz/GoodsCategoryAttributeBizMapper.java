/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsCategoryAttributeMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryAttributeBizMapper extends GoodsCategoryAttributeMapper {

    int getMaxSortNumberByCategoryId(@Param("categoryId") Integer categoryId);

    List<GoodsCategoryAttribute> getTreeByCategoryId(@Param("categoryId") Integer categoryId);

}
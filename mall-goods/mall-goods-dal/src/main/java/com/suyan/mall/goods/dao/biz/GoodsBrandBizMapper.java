/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsBrandMapper;
import com.suyan.mall.goods.model.GoodsBrand;

import java.util.List;

public interface GoodsBrandBizMapper extends GoodsBrandMapper {
    
    List<GoodsBrand> getGoodsBrandListByCategoryId(Integer categoryId);

}
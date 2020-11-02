/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsMapper;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsBizMapper extends GoodsMapper {

    int updateInventory(@Param("id") Long id);

}
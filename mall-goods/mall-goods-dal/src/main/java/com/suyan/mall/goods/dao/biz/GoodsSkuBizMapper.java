/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsSkuMapper;
import org.apache.ibatis.annotations.Param;

public interface GoodsSkuBizMapper extends GoodsSkuMapper {

    String getMaxSkuCode();

    /**
     * 扣减库存
     *
     * @param id
     * @param inventory
     * @return
     */
    int deductionInventory(@Param("id") Long id, @Param("inventory") int inventory);

    int deductionInventorySku(@Param("skuCode") String skuCode, @Param("inventory") int inventory);

    /**
     * 加库存
     *
     * @param id
     * @param inventory
     * @return
     */
    int addInventory(@Param("id") Long id, @Param("inventory") int inventory);

    int getSumInventoryByGoodsId(@Param("goodsId") Long goodsId);

}
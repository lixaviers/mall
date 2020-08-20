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
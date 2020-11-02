/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import com.suyan.mall.goods.req.c.GoodsSkuDeductionInventoryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格管理类>
 */
public interface IGoodsSkuService {

    /**
     * 分页查询商品规格信息
     *
     * @param goodsSkuQueryDTO
     * @return
     */
    QueryResultVO<GoodsSkuVO> queryGoodsSku(GoodsSkuQueryDTO goodsSkuQueryDTO);

    /**
     * 根据商品编码查询商品规格信息
     *
     * @param skuCode
     * @return
     */
    GoodsSkuVO getGoodsSku(String skuCode);

    List<GoodsSkuVO> getGoodsSku(List<String> skuCodeList);

    /**
     * 修改库存
     *
     * @param logDTO
     */
    void updateInventory(GoodsSkuInventoryLogDTO logDTO);

    /**
     * 批量扣减库存
     *
     * @param dto
     */
    void deductionInventory(GoodsSkuDeductionInventoryDTO dto);

}
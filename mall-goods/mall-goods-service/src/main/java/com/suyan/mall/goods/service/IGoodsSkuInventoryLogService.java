/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

import com.suyan.mall.goods.req.GoodsSkuInventoryLogQueryDTO;
import com.suyan.mall.goods.resp.GoodsSkuInventoryLogVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IGoodsSkuInventoryLogService {


    /**
     * 分页查询商品sku库存日志信息
     *
     * @param goodsSkuInventoryLogQueryDTO
     * @return
     */
    QueryResultVO<GoodsSkuInventoryLogVO> queryGoodsSkuInventoryLog(GoodsSkuInventoryLogQueryDTO goodsSkuInventoryLogQueryDTO);


}
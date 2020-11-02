/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.biz.async;

import com.suyan.mall.goods.dao.GoodsSkuInventoryLogMapper;
import com.suyan.mall.goods.model.GoodsSkuInventoryLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层商品sku库存日志管理类>
 */
@Slf4j
@Service
public class GoodsSkuInventoryLogAsyncBiz {

    @Autowired
    private GoodsSkuInventoryLogMapper goodsSkuInventoryLogMapper;

    /**
     * 异步创建商品sku库存日志
     *
     * @param goodsSkuInventoryLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Async
    public Long createGoodsSkuInventoryLog(GoodsSkuInventoryLog goodsSkuInventoryLog) {
        goodsSkuInventoryLogMapper.insertSelective(goodsSkuInventoryLog);
        return goodsSkuInventoryLog.getId();
    }


}
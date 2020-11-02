/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.dao.biz.GoodsBizMapper;
import com.suyan.mall.goods.dao.biz.GoodsSkuBizMapper;
import com.suyan.mall.goods.es.repository.GoodsRepository;
import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.service.ConsumerService;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsSkuConsumerService")
@Slf4j
public class GoodsSkuConsumerServiceImpl implements ConsumerService<GoodsSku, Long> {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsBizMapper goodsBizMapper;
    @Autowired
    private GoodsSkuBizMapper goodsSkuBizMapper;

    @Override
    public void save(GoodsSku goods) {
        log.info("GoodsSkuConsumerServiceImpl save:{}", JsonUtil.toJsonString(goods));
        // 更新商品库存
        goodsBizMapper.updateInventory(goods.getGoodsId());
    }

    @Override
    public void update(GoodsSku goods) {
        log.info("GoodsSkuConsumerServiceImpl update:{}", JsonUtil.toJsonString(goods));
        // 更新商品库存
        goodsBizMapper.updateInventory(goods.getGoodsId());
    }

    @Override
    public void delete(GoodsSku goods) {
        log.info("delete:{}", JsonUtil.toJsonString(goods));
        goodsRepository.deleteById(goods.getId());
    }

}

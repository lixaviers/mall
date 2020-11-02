/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.es.repository;

import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.model.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsRepository extends ElasticsearchRepository<GoodsES, Long> {

    GoodsES getGoodsById(Long id);

}
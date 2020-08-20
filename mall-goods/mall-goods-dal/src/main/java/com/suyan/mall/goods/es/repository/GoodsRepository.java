package com.suyan.mall.goods.es.repository;

import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.model.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsRepository extends ElasticsearchRepository<GoodsES, Long> {

    GoodsES getGoodsById(Long id);

}
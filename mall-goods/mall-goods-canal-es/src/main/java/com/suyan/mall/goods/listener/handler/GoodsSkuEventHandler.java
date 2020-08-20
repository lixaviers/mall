package com.suyan.mall.goods.listener.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.service.impl.GoodsConsumerServiceImpl;
import com.suyan.mall.goods.service.impl.GoodsSkuConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GoodsSkuEventHandler extends AbstractSimpleEventHandler<GoodsSku> {

    @Autowired
    public GoodsSkuEventHandler(ObjectMapper objectMapper, GoodsSkuConsumerServiceImpl goodsSkuConsumerService) {
        super(goodsSkuConsumerService);
    }

    @PostConstruct
    public void init() {
        initActions();
    }

}

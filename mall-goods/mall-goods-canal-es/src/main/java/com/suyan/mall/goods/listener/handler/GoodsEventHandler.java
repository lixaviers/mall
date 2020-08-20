package com.suyan.mall.goods.listener.handler;

import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.service.impl.GoodsConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GoodsEventHandler extends AbstractSimpleEventHandler<Goods> {

    @Autowired
    public GoodsEventHandler(GoodsConsumerServiceImpl goodsConsumerService) {
        super(goodsConsumerService);
    }

    @PostConstruct
    public void init() {
        initActions();
    }

}

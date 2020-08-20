package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.es.model.GoodsES;
import com.suyan.mall.goods.es.repository.GoodsRepository;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.service.ConsumerService;
import com.suyan.utils.BeanUtil;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsConsumerService")
@Slf4j
public class GoodsConsumerServiceImpl implements ConsumerService<Goods, Long> {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public void save(Goods goods) {
        log.info("GoodsConsumerServiceImpl save:{}", JsonUtil.toJsonString(goods));
        GoodsES goodsES = BeanUtil.fastBeanCopy(goods, GoodsES.class);
        goodsRepository.save(goodsES);
    }

    @Override
    public void update(Goods obj) {
        log.info("update:{}", JsonUtil.toJsonString(obj));
    }

    @Override
    public void delete(Goods obj) {
        log.info("delete:{}", JsonUtil.toJsonString(obj));
    }

}

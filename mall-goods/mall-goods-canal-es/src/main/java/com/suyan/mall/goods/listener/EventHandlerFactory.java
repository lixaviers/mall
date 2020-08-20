package com.suyan.mall.goods.listener;

import com.google.common.collect.Maps;
import com.suyan.mall.goods.listener.handler.GoodsEventHandler;
import com.suyan.mall.goods.listener.handler.GoodsSkuEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class EventHandlerFactory {

    private GoodsEventHandler goodsEventHandler;
    private GoodsSkuEventHandler goodsSkuEventHandler;

    private final Map<String, EventHandler> handlers = Maps.newConcurrentMap();

    @PostConstruct
    public void init() {
        log.info("Initializing events handlers");
        handlers.put("tb_goods", goodsEventHandler);
        handlers.put("tb_goods_sku", goodsSkuEventHandler);
    }

    public EventHandler getHandler(String tableName) {
        Assert.hasText(tableName, "tableName cannot be null/empty");
        log.info("Request to use a handler for the table {}", tableName);
        return Optional.ofNullable(handlers.get(tableName)).orElseThrow(() -> new IllegalArgumentException("No suitable handler was found for the table " + tableName));
    }

    @Autowired
    public EventHandlerFactory(GoodsEventHandler goodsEventHandler, GoodsSkuEventHandler goodsSkuEventHandler) {
        this.goodsEventHandler = goodsEventHandler;
        this.goodsSkuEventHandler = goodsSkuEventHandler;
    }

}

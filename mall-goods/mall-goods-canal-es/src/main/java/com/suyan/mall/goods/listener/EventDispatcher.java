package com.suyan.mall.goods.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "goods", consumerGroup = "goodsGroup")
@Slf4j
public class EventDispatcher implements RocketMQListener<String> {

    private EventHandlerFactory handlerFactory;

    @Override
    public void onMessage(String str) {
        log.info("goods RocketMQMessageListener str:{}", str);
        CanalDate canalDate = JSON.parseObject(str, CanalDate.class);
        String table = canalDate.getTable();
        try {
            handlerFactory.getHandler(table).process(canalDate);
        } catch (IllegalArgumentException e) {
            log.warn(e.getMessage());
        }
    }

    @Autowired
    public EventDispatcher(EventHandlerFactory handlerFactory) {
        this.handlerFactory = handlerFactory;
    }

}

package com.suyan.mall.goods.listener.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.suyan.mall.goods.listener.CanalDate;
import com.suyan.mall.goods.listener.EventHandler;
import com.suyan.mall.goods.service.ConsumerService;
import com.suyan.utils.CollectionsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.GenericTypeResolver;

import java.util.Map;
import java.util.function.BiConsumer;

@RequiredArgsConstructor
@Slf4j
public class AbstractSimpleEventHandler<T> implements EventHandler {

    protected final Map<String, BiConsumer<T, T>> actions = Maps.newConcurrentMap();

    private final ObjectMapper objectMapper;

    private final ConsumerService consumerService;

    public void initActions() {
        actions.put("INSERT", (before, after) -> consumerService.save(after));
        actions.put("UPDATE", (before, after) -> consumerService.update(after));
        actions.put("DELETE", (before, after) -> consumerService.delete(after));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(CanalDate canalDate) {
        Class<T> entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractSimpleEventHandler.class);
        BiConsumer<T, T> ttBiConsumer = actions.get(canalDate.getType());
        if (ttBiConsumer == null) {
            log.warn("not support actions:{}", canalDate.getType());
            return;
        }
        if (CollectionsUtil.isNotEmpty(canalDate.getData())) {
            for (Object object : canalDate.getData()) {
                T after = JSON.parseObject(object.toString(), entityClass);
                // T after = objectMapper.convertValue(canalDate.getData().get(0), entityClass);
                actions.get(canalDate.getType()).accept(after, after);
            }
        }
    }

}

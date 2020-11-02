/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.utils;

import com.suyan.mall.user.constants.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis操作util
 */
@Component
public class RedisUtil {
    private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }

    private static Random random = new Random();

    private static String getRealKey(String key) {
        if (!key.contains(Constant.REDIS_PREFIX)) {
            return Constant.REDIS_PREFIX + key;
        }
        return key;
    }

    /**
     * 根据key查询
     *
     * @param key 键值
     * @return object
     */
    public static Object get(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(getRealKey(key));
    }

    /**
     * 根据key设置值，并附加过期时间
     *
     * @param key
     * @param value
     * @param unit    时间单位
     * @param timeout 超时时间
     */
    public static void set(String key, Object value, int timeout, TimeUnit unit) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        key = getRealKey(key);
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 根据key重新设置过期时间
     *
     * @param key
     * @param unit    时间单位
     * @param timeout 超时时间
     */
    public static void expire(String key, int timeout, TimeUnit unit) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        key = getRealKey(key);
        redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 删除
     *
     * @param key
     */
    public static void delete(String key) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        key = getRealKey(key);
        redisTemplate.delete(key);
    }

    public static Set keys(String keys) {
        if (StringUtils.isEmpty(keys)) {
            return null;
        }
        keys = getRealKey(keys);
        return redisTemplate.keys(keys);
    }


}

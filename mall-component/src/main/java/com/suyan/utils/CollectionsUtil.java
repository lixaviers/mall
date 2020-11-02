/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 */
public class CollectionsUtil {
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 集合中某个BigDecimal字段求和
     *
     * @param cols     集合
     * @param propName 字段名
     * @param clazz    类名
     * @param <T>
     * @return
     */
    public static <T> BigDecimal sum(List<T> cols, String propName, Class<T> clazz) {
        if (cols == null || cols.size() < 1) return null;

        BigDecimal result = BigDecimal.ZERO;

        try {
            for (T c : cols) {
                Field field = clazz.getDeclaredField(propName);
                field.setAccessible(true);
                BigDecimal value = (BigDecimal) field.get(c);

                result = result.add(value);
            }
        } catch (Exception ex) {
            return null;
        }
        return result;
    }
}
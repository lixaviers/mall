/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.service;

public interface ConsumerService<T, ID> {

    /**
     * 新增
     *
     * @param obj
     */
    void save(T obj);

    /**
     * 修改
     *
     * @param obj
     */
    void update(T obj);

    /**
     * 删除
     *
     * @param obj
     */
    void delete(T obj);

}

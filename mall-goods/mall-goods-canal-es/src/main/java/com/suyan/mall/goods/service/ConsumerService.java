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

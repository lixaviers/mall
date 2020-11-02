/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.listener;

import lombok.Data;

import java.util.List;

@Data
public class CanalDate<T> {

    /**
     * id
     */
    private Long id;
    /**
     * 数据库
     */
    private String database;
    /**
     * 表
     */
    private String table;
    /**
     * 旧字段
     */
    private String old;
    /**
     * 类型
     */
    private String type;
    private List<T> data;

}

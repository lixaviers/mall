/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import lombok.Data;

@Data
public class GoodsSpecification {

    /**
     * 规格名称
     */
    private String name;

    /**
     * 规格值
     */
    private String[] values;

}
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
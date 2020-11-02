/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsSpecificationName {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 规格名称
     */
    private String specificationName;
    
    /**
     * 商品类目id
     */
    private Integer goodsCategoryId;
    
    /**
     * 是否颜色属性
     */
    private Boolean isColorAttribute;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
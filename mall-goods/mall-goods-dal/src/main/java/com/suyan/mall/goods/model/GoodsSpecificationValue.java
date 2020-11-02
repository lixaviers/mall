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
public class GoodsSpecificationValue {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品id
     */
    private Long goodsId;
    
    /**
     * 规格id
     */
    private Long specificationId;
    
    /**
     * 规格名
     */
    private String specificationName;
    
    /**
     * 规格值
     */
    private String specificationValue;
    
    /**
     * 排序
     */
    private Integer sortNumber;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 是否删除: 0.未删除 1.已删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
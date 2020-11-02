/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PromotionScope {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 促销类型
     */
    private Byte promotionType;
    
    /**
     * 促销id
     */
    private Long promotionId;
    
    /**
     * 商品类目id
     */
    private Integer goodsCategoryId;
    
    /**
     * 商品类目名称
     */
    private String goodsCategoryName;
    
    /**
     * 商品sku编码
     */
    private String goodsSkuCode;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GoodsSkuInventoryLog {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品编码
     */
    private String goodsSkuCode;
    
    /**
     * 库存方式 1.占用 2.归还
     */
    private Byte inventoryWay;
    
    /**
     * 占用库存
     */
    private Integer inventory;
    
    /**
     * 类型 3.砍价
     */
    private Byte logType;
    
    /**
     * 关联id
     */
    private Long associatedId;
    
    /**
     * 关联描述
     */
    private String associatedDesc;
    
    /**
     * 备注
     */
    private String remark;
    
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
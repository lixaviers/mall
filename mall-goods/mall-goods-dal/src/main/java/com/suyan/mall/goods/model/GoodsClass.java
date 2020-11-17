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
public class GoodsClass {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 父id
     */
    private Long parentId;
    
    /**
     * 店铺id
     */
    private Long shopId;
    
    /**
     * 分类名称
     */
    private String className;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
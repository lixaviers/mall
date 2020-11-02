/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ShopCollect {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 用户唯一标识
     */
    private String uniqueUserId;
    
    /**
     * 店铺id
     */
    private Long shopId;
    
    /**
     * 是否置顶
     */
    private Boolean isTop;
    
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
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
public class BargainActivity {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 店铺id
     */
    private Long shopId;
    
    /**
     * 活动名称
     */
    private String activityName;
    
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    
    /**
     * 活动规则
     */
    private String activityRule;
    
    /**
     * 活动状态
     */
    private Byte activityStatus;
    
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
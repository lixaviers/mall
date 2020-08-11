package com.suyan.mall.mmc.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Bargain {


    /**
     * id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    /**
     * 有效期类型 1.24h 2.48h 3.72h
     */
    private Byte validityDateType;

    /**
     * 商品编码
     */
    private String goodsSkuCode;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer inventory;

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

    /**
     * 砍价阶段
     */
    private List<BargainItem> bargainItemList;


}
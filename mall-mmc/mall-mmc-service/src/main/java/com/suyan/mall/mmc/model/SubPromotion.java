/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SubPromotion {


    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 订单促销名称
     */
    private String subPromotionName;

    /**
     * 生效时间
     */
    private LocalDateTime startTime;

    /**
     * 失效时间
     */
    private LocalDateTime endTime;

    /**
     * 订单促销类型
     */
    private Byte subPromotionType;

    /**
     * 促销金额
     */
    private BigDecimal promotionAmount;

    /**
     * 订单满金额
     */
    private BigDecimal orderFullAmount;

    /**
     * 促销封顶金额
     */
    private BigDecimal promotionMaxAmount;

    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 订单金额范围及促销金额json
     */
    private String promotionScopeAmount;

    /**
     * 使用范围
     */
    private Byte subPromotionScope;

    /**
     * 订单促销状态
     */
    private Byte subPromotionStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除: 0.未删除 1.已删除
     */
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 订单金额范围及促销金额
     */
    private List<PromotionAmountScope> promotionAmountScopeList;

    /**
     * 使用范围
     */
    @ApiModelProperty("使用范围")
    private List<PromotionScope> promotionScopeList;


}
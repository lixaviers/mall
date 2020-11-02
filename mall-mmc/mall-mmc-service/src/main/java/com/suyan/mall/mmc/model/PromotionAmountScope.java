/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PromotionAmountScope {

    
    /**
     * 促销金额
     */
    private BigDecimal promotionAmount;
    
    /**
     * 订单满金额
     */
    private BigDecimal orderFullAmount;
    

}
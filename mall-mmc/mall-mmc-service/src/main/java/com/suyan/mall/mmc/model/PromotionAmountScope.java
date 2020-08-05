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
package com.suyan.mall.mmc.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PromotionAmountScopeVO {

    
    /**
     * 促销金额
     */
    @ApiModelProperty("促销金额")
    private BigDecimal promotionAmount;
    
    /**
     * 订单满金额
     */
    @ApiModelProperty("订单满金额")
    private BigDecimal orderFullAmount;
    

}
package com.suyan.mall.mmc.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SubPromotion {

    
    /**
     * 订单促销id
     */
    private Long id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 类型
     */
    private Byte typeId;
    
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    
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
     * 状态
     */
    private Byte promotionStatus;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否删除：0.未删除，1.已删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
package com.suyan.mall.mmc.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CouponChannel {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 优惠券id
     */
    private Long couponId;
    
    /**
     * 渠道id
     */
    private Byte channelId;
    
    /**
     * 库存
     */
    private Integer inventory;
    
    /**
     * 是否有发放时间
     */
    private Boolean isIssueTime;
    
    /**
     * 发放起始时间
     */
    private LocalDateTime issueStartTime;
    
    /**
     * 发放截止时间
     */
    private LocalDateTime issueEndTime;
    
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
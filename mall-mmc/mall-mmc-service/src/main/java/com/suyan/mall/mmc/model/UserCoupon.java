package com.suyan.mall.mmc.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserCoupon {

    
    /**
     * 主键id
     */
    private Long id;
    
    /**
     * 优惠券id
     */
    private Long couponId;
    
    /**
     * 券码
     */
    private String couponCode;
    
    /**
     * 用户openId
     */
    private String userOpenId;
    
    /**
     * 手机号
     */
    private String mobile;
    
    /**
     * 订单号
     */
    private String orderNo;
    
    /**
     * 状态
     */
    private Byte couponStatus;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 创建人
     */
    private String createUser;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 创建人名称
     */
    private String createUserName;
    
    /**
     * 更新人
     */
    private String updateUser;
    
    /**
     * 更新人名称
     */
    private String updateUserName;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
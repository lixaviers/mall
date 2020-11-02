/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserCouponDTO implements Serializable {

    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", hidden = true)
    @NotNull(message = "主键id不能为空", groups = UpdateInterface.class)
    private Long id;
        
    /**
     * 优惠券id
     */
    @ApiModelProperty("优惠券id")
    @NotNull(message = "优惠券id不能为空", groups = BaseInterface.class)
    private Long couponId;
        
    /**
     * 券码
     */
    @ApiModelProperty("券码")
    @NotNull(message = "券码不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "券码不能超过32位", groups = BaseInterface.class)
    private String couponCode;
        
    /**
     * 用户openId
     */
    @ApiModelProperty("用户openId")
    @NotNull(message = "用户openId不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "用户openId不能超过32位", groups = BaseInterface.class)
    private String userOpenId;
        
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空", groups = BaseInterface.class)
    @Size(max = 16, message = "手机号不能超过16位", groups = BaseInterface.class)
    private String mobile;
        
    /**
     * 订单号
     */
    @ApiModelProperty("订单号")
    @NotNull(message = "订单号不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "订单号不能超过32位", groups = BaseInterface.class)
    private String orderNo;
        
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @NotNull(message = "状态不能为空", groups = BaseInterface.class)
    private Byte couponStatus;
        
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createTime;
        
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createUser;
        
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    private LocalDateTime updateTime;
        
    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称", hidden = true)
    private String createUserName;
        
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人", hidden = true)
    private String updateUser;
        
    /**
     * 更新人名称
     */
    @ApiModelProperty(value = "更新人名称", hidden = true)
    private String updateUserName;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
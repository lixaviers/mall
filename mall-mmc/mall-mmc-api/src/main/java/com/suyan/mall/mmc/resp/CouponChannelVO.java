/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("优惠券渠道")
public class CouponChannelVO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 优惠券id
     */
    @ApiModelProperty("优惠券id")
    private Long couponId;

    /**
     * 渠道id
     */
    @ApiModelProperty("渠道id")
    private Byte channelId;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    private Integer inventory;

    /**
     * 是否有发放时间
     */
    @ApiModelProperty("是否有发放时间")
    private Boolean isIssueTime;

    /**
     * 发放起始时间
     */
    @ApiModelProperty("发放起始时间")
    private LocalDateTime issueStartTime;

    /**
     * 发放截止时间
     */
    @ApiModelProperty("发放截止时间")
    private LocalDateTime issueEndTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
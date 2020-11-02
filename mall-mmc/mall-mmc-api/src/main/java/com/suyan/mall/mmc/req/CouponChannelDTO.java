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
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CouponChannelDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty(value = "id", hidden = true)
    @NotNull(message = "id不能为空", groups = UpdateInterface.class)
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
    @NotNull(message = "渠道id不能为空", groups = BaseInterface.class)
    private Byte channelId;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    @NotNull(message = "库存不能为空", groups = BaseInterface.class)
    private Integer inventory;

    /**
     * 是否有发放时间
     */
    @ApiModelProperty("是否有发放时间")
    @NotNull(message = "是否有发放时间不能为空", groups = BaseInterface.class)
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
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
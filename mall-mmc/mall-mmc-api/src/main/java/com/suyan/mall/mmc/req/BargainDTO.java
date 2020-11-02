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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BargainDTO implements Serializable {

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
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    private Long shopId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    @NotNull(message = "开始时间不能为空", groups = BaseInterface.class)
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @NotNull(message = "结束时间不能为空", groups = BaseInterface.class)
    private LocalDateTime endTime;

    /**
     * 有效期类型 1.24h 2.48h 3.72h
     */
    @ApiModelProperty("有效期类型 1.24h 2.48h 3.72h")
    @NotNull(message = "有效期类型 1.24h 2.48h 3.72h不能为空", groups = BaseInterface.class)
    private Byte validityDateType;

    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "商品编码不能超过32位", groups = BaseInterface.class)
    private String goodsSkuCode;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    @NotNull(message = "价格不能为空", groups = BaseInterface.class)
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    @NotNull(message = "库存不能为空", groups = BaseInterface.class)
    private Integer inventory;

    /**
     * 活动规则
     */
    @ApiModelProperty("活动规则")
    @Size(max = 2000, message = "活动规则不能超过2000位", groups = BaseInterface.class)
    private String activityRule;

    /**
     * 活动状态
     */
    @ApiModelProperty("活动状态")
    private Byte activityStatus;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 砍价阶段
     */
    @ApiModelProperty("砍价阶段")
    @NotNull(message = "砍价阶段不能为空", groups = BaseInterface.class)
    private List<BargainItemDTO> bargainItemList;

}
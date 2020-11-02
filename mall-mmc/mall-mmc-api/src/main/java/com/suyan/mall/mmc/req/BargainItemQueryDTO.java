/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BargainItemQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("砍价id")
    private Long bargainId;

    @ApiModelProperty("砍价id列表")
    private List<Long> bargainIdList;

    @ApiModelProperty("最小人数")
    private Integer numberMin;

    @ApiModelProperty("最小人数列表")
    private List<Integer> numberMinList;

    @ApiModelProperty("最大人数")
    private Integer numberMax;

    @ApiModelProperty("最大人数列表")
    private List<Integer> numberMaxList;

    @ApiModelProperty("最小比例起")
    private BigDecimal promotionMinFrom;

    @ApiModelProperty("最小比例止")
    private BigDecimal promotionMinTo;

    @ApiModelProperty("最大比例起")
    private BigDecimal promotionMaxFrom;

    @ApiModelProperty("最大比例止")
    private BigDecimal promotionMaxTo;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsSearchDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("关键字")
    private String keyword;

    @ApiModelProperty("类目id")
    private Integer goodsCategoryId;

    @ApiModelProperty("品牌id")
    private Integer brandId;

    @ApiModelProperty("列表价起")
    private BigDecimal listPriceFrom;

    @ApiModelProperty("列表价止")
    private BigDecimal listPriceTo;

}
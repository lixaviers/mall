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

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PromotionScopeQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("促销类型")
    private Byte promotionType;

    @ApiModelProperty("促销类型列表")
    private List<Byte> promotionTypeList;

    @ApiModelProperty("促销id")
    private Long promotionId;

    @ApiModelProperty("促销id列表")
    private List<Long> promotionIdList;

    @ApiModelProperty("商品类目id")
    private Integer goodsCategoryId;

    @ApiModelProperty("商品类目id列表")
    private List<Integer> goodsCategoryIdList;

    @ApiModelProperty("商品类目名称")
    private String goodsCategoryName;

    @ApiModelProperty("商品类目名称列表")
    private List<String> goodsCategoryNameList;

    @ApiModelProperty("商品类目名称模糊字段")
    private String goodsCategoryNameLike;

    @ApiModelProperty("商品sku编码")
    private String goodsSkuCode;

    @ApiModelProperty("商品sku编码列表")
    private List<String> goodsSkuCodeList;

    @ApiModelProperty("商品sku编码模糊字段")
    private String goodsSkuCodeLike;

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
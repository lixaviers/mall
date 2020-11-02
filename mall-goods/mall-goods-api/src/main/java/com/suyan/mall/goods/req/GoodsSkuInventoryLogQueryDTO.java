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

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoodsSkuInventoryLogQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("商品编码")
    private String goodsSkuCode;

    @ApiModelProperty("商品编码列表")
    private List<String> goodsSkuCodeList;

    @ApiModelProperty("商品编码模糊字段")
    private String goodsSkuCodeLike;

    @ApiModelProperty("库存方式 1.占用 2.归还")
    private Byte inventoryWay;

    @ApiModelProperty("库存方式 1.占用 2.归还列表")
    private List<Byte> inventoryWayList;

    @ApiModelProperty("占用库存")
    private Integer inventory;

    @ApiModelProperty("占用库存列表")
    private List<Integer> inventoryList;

    @ApiModelProperty("类型 3.砍价")
    private Byte logType;

    @ApiModelProperty("类型 3.砍价列表")
    private List<Byte> logTypeList;

    @ApiModelProperty("关联id")
    private Long associatedId;

    @ApiModelProperty("关联id列表")
    private List<Long> associatedIdList;

    @ApiModelProperty("关联描述")
    private String associatedDesc;

    @ApiModelProperty("关联描述列表")
    private List<String> associatedDescList;

    @ApiModelProperty("关联描述模糊字段")
    private String associatedDescLike;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("备注列表")
    private List<String> remarkList;

    @ApiModelProperty("备注模糊字段")
    private String remarkLike;

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
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

import java.util.Date;
import java.util.List;

@Data
public class GoodsSpecificationValueQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品id列表")
    private List<Long> goodsIdList;

    @ApiModelProperty("规格id")
    private Long specificationId;

    @ApiModelProperty("规格id列表")
    private List<Long> specificationIdList;

    @ApiModelProperty("规格名")
    private String specificationName;

    @ApiModelProperty("规格名列表")
    private List<String> specificationNameList;

    @ApiModelProperty("规格名模糊字段")
    private String specificationNameLike;

    @ApiModelProperty("规格值")
    private String specificationValue;

    @ApiModelProperty("规格值列表")
    private List<String> specificationValueList;

    @ApiModelProperty("规格值模糊字段")
    private String specificationValueLike;

    @ApiModelProperty("排序")
    private Integer sortNumber;

    @ApiModelProperty("排序列表")
    private List<Integer> sortNumberList;

    @ApiModelProperty("创建时间起")
    private Date createTimeFrom;

    @ApiModelProperty("创建时间止")
    private Date createTimeTo;

    @ApiModelProperty("更新时间起")
    private Date updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private Date updateTimeTo;

    @ApiModelProperty("是否删除: 0.未删除 1.已删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除: 0.未删除 1.已删除列表")
    private List<Boolean> isDeletedList;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
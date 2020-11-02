/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("商品规格名")
public class GoodsSpecificationNameVO implements Serializable {

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
     * 规格名称
     */
    @ApiModelProperty("规格名称")
    private String name;

    /**
     * 商品类目id
     */
    @ApiModelProperty("商品类目id")
    private Integer goodsCategoryId;

    /**
     * 是否颜色属性
     */
    @ApiModelProperty("是否颜色属性")
    private Boolean isColorAttribute;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    @ApiModelProperty("规格值列表")
    private List<String> values;

}
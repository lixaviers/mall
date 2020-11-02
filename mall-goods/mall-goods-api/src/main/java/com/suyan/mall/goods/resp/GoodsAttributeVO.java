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

@Data
@ApiModel("商品属性值")
public class GoodsAttributeVO implements Serializable {

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
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long goodsId;

    /**
     * 商品类目属性id
     */
    @ApiModelProperty("商品类目属性id")
    private Long goodsCategoryAttributeId;

    /**
     * 商品类目属性名称
     */
    @ApiModelProperty("商品类目属性名称")
    private String goodsCategoryAttributeName;

    /**
     * 商品类目属性值id
     */
    @ApiModelProperty("商品类目属性值id")
    private Long goodsCategoryAttributeValueId;

    /**
     * 商品类目属性值名称
     */
    @ApiModelProperty("商品类目属性值名称")
    private String goodsCategoryAttributeValueName;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
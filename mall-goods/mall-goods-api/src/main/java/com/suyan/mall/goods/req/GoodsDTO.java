/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsDTO implements Serializable {

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
     * 商品分类id
     */
    @ApiModelProperty("商品分类id")
    private Long goodsClassId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @NotNull(message = "商品名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "商品名称不能超过64位", groups = BaseInterface.class)
    private String goodsName;

    /**
     * 类目id
     */
    @ApiModelProperty("类目id")
    @NotNull(message = "类目id不能为空", groups = BaseInterface.class)
    private Integer goodsCategoryId;

    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    @NotNull(message = "品牌id不能为空", groups = BaseInterface.class)
    private Integer brandId;

    /**
     * 是否多规格
     */
    @ApiModelProperty("是否多规格")
    @NotNull(message = "是否多规格不能为空", groups = BaseInterface.class)
    private Boolean isMoreSpec;

    /**
     * 规格值json
     */
    @ApiModelProperty("规格值json")
    @Size(max = 2000, message = "规格值json不能超过2000位", groups = BaseInterface.class)
    private String specValue;

    /**
     * 原价
     */
    @ApiModelProperty("原价")
    private BigDecimal originalPrice;

    /**
     * 列表价
     */
    @ApiModelProperty("列表价")
    private BigDecimal listPrice;

    /**
     * 起订量
     */
    @ApiModelProperty("起订量")
    @NotNull(message = "起订量不能为空", groups = BaseInterface.class)
    private Integer minimumQuantity;

    /**
     * 快递运费
     */
    @ApiModelProperty("快递运费")
    @NotNull(message = "快递运费不能为空", groups = BaseInterface.class)
    private BigDecimal expressFreight;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    @Size(max = 2000, message = "图片不能超过2000位", groups = BaseInterface.class)
    private String pictureUrls;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    private Integer inventory;

    /**
     * 销量
     */
    @ApiModelProperty("销量")
    private Integer sales;

    /**
     * 限制每人可以购买数量 0.不限购
     */
    @ApiModelProperty("限制每人可以购买数量 0.不限购")
    @NotNull(message = "限制每人可以购买数量 0.不限购不能为空", groups = BaseInterface.class)
    private Integer perPersonLimit;

    /**
     * 浏览量
     */
    @ApiModelProperty("浏览量")
    private Integer viewCount;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte goodsStatus;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


    /**
     * 商品sku
     */
    @ApiModelProperty("商品sku")
    @NotNull(message = "商品sku不能为空", groups = BaseInterface.class)
    private List<GoodsSkuDTO> skuList;

    /**
     * 商品规格
     */
    @ApiModelProperty("商品规格")
    private List<GoodsSpecificationDTO> goodsSpecificationList;

    /**
     * 商品属性
     */
    @ApiModelProperty("商品属性")
    private List<GoodsAttributeDTO> attributeList;

    /**
     * 商品描述
     */
    @ApiModelProperty("商品描述")
    @NotNull(message = "商品描述不能为空", groups = BaseInterface.class)
    private String description;


}
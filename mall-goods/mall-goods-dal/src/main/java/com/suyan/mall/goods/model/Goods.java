/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Goods {


    /**
     * id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 分类id
     */
    private Long goodsClassId;

    /**
     * 类目id
     */
    private Integer goodsCategoryId;

    /**
     * 品牌id
     */
    private Integer brandId;

    /**
     * 是否多规格
     */
    private Boolean isMoreSpec;

    /**
     * 规格值json
     */
    private String specValue;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 列表价
     */
    private BigDecimal listPrice;

    /**
     * 起订量
     */
    private Integer minimumQuantity;

    /**
     * 快递运费
     */
    private BigDecimal expressFreight;

    /**
     * 图片
     */
    private String pictureUrls;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 限制每人可以购买数量 0.不限购
     */
    private Integer perPersonLimit;

    /**
     * 浏览量
     */
    private Integer viewCount;

    /**
     * 状态
     */
    private Byte goodsStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除: 0.未删除 1.已删除
     */
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 商品sku
     */
    private List<GoodsSku> skuList;

    /**
     * 商品规格
     */
    private List<GoodsSpecification> goodsSpecificationList;

    /**
     * 描述
     */
    private String description;


}
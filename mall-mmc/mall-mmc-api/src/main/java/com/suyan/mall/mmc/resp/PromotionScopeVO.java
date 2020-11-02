/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("促销适用范围")
public class PromotionScopeVO implements Serializable {

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
     * 促销类型
     */
    @ApiModelProperty("促销类型")
    private Byte promotionType;

    /**
     * 促销id
     */
    @ApiModelProperty("促销id")
    private Long promotionId;

    /**
     * 商品类目id
     */
    @ApiModelProperty("商品类目id")
    private Integer goodsCategoryId;

    /**
     * 商品类目名称
     */
    @ApiModelProperty("商品类目名称")
    private String goodsCategoryName;

    /**
     * 商品sku编码
     */
    @ApiModelProperty("商品sku编码")
    private String goodsSkuCode;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class PromotionScopeDTO implements Serializable {

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
    @NotNull(message = "商品类目id不能为空", groups = BaseInterface.class)
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
    @Size(max = 32, message = "商品sku编码不能超过32位", groups = BaseInterface.class)
    private String goodsSkuCode;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
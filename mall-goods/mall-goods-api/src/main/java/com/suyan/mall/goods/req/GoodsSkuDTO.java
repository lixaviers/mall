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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodsSkuDTO implements Serializable {

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
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空", groups = {BaseInterface.class, DeductionInventory.class})
    @Size(max = 32, message = "商品编码不能超过32位", groups = BaseInterface.class)
    private String skuCode;

    /**
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    @NotNull(message = "店铺id不能为空", groups = BaseInterface.class)
    private Long shopId;

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    @NotNull(message = "商品id不能为空", groups = BaseInterface.class)
    private Long goodsId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    @Size(max = 255, message = "商品图片不能超过255位", groups = BaseInterface.class)
    private String goodsPicture;

    /**
     * 规格值
     */
    @ApiModelProperty("规格值")
    @Size(max = 1000, message = "规格值不能超过1000位", groups = BaseInterface.class)
    private String specValue;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    @NotNull(message = "价格不能为空", groups = BaseInterface.class)
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    @NotNull(message = "库存不能为空", groups = BaseInterface.class)
    private Integer inventory;

    /**
     * 销量
     */
    @ApiModelProperty("销量")
    @NotNull(message = "销量不能为空", groups = BaseInterface.class)
    private Integer sales;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @NotNull(message = "状态不能为空", groups = BaseInterface.class)
    private Byte commonStatus;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    @NotNull(message = "数量不能为空", groups = DeductionInventory.class)
    @Min(message = "数量不能小于0", value = 1, groups = DeductionInventory.class)
    private Integer number;

    /**
     * 扣减库存验证
     */
    public interface DeductionInventory {

    }

}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.req;

import com.suyan.service.BaseInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ShoppingCartDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty(value = "id", hidden = true)
    @NotNull(message = "id不能为空", groups = UpdateNumber.class)
    private Long id;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    /**
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    private Long shopId;

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long goodsId;

    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "商品编码不能超过32位", groups = BaseInterface.class)
    private String goodsSkuCode;

    /**
     * 商品加入时的价格
     */
    @ApiModelProperty("商品加入时的价格")
    private BigDecimal goodsPrice;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    @NotNull(message = "商品数量不能为空", groups = {BaseInterface.class, UpdateNumber.class})
    private Integer goodsNumber;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 修改数量验证
     */
    public interface UpdateNumber {

    }


}
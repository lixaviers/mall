package com.suyan.mall.order.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("购物车")
public class ShoppingCartVO implements Serializable {

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
     * 商品编码
     */
    @ApiModelProperty("商品编码")
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
    private Integer goodsNumber;

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
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


    /**
     * 商品是否失效
     */
    @ApiModelProperty("商品是否失效")
    private Boolean isGoodsFailure = true;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * 商品真实价格
     */
    @ApiModelProperty("商品真实价格")
    private BigDecimal goodsRealPrice;

    /**
     * 商品库存
     */
    @ApiModelProperty("商品库存")
    private Integer goodsInventory;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String goodsPicture;

    /**
     * 商品规格值
     */
    @ApiModelProperty("商品规格值")
    private String goodsSpecValue;


}
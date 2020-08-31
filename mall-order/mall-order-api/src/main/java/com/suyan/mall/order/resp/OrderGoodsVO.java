package com.suyan.mall.order.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("订单商品")
public class OrderGoodsVO implements Serializable {

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
     * 订单号
     */
    @ApiModelProperty("订单号")
    private String orderNumber;

    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    private String goodsSkuCode;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * 规格值
     */
    @ApiModelProperty("规格值")
    private String specValue;

    /**
     * 商品价格
     */
    @ApiModelProperty("商品价格")
    private BigDecimal goodsPrice;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private Integer goodsNumber;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String goodsPicture;

    /**
     * 总金额
     */
    @ApiModelProperty("总金额")
    private BigDecimal totalAmount;

    /**
     * 实际支付金额
     */
    @ApiModelProperty("实际支付金额")
    private BigDecimal actualAmount;

    /**
     * 促销金额
     */
    @ApiModelProperty("促销金额")
    private BigDecimal promotionAmount;

    /**
     * 运费金额
     */
    @ApiModelProperty("运费金额")
    private BigDecimal freightAmount;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte commonStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 支付时间
     */
    @ApiModelProperty("支付时间")
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    @ApiModelProperty("发货时间")
    private LocalDateTime deliveryTime;

    /**
     * 确认收货时间
     */
    @ApiModelProperty("确认收货时间")
    private LocalDateTime confirmGoodsTime;

    /**
     * 评价时间
     */
    @ApiModelProperty("评价时间")
    private LocalDateTime evaluationTime;

    /**
     * 发起退款时间
     */
    @ApiModelProperty("发起退款时间")
    private LocalDateTime initiateRefundTime;

    /**
     * 退款时间
     */
    @ApiModelProperty("退款时间")
    private LocalDateTime refundTime;

    /**
     * 完结时间
     */
    @ApiModelProperty("完结时间")
    private LocalDateTime endTime;

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


}
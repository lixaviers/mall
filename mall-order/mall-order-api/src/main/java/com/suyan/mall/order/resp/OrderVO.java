package com.suyan.mall.order.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ApiModel("订单")
public class OrderVO implements Serializable {

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
     * 收货人
     */
    @ApiModelProperty("收货人")
    private String consignee;

    /**
     * 收货人手机号
     */
    @ApiModelProperty("收货人手机号")
    private String mobile;

    /**
     * 收货具体地址
     */
    @ApiModelProperty("收货具体地址")
    private String address;

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
     * 订单状态
     */
    @ApiModelProperty("订单状态")
    private Byte orderStatus;

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
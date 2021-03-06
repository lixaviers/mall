/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {


    /**
     * id
     */
    private Long id;

    /**
     * 用户唯一标识
     */
    private String uniqueUserId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 订单号
     */
    private String orderNumber;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货人手机号
     */
    private String mobile;

    /**
     * 收货具体地址
     */
    private String address;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 实际支付金额
     */
    private BigDecimal actualAmount;

    /**
     * 促销金额
     */
    private BigDecimal promotionAmount;

    /**
     * 运费金额
     */
    private BigDecimal freightAmount;

    /**
     * 订单状态
     */
    private Byte orderStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    /**
     * 发货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 确认收货时间
     */
    private LocalDateTime confirmGoodsTime;

    /**
     * 评价时间
     */
    private LocalDateTime evaluationTime;

    /**
     * 发起退款时间
     */
    private LocalDateTime initiateRefundTime;

    /**
     * 退款时间
     */
    private LocalDateTime refundTime;

    /**
     * 完结时间
     */
    private LocalDateTime endTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 用户收货地址id
     */
    private Long deliverAddressId;

    /**
     * 订单商品
     */
    private List<OrderGoods> orderGoodsList;

}
package com.suyan.mall.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderGoods {


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
     * 商品编码
     */
    private String goodsSkuCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 规格值
     */
    private String specValue;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品数量
     */
    private Integer goodsNumber;

    /**
     * 商品图片
     */
    private String goodsPicture;

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
     * 状态
     */
    private Byte commonStatus;

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


}
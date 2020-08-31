package com.suyan.mall.order.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO implements Serializable {

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
    @Size(max = 64, message = "收货人不能超过64位", groups = BaseInterface.class)
    private String consignee;

    /**
     * 收货人手机号
     */
    @ApiModelProperty("收货人手机号")
    @Size(max = 16, message = "收货人手机号不能超过16位", groups = BaseInterface.class)
    private String mobile;

    /**
     * 收货具体地址
     */
    @ApiModelProperty("收货具体地址")
    @Size(max = 255, message = "收货具体地址不能超过255位", groups = BaseInterface.class)
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
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 用户收货地址id
     */
    @NotNull(message = "用户收货地址不能为空", groups = BaseInterface.class)
    private Long deliverAddressId;

    /**
     * 订单商品
     */
    @NotNull(message = "订单商品不能为空", groups = BaseInterface.class)
    @Size(min = 1, message = "订单商品不能为空", groups = BaseInterface.class)
    @Valid
    private List<OrderGoodsDTO> orderGoodsList;


}
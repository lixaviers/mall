package com.suyan.mall.order.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderGoodsDTO implements Serializable {

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
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "商品编码不能超过32位", groups = BaseInterface.class)
    private String goodsSkuCode;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @Size(max = 64, message = "商品名称不能超过64位", groups = BaseInterface.class)
    private String goodsName;

    /**
     * 规格值
     */
    @ApiModelProperty("规格值")
    @Size(max = 1000, message = "规格值不能超过1000位", groups = BaseInterface.class)
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
    @NotNull(message = "商品数量不能为空", groups = BaseInterface.class)
    private Integer goodsNumber;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    @Size(max = 255, message = "商品图片不能超过255位", groups = BaseInterface.class)
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


}
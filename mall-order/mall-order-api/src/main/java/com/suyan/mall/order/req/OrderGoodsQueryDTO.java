package com.suyan.mall.order.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderGoodsQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    @ApiModelProperty("用户唯一标识列表")
    private List<String> uniqueUserIdList;

    @ApiModelProperty("用户唯一标识模糊字段")
    private String uniqueUserIdLike;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("店铺id列表")
    private List<Long> shopIdList;

    @ApiModelProperty("订单号")
    private String orderNumber;

    @ApiModelProperty("订单号列表")
    private List<String> orderNumberList;

    @ApiModelProperty("订单号模糊字段")
    private String orderNumberLike;

    @ApiModelProperty("商品编码")
    private String goodsSkuCode;

    @ApiModelProperty("商品编码列表")
    private List<String> goodsSkuCodeList;

    @ApiModelProperty("商品编码模糊字段")
    private String goodsSkuCodeLike;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品名称列表")
    private List<String> goodsNameList;

    @ApiModelProperty("商品名称模糊字段")
    private String goodsNameLike;

    @ApiModelProperty("商品价格起")
    private BigDecimal goodsPriceFrom;

    @ApiModelProperty("商品价格止")
    private BigDecimal goodsPriceTo;

    @ApiModelProperty("商品数量")
    private Integer goodsNumber;

    @ApiModelProperty("商品数量列表")
    private List<Integer> goodsNumberList;

    @ApiModelProperty("商品图片")
    private String goodsPicture;

    @ApiModelProperty("商品图片列表")
    private List<String> goodsPictureList;

    @ApiModelProperty("商品图片模糊字段")
    private String goodsPictureLike;

    @ApiModelProperty("总金额起")
    private BigDecimal totalAmountFrom;

    @ApiModelProperty("总金额止")
    private BigDecimal totalAmountTo;

    @ApiModelProperty("实际支付金额起")
    private BigDecimal actualAmountFrom;

    @ApiModelProperty("实际支付金额止")
    private BigDecimal actualAmountTo;

    @ApiModelProperty("促销金额起")
    private BigDecimal promotionAmountFrom;

    @ApiModelProperty("促销金额止")
    private BigDecimal promotionAmountTo;

    @ApiModelProperty("运费金额起")
    private BigDecimal freightAmountFrom;

    @ApiModelProperty("运费金额止")
    private BigDecimal freightAmountTo;

    @ApiModelProperty("状态")
    private Byte commonStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> commonStatusList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("支付时间起")
    private LocalDateTime payTimeFrom;

    @ApiModelProperty("支付时间止")
    private LocalDateTime payTimeTo;

    @ApiModelProperty("发货时间起")
    private LocalDateTime deliveryTimeFrom;

    @ApiModelProperty("发货时间止")
    private LocalDateTime deliveryTimeTo;

    @ApiModelProperty("确认收货时间起")
    private LocalDateTime confirmGoodsTimeFrom;

    @ApiModelProperty("确认收货时间止")
    private LocalDateTime confirmGoodsTimeTo;

    @ApiModelProperty("评价时间起")
    private LocalDateTime evaluationTimeFrom;

    @ApiModelProperty("评价时间止")
    private LocalDateTime evaluationTimeTo;

    @ApiModelProperty("发起退款时间起")
    private LocalDateTime initiateRefundTimeFrom;

    @ApiModelProperty("发起退款时间止")
    private LocalDateTime initiateRefundTimeTo;

    @ApiModelProperty("退款时间起")
    private LocalDateTime refundTimeFrom;

    @ApiModelProperty("退款时间止")
    private LocalDateTime refundTimeTo;

    @ApiModelProperty("完结时间起")
    private LocalDateTime endTimeFrom;

    @ApiModelProperty("完结时间止")
    private LocalDateTime endTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("是否删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除列表")
    private List<Boolean> isDeletedList;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
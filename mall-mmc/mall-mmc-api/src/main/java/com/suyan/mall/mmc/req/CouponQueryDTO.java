package com.suyan.mall.mmc.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CouponQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("主键id列表")
    private List<Long> idList;

    @ApiModelProperty("优惠券名称")
    private String couponName;

    @ApiModelProperty("优惠券名称列表")
    private List<String> couponNameList;

    @ApiModelProperty("优惠券名称模糊字段")
    private String couponNameLike;

    @ApiModelProperty("券包id")
    private Long couponPackageId;

    @ApiModelProperty("券包id列表")
    private List<Long> couponPackageIdList;

    @ApiModelProperty("使用类型 1.免费 2.付费")
    private Byte useType;

    @ApiModelProperty("使用类型 1.免费 2.付费列表")
    private List<Byte> useTypeList;

    @ApiModelProperty("价格起")
    private BigDecimal priceFrom;

    @ApiModelProperty("价格止")
    private BigDecimal priceTo;

    @ApiModelProperty("每人可领张数 0.不限制/券包包含数量")
    private Integer personLimit;

    @ApiModelProperty("每人可领张数 0.不限制/券包包含数量列表")
    private List<Integer> personLimitList;

    @ApiModelProperty("订单可以使用张数 0.不限制")
    private Integer orderLimit;

    @ApiModelProperty("订单可以使用张数 0.不限制列表")
    private List<Integer> orderLimitList;

    @ApiModelProperty("生效时间起")
    private LocalDateTime startTimeFrom;

    @ApiModelProperty("生效时间止")
    private LocalDateTime startTimeTo;

    @ApiModelProperty("失效时间起")
    private LocalDateTime endTimeFrom;

    @ApiModelProperty("失效时间止")
    private LocalDateTime endTimeTo;

    @ApiModelProperty("预热时间起")
    private LocalDateTime pendingTimeFrom;

    @ApiModelProperty("预热时间止")
    private LocalDateTime pendingTimeTo;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("库存列表")
    private List<Integer> inventoryList;

    @ApiModelProperty("优惠券类型")
    private Byte couponType;

    @ApiModelProperty("优惠券类型列表")
    private List<Byte> couponTypeList;

    @ApiModelProperty("促销金额起")
    private BigDecimal promotionAmountFrom;

    @ApiModelProperty("促销金额止")
    private BigDecimal promotionAmountTo;

    @ApiModelProperty("订单满金额起")
    private BigDecimal orderFullAmountFrom;

    @ApiModelProperty("订单满金额止")
    private BigDecimal orderFullAmountTo;

    @ApiModelProperty("促销封顶金额起")
    private BigDecimal promotionMaxAmountFrom;

    @ApiModelProperty("促销封顶金额止")
    private BigDecimal promotionMaxAmountTo;

    @ApiModelProperty("折扣金额起")
    private BigDecimal discountAmountFrom;

    @ApiModelProperty("折扣金额止")
    private BigDecimal discountAmountTo;

    @ApiModelProperty("优惠券状态")
    private Byte couponStatus;

    @ApiModelProperty("优惠券状态列表")
    private List<Byte> couponStatusList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("是否删除: 0.未删除 1.已删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除: 0.未删除 1.已删除列表")
    private List<Boolean> isDeletedList;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
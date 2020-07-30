package com.suyan.mall.mmc.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel("优惠券")
public class CouponVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    private Long id;

    /**
     * 优惠券名称
     */
    @ApiModelProperty("优惠券名称")
    private String couponName;

    /**
     * 券包id
     */
    @ApiModelProperty("券包id")
    private Long couponPackageId;

    /**
     * 使用类型 1.免费 2.付费
     */
    @ApiModelProperty("使用类型 1.免费 2.付费")
    private Byte useType;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private BigDecimal price;

    /**
     * 每人可领张数 0.不限制/券包包含数量
     */
    @ApiModelProperty("每人可领张数 0.不限制/券包包含数量")
    private Integer personLimit;

    /**
     * 订单可以使用张数 0.不限制
     */
    @ApiModelProperty("订单可以使用张数 0.不限制")
    private Integer orderLimit;

    /**
     * 生效时间
     */
    @ApiModelProperty("生效时间")
    private LocalDateTime startTime;

    /**
     * 失效时间
     */
    @ApiModelProperty("失效时间")
    private LocalDateTime endTime;

    /**
     * 预热时间
     */
    @ApiModelProperty("预热时间")
    private LocalDateTime pendingTime;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    private Integer inventory;

    /**
     * 优惠券类型
     */
    @ApiModelProperty("优惠券类型")
    private Byte couponType;

    /**
     * 促销金额
     */
    @ApiModelProperty("促销金额")
    private BigDecimal promotionAmount;

    /**
     * 订单满金额
     */
    @ApiModelProperty("订单满金额")
    private BigDecimal orderFullAmount;

    /**
     * 促销封顶金额
     */
    @ApiModelProperty("促销封顶金额")
    private BigDecimal promotionMaxAmount;

    /**
     * 折扣金额
     */
    @ApiModelProperty("折扣金额")
    private BigDecimal discountAmount;

    /**
     * 订单金额范围及促销金额json
     */
    @ApiModelProperty("订单金额范围及促销金额json")
    private String promotionScopeAmount;

    /**
     * 优惠券状态
     */
    @ApiModelProperty("优惠券状态")
    private Byte couponStatus;

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
     * 是否删除: 0.未删除 1.已删除
     */
    @ApiModelProperty("是否删除: 0.未删除 1.已删除")
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 优惠券类型描述
     */
    @ApiModelProperty("优惠券类型描述")
    private String couponTypeDesc;

    /**
     * 订单金额范围及促销金额
     */
    @ApiModelProperty("订单金额范围及促销金额")
    private List<PromotionScopeVO> promotionScopeList;

}
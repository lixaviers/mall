package com.suyan.mall.mmc.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Coupon {


    /**
     * 主键id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * 券包id
     */
    private Long couponPackageId;

    /**
     * 使用类型 1.免费 2.付费
     */
    private Byte useType;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 每人可领张数 0.不限制/券包包含数量
     */
    private Integer personLimit;

    /**
     * 订单可以使用张数 0.不限制
     */
    private Integer orderLimit;

    /**
     * 生效时间
     */
    private LocalDateTime startTime;

    /**
     * 失效时间
     */
    private LocalDateTime endTime;

    /**
     * 预热时间
     */
    private LocalDateTime pendingTime;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 优惠券类型
     */
    private Byte couponType;

    /**
     * 促销金额
     */
    private BigDecimal promotionAmount;

    /**
     * 订单满金额
     */
    private BigDecimal orderFullAmount;

    /**
     * 促销封顶金额
     */
    private BigDecimal promotionMaxAmount;

    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 订单金额范围及促销金额json
     */
    private String promotionScopeAmount;

    /**
     * 使用范围
     */
    private Byte couponScope;

    /**
     * 优惠券状态
     */
    private Byte couponStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除: 0.未删除 1.已删除
     */
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 渠道
     */
    @ApiModelProperty("渠道")
    private List<CouponChannel> channelList;

    /**
     * 订单金额范围及促销金额
     */
    private List<PromotionAmountScope> promotionAmountScopeList;

    /**
     * 使用范围
     */
    @ApiModelProperty("使用范围")
    private List<PromotionScope> promotionScopeList;

}
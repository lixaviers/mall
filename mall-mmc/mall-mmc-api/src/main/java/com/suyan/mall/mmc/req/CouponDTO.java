package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CouponDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", hidden = true)
    @NotNull(message = "主键id不能为空", groups = UpdateInterface.class)
    private Long id;

    /**
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    private Long shopId;

    /**
     * 优惠券名称
     */
    @ApiModelProperty("优惠券名称")
    @NotNull(message = "优惠券名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "优惠券名称不能超过64位", groups = BaseInterface.class)
    private String couponName;

    /**
     * 券包id
     */
    @ApiModelProperty("券包id")
//    @NotNull(message = "券包id不能为空", groups = BaseInterface.class)
    private Long couponPackageId;

    /**
     * 使用类型 1.免费 2.付费
     */
    @ApiModelProperty("使用类型 1.免费 2.付费")
    @NotNull(message = "使用类型 1.免费 2.付费不能为空", groups = BaseInterface.class)
    private Byte useType;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    @NotNull(message = "价格不能为空", groups = BaseInterface.class)
    private BigDecimal price;

    /**
     * 每人可领张数 0.不限制/券包包含数量
     */
    @ApiModelProperty("每人可领张数 0.不限制/券包包含数量")
    @NotNull(message = "每人可领张数 0.不限制/券包包含数量不能为空", groups = BaseInterface.class)
    private Integer personLimit;

    /**
     * 订单可以使用张数 0.不限制
     */
    @ApiModelProperty("订单可以使用张数 0.不限制")
    @NotNull(message = "订单可以使用张数 0.不限制不能为空", groups = BaseInterface.class)
    private Integer orderLimit;

    /**
     * 生效时间
     */
    @ApiModelProperty("生效时间")
    @NotNull(message = "生效时间不能为空", groups = BaseInterface.class)
    private LocalDateTime startTime;

    /**
     * 失效时间
     */
    @ApiModelProperty("失效时间")
    @NotNull(message = "失效时间不能为空", groups = BaseInterface.class)
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
    @NotNull(message = "库存不能为空", groups = BaseInterface.class)
    private Integer inventory;

    /**
     * 优惠券类型
     */
    @ApiModelProperty("优惠券类型")
    @NotNull(message = "优惠券类型不能为空", groups = BaseInterface.class)
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
     * 优惠券状态
     */
    @ApiModelProperty("优惠券状态")
    private Byte couponStatus;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 订单金额范围及促销金额
     */
    @ApiModelProperty("订单金额范围及促销金额")
    private List<PromotionScopeDTO> promotionScopeList;


}
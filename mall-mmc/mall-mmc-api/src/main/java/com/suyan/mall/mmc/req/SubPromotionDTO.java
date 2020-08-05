package com.suyan.mall.mmc.req;

import com.suyan.annotation.EnumValidate;
import com.suyan.mall.mmc.enums.PromotionScopeEnum;
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
public class SubPromotionDTO implements Serializable {

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
     * 订单促销名称
     */
    @ApiModelProperty("订单促销名称")
    @NotNull(message = "订单促销名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "订单促销名称不能超过64位", groups = BaseInterface.class)
    private String subPromotionName;

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
     * 订单促销类型
     */
    @ApiModelProperty("订单促销类型")
    @NotNull(message = "订单促销类型不能为空", groups = BaseInterface.class)
    private Byte subPromotionType;

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
    @Size(max = 1024, message = "订单金额范围及促销金额json不能超过1024位", groups = BaseInterface.class)
    private String promotionScopeAmount;

    /**
     * 使用范围
     */
    @ApiModelProperty("使用范围")
    @NotNull(message = "使用范围不能为空", groups = BaseInterface.class)
    @EnumValidate(message = "使用范围无效", enumClass = PromotionScopeEnum.class, groups = BaseInterface.class)
    private Byte subPromotionScope;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 订单金额范围及促销金额
     */
    @ApiModelProperty("订单金额范围及促销金额")
    private List<PromotionAmountScopeDTO> promotionAmountScopeList;

    /**
     * 使用范围
     */
    @ApiModelProperty("使用范围")
    private List<PromotionScopeDTO> promotionScopeList;


}
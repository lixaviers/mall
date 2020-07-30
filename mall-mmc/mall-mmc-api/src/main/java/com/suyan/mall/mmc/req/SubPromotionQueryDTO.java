package com.suyan.mall.mmc.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SubPromotionQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单促销id")
    private Long id;

    @ApiModelProperty("订单促销id列表")
    private List<Long> idList;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("名称列表")
    private List<String> nameList;

    @ApiModelProperty("名称模糊字段")
    private String nameLike;

    @ApiModelProperty("类型")
    private Byte typeId;

    @ApiModelProperty("类型列表")
    private List<Byte> typeIdList;

    @ApiModelProperty("开始时间起")
    private LocalDateTime startTimeFrom;

    @ApiModelProperty("开始时间止")
    private LocalDateTime startTimeTo;

    @ApiModelProperty("结束时间起")
    private LocalDateTime endTimeFrom;

    @ApiModelProperty("结束时间止")
    private LocalDateTime endTimeTo;

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

    @ApiModelProperty("状态")
    private Byte promotionStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> promotionStatusList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("是否删除：0.未删除，1.已删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除：0.未删除，1.已删除列表")
    private List<Boolean> isDeletedList;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
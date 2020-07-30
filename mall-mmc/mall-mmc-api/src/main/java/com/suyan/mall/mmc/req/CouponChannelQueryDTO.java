package com.suyan.mall.mmc.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CouponChannelQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("优惠券id")
    private Long couponId;

    @ApiModelProperty("优惠券id列表")
    private List<Long> couponIdList;

    @ApiModelProperty("渠道id")
    private Byte channelId;

    @ApiModelProperty("渠道id列表")
    private List<Byte> channelIdList;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("库存列表")
    private List<Integer> inventoryList;

    @ApiModelProperty("是否有发放时间起")
    private Boolean isIssueTimeFrom;

    @ApiModelProperty("是否有发放时间止")
    private Boolean isIssueTimeTo;

    @ApiModelProperty("发放起始时间起")
    private LocalDateTime issueStartTimeFrom;

    @ApiModelProperty("发放起始时间止")
    private LocalDateTime issueStartTimeTo;

    @ApiModelProperty("发放截止时间起")
    private LocalDateTime issueEndTimeFrom;

    @ApiModelProperty("发放截止时间止")
    private LocalDateTime issueEndTimeTo;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
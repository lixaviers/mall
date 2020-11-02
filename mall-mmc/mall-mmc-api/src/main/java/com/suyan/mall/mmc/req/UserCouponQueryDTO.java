/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserCouponQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("主键id列表")
    private List<Long> idList;

    @ApiModelProperty("优惠券id")
    private Long couponId;

    @ApiModelProperty("优惠券id列表")
    private List<Long> couponIdList;

    @ApiModelProperty("券码")
    private String couponCode;

    @ApiModelProperty("券码列表")
    private List<String> couponCodeList;

    @ApiModelProperty("券码模糊字段")
    private String couponCodeLike;

    @ApiModelProperty("用户openId")
    private String userOpenId;

    @ApiModelProperty("用户openId列表")
    private List<String> userOpenIdList;

    @ApiModelProperty("用户openId模糊字段")
    private String userOpenIdLike;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("手机号列表")
    private List<String> mobileList;

    @ApiModelProperty("手机号模糊字段")
    private String mobileLike;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("订单号列表")
    private List<String> orderNoList;

    @ApiModelProperty("订单号模糊字段")
    private String orderNoLike;

    @ApiModelProperty("状态")
    private Byte couponStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> couponStatusList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("创建人")
    private String createUser;

    @ApiModelProperty("创建人列表")
    private List<String> createUserList;

    @ApiModelProperty("创建人模糊字段")
    private String createUserLike;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("创建人名称")
    private String createUserName;

    @ApiModelProperty("创建人名称列表")
    private List<String> createUserNameList;

    @ApiModelProperty("创建人名称模糊字段")
    private String createUserNameLike;

    @ApiModelProperty("更新人")
    private String updateUser;

    @ApiModelProperty("更新人列表")
    private List<String> updateUserList;

    @ApiModelProperty("更新人模糊字段")
    private String updateUserLike;

    @ApiModelProperty("更新人名称")
    private String updateUserName;

    @ApiModelProperty("更新人名称列表")
    private List<String> updateUserNameList;

    @ApiModelProperty("更新人名称模糊字段")
    private String updateUserNameLike;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
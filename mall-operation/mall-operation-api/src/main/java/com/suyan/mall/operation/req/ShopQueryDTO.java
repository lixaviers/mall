/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ShopQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("店铺id")
    private Long id;

    @ApiModelProperty("店铺id列表")
    private List<Long> idList;

    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    @ApiModelProperty("用户唯一标识列表")
    private List<String> uniqueUserIdList;

    @ApiModelProperty("用户唯一标识模糊字段")
    private String uniqueUserIdLike;

    @ApiModelProperty("店铺名称")
    private String shopName;

    @ApiModelProperty("店铺名称列表")
    private List<String> shopNameList;

    @ApiModelProperty("店铺名称模糊字段")
    private String shopNameLike;

    @ApiModelProperty("店铺logo地址")
    private String shopLogoUrl;

    @ApiModelProperty("店铺logo地址列表")
    private List<String> shopLogoUrlList;

    @ApiModelProperty("店铺logo地址模糊字段")
    private String shopLogoUrlLike;

    @ApiModelProperty("省份id")
    private Integer provinceId;

    @ApiModelProperty("省份id列表")
    private List<Integer> provinceIdList;

    @ApiModelProperty("省份")
    private String provinceName;

    @ApiModelProperty("省份列表")
    private List<String> provinceNameList;

    @ApiModelProperty("省份模糊字段")
    private String provinceNameLike;

    @ApiModelProperty("城市id")
    private Integer cityId;

    @ApiModelProperty("城市id列表")
    private List<Integer> cityIdList;

    @ApiModelProperty("城市")
    private String cityName;

    @ApiModelProperty("城市列表")
    private List<String> cityNameList;

    @ApiModelProperty("城市模糊字段")
    private String cityNameLike;

    @ApiModelProperty("区id")
    private Integer areaId;

    @ApiModelProperty("区id列表")
    private List<Integer> areaIdList;

    @ApiModelProperty("区")
    private String areaName;

    @ApiModelProperty("区列表")
    private List<String> areaNameList;

    @ApiModelProperty("区模糊字段")
    private String areaNameLike;

    @ApiModelProperty("详细地址")
    private String detailAddress;

    @ApiModelProperty("详细地址列表")
    private List<String> detailAddressList;

    @ApiModelProperty("详细地址模糊字段")
    private String detailAddressLike;

    @ApiModelProperty("状态")
    private Byte commonStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> commonStatusList;

    @ApiModelProperty("创建人")
    private String createUser;

    @ApiModelProperty("创建人列表")
    private List<String> createUserList;

    @ApiModelProperty("创建人模糊字段")
    private String createUserLike;

    @ApiModelProperty("创建人名称")
    private String createUserName;

    @ApiModelProperty("创建人名称列表")
    private List<String> createUserNameList;

    @ApiModelProperty("创建人名称模糊字段")
    private String createUserNameLike;

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
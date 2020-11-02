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
public class SystemLogQueryDTO extends QueryDTO {

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

    @ApiModelProperty("用户账号")
    private String userName;

    @ApiModelProperty("用户账号列表")
    private List<String> userNameList;

    @ApiModelProperty("用户账号模糊字段")
    private String userNameLike;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户昵称列表")
    private List<String> nickNameList;

    @ApiModelProperty("用户昵称模糊字段")
    private String nickNameLike;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("店铺id列表")
    private List<Long> shopIdList;

    @ApiModelProperty("用户操作")
    private String operate;

    @ApiModelProperty("用户操作列表")
    private List<String> operateList;

    @ApiModelProperty("用户操作模糊字段")
    private String operateLike;

    @ApiModelProperty("请求方法")
    private String method;

    @ApiModelProperty("请求方法列表")
    private List<String> methodList;

    @ApiModelProperty("请求方法模糊字段")
    private String methodLike;

    @ApiModelProperty("执行时长(毫秒)起")
    private Long executionTimeFrom;

    @ApiModelProperty("执行时长(毫秒)止")
    private Long executionTimeTo;

    @ApiModelProperty("IP地址")
    private String ip;

    @ApiModelProperty("IP地址列表")
    private List<String> ipList;

    @ApiModelProperty("IP地址模糊字段")
    private String ipLike;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
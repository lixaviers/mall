/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.resp.b;

import com.suyan.mall.user.enums.SystemPlatformEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("用户")
public class UserInfoVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 平台类型
     */
    @ApiModelProperty("平台类型")
    private SystemPlatformEnum systemPlatform;

    /**
     * sessionId
     */
    @ApiModelProperty("sessionId")
    private String sessionId;

    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    /**
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("店铺名称")
    private String shopName;

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 邮箱账号
     */
    @ApiModelProperty("邮箱账号")
    private String email;

    /**
     * 来源
     */
    @ApiModelProperty("来源")
    private Byte userSource;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte userStatus;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}
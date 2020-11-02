/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SystemLogDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty(value = "id", hidden = true)
    @NotNull(message = "id不能为空", groups = UpdateInterface.class)
    private Long id;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty("用户唯一标识")
    @NotNull(message = "用户唯一标识不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "用户唯一标识不能超过32位", groups = BaseInterface.class)
    private String uniqueUserId;

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    @NotNull(message = "用户账号不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "用户账号不能超过32位", groups = BaseInterface.class)
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    @Size(max = 64, message = "用户昵称不能超过64位", groups = BaseInterface.class)
    private String nickName;

    /**
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    @NotNull(message = "店铺id不能为空", groups = BaseInterface.class)
    private Long shopId;

    /**
     * 用户操作
     */
    @ApiModelProperty("用户操作")
    @Size(max = 64, message = "用户操作不能超过64位", groups = BaseInterface.class)
    private String operate;

    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    @Size(max = 255, message = "请求方法不能超过255位", groups = BaseInterface.class)
    private String method;

    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    @Size(max = 1000, message = "请求参数不能超过1000位", groups = BaseInterface.class)
    private String params;

    /**
     * 执行时长(毫秒)
     */
    @ApiModelProperty("执行时长(毫秒)")
    private Long executionTime;

    /**
     * IP地址
     */
    @ApiModelProperty("IP地址")
    @Size(max = 32, message = "IP地址不能超过32位", groups = BaseInterface.class)
    private String ip;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
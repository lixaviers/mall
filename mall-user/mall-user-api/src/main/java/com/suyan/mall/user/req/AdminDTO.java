/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AdminDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @ApiModelProperty(value = "ID", hidden = true)
    @NotNull(message = "ID不能为空", groups = UpdateInterface.class)
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
    @NotNull(message = "用户账号不能为空", groups = {BaseInterface.class, Login.class})
    @Size(max = 32, message = "用户账号不能超过32位", groups = BaseInterface.class)
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    @NotNull(message = "用户昵称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "用户昵称不能超过64位", groups = BaseInterface.class)
    private String nickName;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @Size(max = 16, message = "手机号不能超过16位", groups = BaseInterface.class)
    private String mobile;

    /**
     * 邮箱账号
     */
    @ApiModelProperty("邮箱账号")
    @Size(max = 32, message = "邮箱账号不能超过32位", groups = BaseInterface.class)
    private String email;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空", groups = {Login.class})
    @Size(max = 100, message = "密码不能超过100位", groups = BaseInterface.class)
    private String userPwd;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @NotNull(message = "状态不能为空", groups = BaseInterface.class)
    private Byte userStatus;

    /**
     * 是否超级管理员
     */
    @ApiModelProperty("是否超级管理员")
    @NotNull(message = "是否超级管理员不能为空", groups = BaseInterface.class)
    private Boolean isSuperAdmin;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Size(max = 500, message = "备注不能超过500位", groups = BaseInterface.class)
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    private LocalDateTime updateTime;

    /**
     * 是否删除：0.未删除，1.已删除
     */
    @ApiModelProperty(value = "是否删除：0.未删除，1.已删除", hidden = true)
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 登录验证
     */
    public interface Login {

    }


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("短信渠道")
public class ChannelVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 渠道编码
     */
    @ApiModelProperty("渠道编码")
    private String channelCode;

    /**
     * 渠道名称
     */
    @ApiModelProperty("渠道名称")
    private String channelName;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    private String contactName;

    /**
     * 安全秘钥key
     */
    @ApiModelProperty("安全秘钥key")
    private String secretKey;

    /**
     * 支持类型
     */
    @ApiModelProperty("支持类型")
    private String supportType;

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

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createUser;

    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    private String createUserName;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除：0.未删除，1.已删除
     */
    @ApiModelProperty("是否删除：0.未删除，1.已删除")
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
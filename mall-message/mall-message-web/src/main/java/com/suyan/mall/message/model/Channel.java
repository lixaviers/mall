/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Channel {

    /**
     * id
     */
    private Integer id;

    /**
     * 渠道编码
     */
    private String channelCode;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 安全秘钥key
     */
    private String secretKey;

    /**
     * 支持类型
     */
    private String supportType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 更新人名称
     */
    private String updateUserName;

    /**
     * 是否删除：0.未删除，1.已删除
     */
    private Boolean isDeleted;

    /**
     * The following custom property definition
     */

}
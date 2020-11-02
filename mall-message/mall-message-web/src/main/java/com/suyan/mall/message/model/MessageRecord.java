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
public class MessageRecord {

    /**
     * id
     */
    private Long id;

    /**
     * 批次编码
     */
    private String batchCode;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 渠道id
     */
    private Integer channelId;

    /**
     * 发送供应商
     */
    private String sendProvider;

    /**
     * 模版编码
     */
    private String templateCode;

    /**
     * 发送类型：1.验证码类 2.营销类
     */
    private Byte sendType;

    /**
     * 发送状态 0.失败 1.成功 2.未知
     */
    private Byte sendStatus;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

    /**
     * 短信内容
     */
    private String content;

    /**
     * 返回短信消息ID
     */
    private String msgId;

    /**
     * 返回短信错误信息
     */
    private String msgResult;

    /**
     * 描述
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * The following custom property definition
     */

}
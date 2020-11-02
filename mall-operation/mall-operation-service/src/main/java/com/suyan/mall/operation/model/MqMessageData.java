/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MqMessageData {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 消息组
     */
    private String messageGroup;
    
    /**
     * 消息key
     */
    private String messageKey;
    
    /**
     * 消息topic
     */
    private String messageTopic;
    
    /**
     * 消息标签
     */
    private String messageTag;
    
    /**
     * 消息内容
     */
    private String messageBody;
    
    /**
     * 消息类型
     */
    private Byte messageType;
    
    /**
     * 顺序类型
     */
    private Byte orderType;
    
    /**
     * 消息状态
     */
    private Byte messageStatus;
    
    /**
     * 延时级别
     */
    private Integer delayLevel;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
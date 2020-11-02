/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.req;

import com.suyan.mall.operation.enums.MqMessageTypeEnum;
import com.suyan.mall.operation.enums.MqOrderTypeEnum;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class MqMessageDataDTO implements Serializable {

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
     * 消息组
     */
    @ApiModelProperty("消息组")
    @NotNull(message = "消息组不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "消息组不能超过64位", groups = BaseInterface.class)
    private String messageGroup;

    /**
     * 消息key
     */
    @ApiModelProperty("消息key")
    @NotNull(message = "消息key不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "消息key不能超过64位", groups = BaseInterface.class)
    private String messageKey;

    /**
     * 消息topic
     */
    @ApiModelProperty("消息topic")
    @NotNull(message = "消息topic不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "消息topic不能超过64位", groups = BaseInterface.class)
    private String messageTopic;

    /**
     * 消息标签
     */
    @ApiModelProperty("消息标签")
    @NotNull(message = "消息标签不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "消息标签不能超过64位", groups = BaseInterface.class)
    private String messageTag;

    /**
     * 消息内容
     */
    @ApiModelProperty("消息内容")
    @NotNull(message = "消息内容不能为空", groups = BaseInterface.class)
    @Size(max = 5000, message = "消息内容不能超过5000位", groups = BaseInterface.class)
    private String messageBody;

    /**
     * 消息类型
     *
     * @see MqMessageTypeEnum
     */
    @ApiModelProperty("消息类型")
    @NotNull(message = "消息类型不能为空", groups = BaseInterface.class)
    private Byte messageType;

    /**
     * 顺序类型
     *
     * @see MqOrderTypeEnum
     */
    @ApiModelProperty("顺序类型")
    @NotNull(message = "顺序类型不能为空", groups = BaseInterface.class)
    private Byte orderType;

    /**
     * 消息状态
     */
    @ApiModelProperty("消息状态")
    @NotNull(message = "消息状态不能为空", groups = BaseInterface.class)
    private Byte messageStatus;

    /**
     * 延时级别
     */
    @ApiModelProperty("延时级别")
    private Integer delayLevel;

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */
    public MqMessageDataDTO(Long id) {
        this.id = id;
    }

    public MqMessageDataDTO(final String topic, final String tag, final String key, final String msgBody) {
        this.messageTopic = topic;
        this.messageTag = tag;
        this.messageKey = key;
        this.messageBody = msgBody;
    }

}
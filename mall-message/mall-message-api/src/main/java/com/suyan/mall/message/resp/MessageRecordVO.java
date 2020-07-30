package com.suyan.mall.message.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("短信消息记录")
public class MessageRecordVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 批次编码
     */
    @ApiModelProperty("批次编码")
    private String batchCode;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 渠道id
     */
    @ApiModelProperty("渠道id")
    private Integer channelId;

    /**
     * 发送供应商
     */
    @ApiModelProperty("发送供应商")
    private String sendProvider;

    /**
     * 模版编码
     */
    @ApiModelProperty("模版编码")
    private String templateCode;

    /**
     * 发送类型：1.验证码类 2.营销类
     */
    @ApiModelProperty("发送类型：1.验证码类 2.营销类")
    private Byte sendType;

    /**
     * 发送状态 0.失败 1.成功 2.未知
     */
    @ApiModelProperty("发送状态 0.失败 1.成功 2.未知")
    private Byte sendStatus;

    /**
     * 发送时间
     */
    @ApiModelProperty("发送时间")
    private LocalDateTime sendTime;

    /**
     * 短信内容
     */
    @ApiModelProperty("短信内容")
    private String content;

    /**
     * 返回短信消息ID
     */
    @ApiModelProperty("返回短信消息ID")
    private String msgId;

    /**
     * 返回短信错误信息
     */
    @ApiModelProperty("返回短信错误信息")
    private String msgResult;

    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
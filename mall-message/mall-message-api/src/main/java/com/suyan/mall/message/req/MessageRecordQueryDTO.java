/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MessageRecordQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("批次编码")
    private String batchCode;

    @ApiModelProperty("批次编码列表")
    private List<String> batchCodeList;

    @ApiModelProperty("批次编码模糊字段")
    private String batchCodeLike;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("手机号列表")
    private List<String> mobileList;

    @ApiModelProperty("手机号模糊字段")
    private String mobileLike;

    @ApiModelProperty("渠道id")
    private Integer channelId;

    @ApiModelProperty("渠道id列表")
    private List<Integer> channelIdList;

    @ApiModelProperty("发送供应商")
    private String sendProvider;

    @ApiModelProperty("发送供应商列表")
    private List<String> sendProviderList;

    @ApiModelProperty("发送供应商模糊字段")
    private String sendProviderLike;

    @ApiModelProperty("模版编码")
    private String templateCode;

    @ApiModelProperty("模版编码列表")
    private List<String> templateCodeList;

    @ApiModelProperty("模版编码模糊字段")
    private String templateCodeLike;

    @ApiModelProperty("发送类型：1.验证码类 2.营销类")
    private Byte sendType;

    @ApiModelProperty("发送类型：1.验证码类 2.营销类列表")
    private List<Byte> sendTypeList;

    @ApiModelProperty("发送状态 0.失败 1.成功 2.未知")
    private Byte sendStatus;

    @ApiModelProperty("发送状态 0.失败 1.成功 2.未知列表")
    private List<Byte> sendStatusList;

    @ApiModelProperty("发送时间起")
    private LocalDateTime sendTimeFrom;

    @ApiModelProperty("发送时间止")
    private LocalDateTime sendTimeTo;

    @ApiModelProperty("短信内容")
    private String content;

    @ApiModelProperty("短信内容列表")
    private List<String> contentList;

    @ApiModelProperty("短信内容模糊字段")
    private String contentLike;

    @ApiModelProperty("返回短信消息ID")
    private String msgId;

    @ApiModelProperty("返回短信消息ID列表")
    private List<String> msgIdList;

    @ApiModelProperty("返回短信消息ID模糊字段")
    private String msgIdLike;

    @ApiModelProperty("返回短信错误信息")
    private String msgResult;

    @ApiModelProperty("返回短信错误信息列表")
    private List<String> msgResultList;

    @ApiModelProperty("返回短信错误信息模糊字段")
    private String msgResultLike;

    @ApiModelProperty("描述")
    private String remark;

    @ApiModelProperty("描述列表")
    private List<String> remarkList;

    @ApiModelProperty("描述模糊字段")
    private String remarkLike;

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
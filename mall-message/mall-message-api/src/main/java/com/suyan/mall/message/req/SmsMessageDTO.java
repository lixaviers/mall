package com.suyan.mall.message.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class SmsMessageDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = "^1\\d{10}$", message = "手机号格式错误")
    private String mobile;

    /**
     * 渠道id
     */
    @ApiModelProperty("渠道id")
    private Integer channelId;

    /**
     * 渠道编码
     */
    @ApiModelProperty("渠道编码")
    @NotNull(message = "渠道编码不能为空")
    private String channel;

    /**
     * 验证码
     */
    @ApiModelProperty("验证码")
    private String verCode;

    /**
     * 签名，规则md5(手机号+渠道编码+secret)
     */
    @ApiModelProperty("签名")
    @NotNull(message = "签名不能为空")
    private String sign;


}
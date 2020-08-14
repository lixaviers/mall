package com.suyan.mall.message.req;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChannelDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


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
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
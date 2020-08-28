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
public class DeliverAddressDTO implements Serializable {

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
     * 用户唯一标识
     */
    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    /**
     * 收货人
     */
    @ApiModelProperty("收货人")
    @NotNull(message = "收货人不能为空", groups = BaseInterface.class)
    @Size(max = 255, message = "收货人不能超过255位", groups = BaseInterface.class)
    private String consignee;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空", groups = BaseInterface.class)
    @Size(max = 16, message = "手机号不能超过16位", groups = BaseInterface.class)
    private String mobile;

    /**
     * 邮政编码
     */
    @ApiModelProperty("邮政编码")
    @Size(max = 10, message = "邮政编码不能超过10位", groups = BaseInterface.class)
    private String zipCode;

    /**
     * 省份编码
     */
    @ApiModelProperty("省份编码")
    private String provinceCode;

    /**
     * 省份名称
     */
    @ApiModelProperty("省份名称")
    private String provinceName;

    /**
     * 城市编码
     */
    @ApiModelProperty("城市编码")
    private String cityCode;

    /**
     * 城市名称
     */
    @ApiModelProperty("城市名称")
    private String cityName;

    /**
     * 区编码
     */
    @ApiModelProperty("区编码")
    @NotNull(message = "区编码不能为空", groups = BaseInterface.class)
    @Size(max = 16, message = "区编码不能超过16位", groups = BaseInterface.class)
    private String areaCode;

    /**
     * 区名称
     */
    @ApiModelProperty("区名称")
    private String areaName;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    @Size(max = 255, message = "详细地址不能超过255位", groups = BaseInterface.class)
    private String detailedAddress;

    /**
     * 是否默认
     */
    @ApiModelProperty("是否默认")
    @NotNull(message = "是否默认不能为空", groups = BaseInterface.class)
    private Boolean isDefault;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
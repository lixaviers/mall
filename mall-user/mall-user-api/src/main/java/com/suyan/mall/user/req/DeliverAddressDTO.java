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
    @NotNull(message = "用户唯一标识不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "用户唯一标识不能超过32位", groups = BaseInterface.class)
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
     * 省份id
     */
    @ApiModelProperty("省份id")
    @NotNull(message = "省份id不能为空", groups = BaseInterface.class)
    private Integer provinceId;
        
    /**
     * 省份名称
     */
    @ApiModelProperty("省份名称")
    @NotNull(message = "省份名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "省份名称不能超过64位", groups = BaseInterface.class)
    private String provinceName;
        
    /**
     * 城市id
     */
    @ApiModelProperty("城市id")
    @NotNull(message = "城市id不能为空", groups = BaseInterface.class)
    private Integer cityId;
        
    /**
     * 城市名称
     */
    @ApiModelProperty("城市名称")
    @NotNull(message = "城市名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "城市名称不能超过64位", groups = BaseInterface.class)
    private String cityName;
        
    /**
     * 区id
     */
    @ApiModelProperty("区id")
    @NotNull(message = "区id不能为空", groups = BaseInterface.class)
    private Integer areaId;
        
    /**
     * 区名称
     */
    @ApiModelProperty("区名称")
    @NotNull(message = "区名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "区名称不能超过64位", groups = BaseInterface.class)
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
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createTime;
        
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    private LocalDateTime updateTime;
        
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除", hidden = true)
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
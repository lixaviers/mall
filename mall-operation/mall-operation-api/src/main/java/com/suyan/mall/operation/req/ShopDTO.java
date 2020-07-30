package com.suyan.mall.operation.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class ShopDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 店铺id
     */
    @ApiModelProperty(value = "店铺id")
    @NotNull(message = "店铺id不能为空")
    private Long id;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty(value = "用户唯一标识", hidden = true)
    private String uniqueUserId;

    /**
     * 店铺名称
     */
    @ApiModelProperty("店铺名称")
    @NotNull(message = "店铺名称不能为空", groups = {BaseInterface.class, UpdateInterface.class})
    @Size(max = 128, message = "店铺名称不能超过128位", groups = {BaseInterface.class, UpdateInterface.class})
    private String shopName;

    /**
     * 店铺logo地址
     */
    @ApiModelProperty("店铺logo地址")
    @Size(max = 255, message = "店铺logo地址不能超过255位", groups = {BaseInterface.class, UpdateInterface.class})
    private String shopLogoUrl;

    /**
     * 店铺简介
     */
    @ApiModelProperty("店铺简介")
    @Size(max = 512, message = "店铺简介不能超过512位", groups = {BaseInterface.class, UpdateInterface.class})
    private String shopIntroduction;

    /**
     * 省份id
     */
    @ApiModelProperty("省份id")
    @NotNull(message = "省份id不能为空", groups = BaseInterface.class)
    private Integer provinceId;

    /**
     * 城市id
     */
    @ApiModelProperty("城市id")
    @NotNull(message = "城市id不能为空", groups = BaseInterface.class)
    private Integer cityId;

    /**
     * 区id
     */
    @ApiModelProperty("区id")
    @NotNull(message = "区id不能为空", groups = BaseInterface.class)
    private Integer areaId;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    @Size(max = 255, message = "详细地址不能超过255位", groups = BaseInterface.class)
    private String detailAddress;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte commonStatus;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createUser;

    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称", hidden = true)
    private String createUserName;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 类目id
     */
    @ApiModelProperty("类目id")
    @NotNull(message = "请选择类目", groups = BaseInterface.class)
    private Integer categoryId;


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BargainItemDTO implements Serializable {

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
     * 砍价id
     */
    @ApiModelProperty("砍价id")
    private Long bargainId;

    /**
     * 最小人数
     */
    @ApiModelProperty("最小人数")
    @NotNull(message = "最小人数不能为空", groups = BaseInterface.class)
    private Integer numberMin;

    /**
     * 最大人数
     */
    @ApiModelProperty("最大人数")
    private Integer numberMax;

    /**
     * 最小比例
     */
    @ApiModelProperty("最小比例")
    private BigDecimal promotionMin;

    /**
     * 最大比例
     */
    @ApiModelProperty("最大比例")
    private BigDecimal promotionMax;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
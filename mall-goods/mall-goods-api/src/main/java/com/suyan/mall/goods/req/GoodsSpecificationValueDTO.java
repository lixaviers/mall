/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class GoodsSpecificationValueDTO implements Serializable {

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
     * 商品id
     */
    @ApiModelProperty("商品id")
    @NotNull(message = "商品id不能为空", groups = BaseInterface.class)
    private Long goodsId;
        
    /**
     * 规格id
     */
    @ApiModelProperty("规格id")
    @NotNull(message = "规格id不能为空", groups = BaseInterface.class)
    private Long specificationId;
        
    /**
     * 规格名
     */
    @ApiModelProperty("规格名")
    @NotNull(message = "规格名不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "规格名不能超过32位", groups = BaseInterface.class)
    private String specificationName;
        
    /**
     * 规格值
     */
    @ApiModelProperty("规格值")
    @NotNull(message = "规格值不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "规格值不能超过64位", groups = BaseInterface.class)
    private String specificationValue;
        
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @NotNull(message = "排序不能为空", groups = BaseInterface.class)
    private Integer sortNumber;
        
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;
        
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updateTime;
        
    /**
     * 是否删除: 0.未删除 1.已删除
     */
    @ApiModelProperty(value = "是否删除: 0.未删除 1.已删除", hidden = true)
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("商品分类")
public class GoodsClassDTO implements Serializable {

    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空", groups = UpdateInterface.class)
    private Long id;
        
    /**
     * 父id
     */
    @ApiModelProperty("父id")
    private Long parentId;
        
    /**
     * 店铺id
     */
    @ApiModelProperty(value = "店铺id", hidden = true)
    private Long shopId;
        
    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    @NotNull(message = "分类名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "分类名称不能超过64位", groups = BaseInterface.class)
    private String className;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
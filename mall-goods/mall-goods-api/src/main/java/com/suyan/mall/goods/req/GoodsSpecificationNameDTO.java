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
public class GoodsSpecificationNameDTO implements Serializable {

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
     * 规格名称
     */
    @ApiModelProperty("规格名称")
    @NotNull(message = "规格名称不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "规格名称不能超过32位", groups = BaseInterface.class)
    private String specificationName;
        
    /**
     * 商品类目id
     */
    @ApiModelProperty("商品类目id")
    @NotNull(message = "商品类目id不能为空", groups = BaseInterface.class)
    private Integer goodsCategoryId;
        
    /**
     * 是否颜色属性
     */
    @ApiModelProperty("是否颜色属性")
    @NotNull(message = "是否颜色属性不能为空", groups = BaseInterface.class)
    private Boolean isColorAttribute;
        
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
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
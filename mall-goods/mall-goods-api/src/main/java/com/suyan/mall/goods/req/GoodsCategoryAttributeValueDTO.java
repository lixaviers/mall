package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class GoodsCategoryAttributeValueDTO implements Serializable {

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
     * 商品类目属性id
     */
    @ApiModelProperty("商品类目属性id")
    @NotNull(message = "商品类目属性id不能为空", groups = BaseInterface.class)
    private Long goodsCategoryAttributeId;
        
    /**
     * 值名称
     */
    @ApiModelProperty("值名称")
    @Size(max = 100, message = "值名称不能超过100位", groups = BaseInterface.class)
    private String valueName;
        
    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @NotNull(message = "排序不能为空", groups = BaseInterface.class)
    private Integer sortNumber;
        
    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    @NotNull(message = "是否启用不能为空", groups = BaseInterface.class)
    private Boolean isEnable;
        
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
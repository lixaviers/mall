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
public class GoodsCategoryAttributeDTO implements Serializable {

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
     * 类目id
     */
    @ApiModelProperty("类目id")
    @NotNull(message = "类目id不能为空", groups = BaseInterface.class)
    private Integer categoryId;
        
    /**
     * 属性名称
     */
    @ApiModelProperty("属性名称")
    @NotNull(message = "属性名称不能为空", groups = BaseInterface.class)
    @Size(max = 100, message = "属性名称不能超过100位", groups = BaseInterface.class)
    private String attributeName;
        
    /**
     * 是否枚举
     */
    @ApiModelProperty("是否枚举")
    @NotNull(message = "是否枚举不能为空", groups = BaseInterface.class)
    private Boolean isEnum;
        
    /**
     * 是否输入
     */
    @ApiModelProperty("是否输入")
    @NotNull(message = "是否输入不能为空", groups = BaseInterface.class)
    private Boolean isInput;
        
    /**
     * 是否必须
     */
    @ApiModelProperty("是否必须")
    @NotNull(message = "是否必须不能为空", groups = BaseInterface.class)
    private Boolean isMust;
        
    /**
     * 是否多选
     */
    @ApiModelProperty("是否多选")
    @NotNull(message = "是否多选不能为空", groups = BaseInterface.class)
    private Boolean isMultiSelect;
        
    /**
     * 是否搜索字段
     */
    @ApiModelProperty("是否搜索字段")
    @NotNull(message = "是否搜索字段不能为空", groups = BaseInterface.class)
    private Boolean isSearchField;
        
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
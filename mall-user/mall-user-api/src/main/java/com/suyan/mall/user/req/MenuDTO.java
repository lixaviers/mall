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
public class MenuDTO implements Serializable {

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
     * 父id
     */
    @ApiModelProperty("父id")
    @NotNull(message = "父id不能为空", groups = BaseInterface.class)
    private Long parentId;
        
    /**
     * 菜单类型 1.菜单 2.接口 3.按钮
     */
    @ApiModelProperty("菜单类型 1.菜单 2.接口 3.按钮")
    @NotNull(message = "菜单类型 1.菜单 2.接口 3.按钮不能为空", groups = BaseInterface.class)
    private Byte menuType;
        
    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    @NotNull(message = "菜单名称不能为空", groups = BaseInterface.class)
    @Size(max = 100, message = "菜单名称不能超过100位", groups = BaseInterface.class)
    private String menuName;
        
    /**
     * 地址
     */
    @ApiModelProperty("地址")
    @Size(max = 255, message = "地址不能超过255位", groups = BaseInterface.class)
    private String url;
        
    /**
     * 图标
     */
    @ApiModelProperty("图标")
    @Size(max = 100, message = "图标不能超过100位", groups = BaseInterface.class)
    private String icon;
        
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
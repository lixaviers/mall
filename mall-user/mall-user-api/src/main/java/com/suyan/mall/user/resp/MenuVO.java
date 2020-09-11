package com.suyan.mall.user.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("菜单")
public class MenuVO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 父id
     */
    @ApiModelProperty("父id")
    private Long parentId;

    /**
     * 菜单类型 1.菜单 2.接口 3.按钮
     */
    @ApiModelProperty("菜单类型 1.菜单 2.接口 3.按钮")
    private Byte menuType;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String menuName;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String url;

    /**
     * 图标
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sortNumber;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    private Boolean isEnable;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 子菜单集合
     */
    private List<MenuVO> children;

    /**
     * 增加子菜单
     */
    public void addChild(MenuVO menuVO) {
        if (CollectionUtils.isEmpty(children)) {
            children = new ArrayList<>();
        }
        children.add(menuVO);
    }


}
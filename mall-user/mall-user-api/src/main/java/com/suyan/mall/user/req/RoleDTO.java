package com.suyan.mall.user.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
public class RoleDTO implements Serializable {

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
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @NotNull(message = "角色名称不能为空", groups = BaseInterface.class)
    @Size(max = 100, message = "角色名称不能超过100位", groups = BaseInterface.class)
    private String roleName;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


    /**
     * 菜单id列表
     */
    @ApiModelProperty("菜单id列表")
    private List<Long> menuIds;


}
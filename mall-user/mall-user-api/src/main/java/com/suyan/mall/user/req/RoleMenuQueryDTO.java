package com.suyan.mall.user.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoleMenuQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("角色id列表")
    private List<Long> roleIdList;

    @ApiModelProperty("菜单id")
    private Long menuId;

    @ApiModelProperty("菜单id列表")
    private List<Long> menuIdList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
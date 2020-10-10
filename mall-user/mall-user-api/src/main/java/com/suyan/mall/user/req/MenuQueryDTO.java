package com.suyan.mall.user.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MenuQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("父id")
    private Long parentId;

    @ApiModelProperty("父id列表")
    private List<Long> parentIdList;

    @ApiModelProperty("菜单编码")
    private String menuCode;

    @ApiModelProperty("菜单编码列表")
    private List<String> menuCodeList;

    @ApiModelProperty("菜单编码模糊字段")
    private String menuCodeLike;

    @ApiModelProperty("菜单类型 1.菜单 2.接口 3.按钮")
    private Byte menuType;

    @ApiModelProperty("菜单类型 1.菜单 2.接口 3.按钮列表")
    private List<Byte> menuTypeList;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单名称列表")
    private List<String> menuNameList;

    @ApiModelProperty("菜单名称模糊字段")
    private String menuNameLike;

    @ApiModelProperty("地址")
    private String url;

    @ApiModelProperty("地址列表")
    private List<String> urlList;

    @ApiModelProperty("地址模糊字段")
    private String urlLike;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("图标列表")
    private List<String> iconList;

    @ApiModelProperty("图标模糊字段")
    private String iconLike;

    @ApiModelProperty("排序")
    private Integer sortNumber;

    @ApiModelProperty("排序列表")
    private List<Integer> sortNumberList;

    @ApiModelProperty("是否启用")
    private Boolean isEnable;

    @ApiModelProperty("是否启用列表")
    private List<Boolean> isEnableList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("是否删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除列表")
    private List<Boolean> isDeletedList;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoodsCategoryQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("id列表")
    private List<Integer> idList;

    @ApiModelProperty("父类id")
    private Integer parentId;

    @ApiModelProperty("父类id列表")
    private List<Integer> parentIdList;

    @ApiModelProperty("类目名称")
    private String categoryName;

    @ApiModelProperty("类目名称列表")
    private List<String> categoryNameList;

    @ApiModelProperty("类目名称模糊字段")
    private String categoryNameLike;

    @ApiModelProperty("类型 1.前台 2.后台")
    private Byte categoryType;

    @ApiModelProperty("类型 1.前台 2.后台列表")
    private List<Byte> categoryTypeList;

    @ApiModelProperty("层级")
    private Integer categoryLevel;

    @ApiModelProperty("层级列表")
    private List<Integer> categoryLevelList;

    @ApiModelProperty("类目id全路径")
    private String fullIdPath;

    @ApiModelProperty("类目id全路径列表")
    private List<String> fullIdPathList;

    @ApiModelProperty("类目id全路径模糊字段")
    private String fullIdPathLike;

    @ApiModelProperty("类目名称全路径")
    private String fullNamePath;

    @ApiModelProperty("类目名称全路径列表")
    private List<String> fullNamePathList;

    @ApiModelProperty("类目名称全路径模糊字段")
    private String fullNamePathLike;

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
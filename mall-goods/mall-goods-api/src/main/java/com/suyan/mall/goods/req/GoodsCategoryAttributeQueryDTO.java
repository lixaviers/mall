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
public class GoodsCategoryAttributeQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("类目id")
    private Integer categoryId;

    @ApiModelProperty("类目id列表")
    private List<Integer> categoryIdList;

    @ApiModelProperty("属性名称")
    private String attributeName;

    @ApiModelProperty("属性名称列表")
    private List<String> attributeNameList;

    @ApiModelProperty("属性名称模糊字段")
    private String attributeNameLike;

    @ApiModelProperty("是否枚举")
    private Boolean isEnum;

    @ApiModelProperty("是否枚举列表")
    private List<Boolean> isEnumList;

    @ApiModelProperty("是否输入")
    private Boolean isInput;

    @ApiModelProperty("是否输入列表")
    private List<Boolean> isInputList;

    @ApiModelProperty("是否必须")
    private Boolean isMust;

    @ApiModelProperty("是否必须列表")
    private List<Boolean> isMustList;

    @ApiModelProperty("是否多选")
    private Boolean isMultiSelect;

    @ApiModelProperty("是否多选列表")
    private List<Boolean> isMultiSelectList;

    @ApiModelProperty("是否搜索字段")
    private Boolean isSearchField;

    @ApiModelProperty("是否搜索字段列表")
    private List<Boolean> isSearchFieldList;

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
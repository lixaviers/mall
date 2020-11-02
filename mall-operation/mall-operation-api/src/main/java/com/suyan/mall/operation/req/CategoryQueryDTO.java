/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CategoryQueryDTO extends QueryDTO {

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

    @ApiModelProperty("排序")
    private Integer sortNumber;

    @ApiModelProperty("排序列表")
    private List<Integer> sortNumberList;

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
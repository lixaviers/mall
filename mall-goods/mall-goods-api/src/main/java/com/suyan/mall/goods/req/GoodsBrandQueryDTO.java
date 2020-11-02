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
public class GoodsBrandQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("id列表")
    private List<Integer> idList;

    @ApiModelProperty("品牌名称")
    private String brandName;

    @ApiModelProperty("品牌名称列表")
    private List<String> brandNameList;

    @ApiModelProperty("品牌名称模糊字段")
    private String brandNameLike;

    @ApiModelProperty("品牌logo")
    private String brandLogo;

    @ApiModelProperty("品牌logo列表")
    private List<String> brandLogoList;

    @ApiModelProperty("品牌logo模糊字段")
    private String brandLogoLike;

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
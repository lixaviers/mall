/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("分页输入参数基类")
@Data
public class QueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields pageNo : 第几页
     */
    @ApiModelProperty("第几页")
    private int pageNo = 1;

    /**
     * @Fields pageSize : 每页多少数据
     */
    @ApiModelProperty("每页多少数据")
    private int pageSize = 10;

    /**
     * @Fields orderBy : 排序
     */
    @ApiModelProperty("排序")
    private String orderBy;

    /**
     * @Fields returnFields : 指定返回哪些字段
     */
    @ApiModelProperty("指定返回哪些字段")
    private String returnFields;

}

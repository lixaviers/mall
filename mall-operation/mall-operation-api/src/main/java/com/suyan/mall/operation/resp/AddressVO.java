/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("地址")
public class AddressVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 父类id
     */
    @ApiModelProperty("父类id")
    private Integer parentId;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 拼音
     */
    @ApiModelProperty("拼音")
    private String pinyin;

    /**
     * 编码
     */
    @ApiModelProperty("编码")
    private String addressCode;

    /**
     * 区号
     */
    @ApiModelProperty("区号")
    private String areaCode;

    /**
     * 邮政编码
     */
    @ApiModelProperty("邮政编码")
    private String zipCode;

    /**
     * 层级
     */
    @ApiModelProperty("层级")
    private Byte addressLevel;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("枚举实体")
@Data
public class EnumEntityVO {
    @ApiModelProperty("值")
    private Byte value;
    @ApiModelProperty("文本")
    private String label;


    public EnumEntityVO() {
    }

    public EnumEntityVO(Byte value, String label) {
        this.value = value;
        this.label = label;
    }

}

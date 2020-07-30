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

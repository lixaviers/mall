package com.suyan.mall.goods.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsSpecificationDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 规格名称
     */
    @ApiModelProperty("规格名称")
    private String name;

    /**
     * 规格值
     */
    @ApiModelProperty("规格值")
    private String[] values;

}
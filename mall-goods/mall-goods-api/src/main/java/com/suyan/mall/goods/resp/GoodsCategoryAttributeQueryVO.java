package com.suyan.mall.goods.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("商品类目属性")
public class GoodsCategoryAttributeQueryVO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 类目id
     */
    @ApiModelProperty("类目id")
    private Integer categoryId;

    /**
     * 属性名称
     */
    @ApiModelProperty("属性名称")
    private String attributeName;

    /**
     * 是否枚举
     */
    @ApiModelProperty("是否枚举")
    private Boolean isEnum;

    /**
     * 是否输入
     */
    @ApiModelProperty("是否输入")
    private Boolean isInput;

    /**
     * 是否必须
     */
    @ApiModelProperty("是否必须")
    private Boolean isMust;

    /**
     * 是否多选
     */
    @ApiModelProperty("是否多选")
    private Boolean isMultiSelect;

    /**
     * 是否搜索字段
     */
    @ApiModelProperty("是否搜索字段")
    private Boolean isSearchField;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sortNumber;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    private Boolean isEnable;

    /**
     * 值id
     */
    @ApiModelProperty("值id")
    private Long valueId;

    /**
     * 值名称
     */
    @ApiModelProperty("值名称")
    private String valueName;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer valueSortNumber;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    private Boolean valueIsEnable;

}
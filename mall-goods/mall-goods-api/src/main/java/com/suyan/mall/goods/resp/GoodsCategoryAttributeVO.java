package com.suyan.mall.goods.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("商品类目属性")
public class GoodsCategoryAttributeVO implements Serializable {

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
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
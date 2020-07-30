package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GoodsSpecificationNameQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("规格名称")
    private String specificationName;

    @ApiModelProperty("规格名称列表")
    private List<String> specificationNameList;

    @ApiModelProperty("规格名称模糊字段")
    private String specificationNameLike;

    @ApiModelProperty("商品类目id")
    private Integer goodsCategoryId;

    @ApiModelProperty("商品类目id列表")
    private List<Integer> goodsCategoryIdList;

    @ApiModelProperty("是否颜色属性")
    private Boolean isColorAttribute;

    @ApiModelProperty("是否颜色属性列表")
    private List<Boolean> isColorAttributeList;

    @ApiModelProperty("创建时间起")
    private Date createTimeFrom;

    @ApiModelProperty("创建时间止")
    private Date createTimeTo;

    @ApiModelProperty("更新时间起")
    private Date updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private Date updateTimeTo;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
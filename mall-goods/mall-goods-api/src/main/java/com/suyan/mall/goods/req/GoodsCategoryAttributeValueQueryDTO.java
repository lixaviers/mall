package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoodsCategoryAttributeValueQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("商品类目属性id")
    private Long goodsCategoryAttributeId;

    @ApiModelProperty("商品类目属性id列表")
    private List<Long> goodsCategoryAttributeIdList;

    @ApiModelProperty("值名称")
    private String valueName;

    @ApiModelProperty("值名称列表")
    private List<String> valueNameList;

    @ApiModelProperty("值名称模糊字段")
    private String valueNameLike;

    @ApiModelProperty("排序")
    private Integer sortNumber;

    @ApiModelProperty("排序列表")
    private List<Integer> sortNumberList;

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
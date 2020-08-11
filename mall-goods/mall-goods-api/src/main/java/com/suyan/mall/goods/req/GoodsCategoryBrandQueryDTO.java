package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoodsCategoryBrandQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("商品品牌id")
    private Integer goodsBrandId;

    @ApiModelProperty("商品品牌id列表")
    private List<Integer> goodsBrandIdList;

    @ApiModelProperty("商品类目id")
    private Integer goodsCategoryId;

    @ApiModelProperty("商品类目id列表")
    private List<Integer> goodsCategoryIdList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
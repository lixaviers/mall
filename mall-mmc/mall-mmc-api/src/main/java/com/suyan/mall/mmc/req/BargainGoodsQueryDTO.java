package com.suyan.mall.mmc.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BargainGoodsQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("砍价活动id")
    private Long bargainActivityId;

    @ApiModelProperty("砍价活动id列表")
    private List<Long> bargainActivityIdList;

    @ApiModelProperty("有效期类型 1.24h 2.48h 3.72h")
    private Byte validityDateType;

    @ApiModelProperty("有效期类型 1.24h 2.48h 3.72h列表")
    private List<Byte> validityDateTypeList;

    @ApiModelProperty("商品编码")
    private String goodsSkuCode;

    @ApiModelProperty("商品编码列表")
    private List<String> goodsSkuCodeList;

    @ApiModelProperty("商品编码模糊字段")
    private String goodsSkuCodeLike;

    @ApiModelProperty("价格起")
    private BigDecimal priceFrom;

    @ApiModelProperty("价格止")
    private BigDecimal priceTo;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("库存列表")
    private List<Integer> inventoryList;

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
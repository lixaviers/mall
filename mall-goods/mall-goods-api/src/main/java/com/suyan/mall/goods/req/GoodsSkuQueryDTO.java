package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class GoodsSkuQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("商品编码")
    private String skuCode;

    @ApiModelProperty("商品编码列表")
    private List<String> skuCodeList;

    @ApiModelProperty("商品编码模糊字段")
    private String skuCodeLike;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("店铺id列表")
    private List<Long> shopIdList;

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品id列表")
    private List<Long> goodsIdList;

    @ApiModelProperty("价格起")
    private BigDecimal priceFrom;

    @ApiModelProperty("价格止")
    private BigDecimal priceTo;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("库存列表")
    private List<Integer> inventoryList;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("销量列表")
    private List<Integer> salesList;

    @ApiModelProperty("状态")
    private Byte commonStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> commonStatusList;

    @ApiModelProperty("创建时间起")
    private Date createTimeFrom;

    @ApiModelProperty("创建时间止")
    private Date createTimeTo;

    @ApiModelProperty("更新时间起")
    private Date updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private Date updateTimeTo;

    @ApiModelProperty("是否删除: 0.未删除 1.已删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除: 0.未删除 1.已删除列表")
    private List<Boolean> isDeletedList;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
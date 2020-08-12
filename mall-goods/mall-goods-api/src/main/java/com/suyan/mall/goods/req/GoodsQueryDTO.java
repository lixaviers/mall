package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoodsQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("店铺id")
    private Long shopId;

    @ApiModelProperty("店铺id列表")
    private List<Long> shopIdList;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品名称列表")
    private List<String> goodsNameList;

    @ApiModelProperty("商品名称模糊字段")
    private String goodsNameLike;

    @ApiModelProperty("类目id")
    private Integer goodsCategoryId;

    @ApiModelProperty("类目id列表")
    private List<Integer> goodsCategoryIdList;

    @ApiModelProperty("品牌id")
    private Integer brandId;

    @ApiModelProperty("品牌id列表")
    private List<Integer> brandIdList;

    @ApiModelProperty("是否多规格")
    private Boolean isMoreSpec;

    @ApiModelProperty("是否多规格列表")
    private List<Boolean> isMoreSpecList;

    @ApiModelProperty("原价起")
    private BigDecimal originalPriceFrom;

    @ApiModelProperty("原价止")
    private BigDecimal originalPriceTo;

    @ApiModelProperty("列表价起")
    private BigDecimal listPriceFrom;

    @ApiModelProperty("列表价止")
    private BigDecimal listPriceTo;

    @ApiModelProperty("主图")
    private String mainPhoto;

    @ApiModelProperty("主图列表")
    private List<String> mainPhotoList;

    @ApiModelProperty("主图模糊字段")
    private String mainPhotoLike;

    @ApiModelProperty("库存")
    private Integer inventory;

    @ApiModelProperty("库存列表")
    private List<Integer> inventoryList;

    @ApiModelProperty("快递运费起")
    private BigDecimal expressFreightFrom;

    @ApiModelProperty("快递运费止")
    private BigDecimal expressFreightTo;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("销量列表")
    private List<Integer> salesList;

    @ApiModelProperty("限制每人可以购买数量 0.不限购")
    private Integer perPersonLimit;

    @ApiModelProperty("限制每人可以购买数量 0.不限购列表")
    private List<Integer> perPersonLimitList;

    @ApiModelProperty("浏览量")
    private Integer viewCount;

    @ApiModelProperty("浏览量列表")
    private List<Integer> viewCountList;

    @ApiModelProperty("状态")
    private Byte goodsStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> goodsStatusList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

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
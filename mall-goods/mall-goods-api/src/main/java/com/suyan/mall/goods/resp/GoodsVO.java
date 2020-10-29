package com.suyan.mall.goods.resp;

import com.suyan.mall.goods.req.GoodsAttributeDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ApiModel("商品")
public class GoodsVO implements Serializable {

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
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    private Long shopId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * 类目id
     */
    @ApiModelProperty("类目id")
    private Integer goodsCategoryId;

    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private Integer brandId;

    /**
     * 是否多规格
     */
    @ApiModelProperty("是否多规格")
    private Boolean isMoreSpec;

    /**
     * 规格值json
     */
    @ApiModelProperty("规格值json")
    private String specValue;

    /**
     * 原价
     */
    @ApiModelProperty("原价")
    private BigDecimal originalPrice;

    /**
     * 列表价
     */
    @ApiModelProperty("列表价")
    private BigDecimal listPrice;

    /**
     * 起订量
     */
    @ApiModelProperty("起订量")
    private Integer minimumQuantity;

    /**
     * 快递运费
     */
    @ApiModelProperty("快递运费")
    private BigDecimal expressFreight;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String pictureUrls;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    private Integer inventory;

    /**
     * 销量
     */
    @ApiModelProperty("销量")
    private Integer sales;

    /**
     * 限制每人可以购买数量 0.不限购
     */
    @ApiModelProperty("限制每人可以购买数量 0.不限购")
    private Integer perPersonLimit;

    /**
     * 浏览量
     */
    @ApiModelProperty("浏览量")
    private Integer viewCount;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte goodsStatus;

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
     * 是否删除: 0.未删除 1.已删除
     */
    @ApiModelProperty("是否删除: 0.未删除 1.已删除")
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 商品sku
     */
    @ApiModelProperty("商品sku")
    private List<GoodsSkuVO> skuList;

    /**
     * 规格列表
     */
    @ApiModelProperty(value = "规格列表")
    private List<GoodsSpecificationNameVO> specificationList;

    /**
     * 商品详情
     */
    @ApiModelProperty("商品详情")
    private String description;

    /**
     * 商品属性
     */
    @ApiModelProperty("商品属性")
    private List<GoodsAttributeVO> attributeList;

}
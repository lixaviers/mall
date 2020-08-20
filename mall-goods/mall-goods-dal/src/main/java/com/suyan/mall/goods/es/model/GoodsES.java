package com.suyan.mall.goods.es.model;

import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.model.GoodsSpecification;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(indexName = "opluso_alias", type = "_doc", shards = 3, replicas = 1)
public class GoodsES {


    /**
     * id
     */
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 后台类目id
     */
    private Integer goodsCategoryId;

    /**
     * 品牌id
     */
    private Integer brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 是否多规格
     */
    private Boolean isMoreSpec;

    /**
     * 规格值json
     */
    private String specValue;

    /**
     * 原价
     */
    private BigDecimal originalPrice;

    /**
     * 列表价
     */
    private BigDecimal listPrice;

    /**
     * 起订量
     */
    private Integer minimumQuantity;

    /**
     * 快递运费
     */
    private BigDecimal expressFreight;

    /**
     * 图片
     */
    private String pictureUrls;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 限制每人可以购买数量 0.不限购
     */
    private Integer perPersonLimit;

    /**
     * 浏览量
     */
    private Integer viewCount;

    /**
     * 状态
     */
    private Byte goodsStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除: 0.未删除 1.已删除
     */
    private Boolean isDeleted;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    private Integer inventory;


}
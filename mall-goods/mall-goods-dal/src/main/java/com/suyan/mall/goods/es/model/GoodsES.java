package com.suyan.mall.goods.es.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Data
@Document(indexName = "suyan_goods", type = "goods", shards = 3, replicas = 1)
public class GoodsES {

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 店铺id
     */
    @Field(type = FieldType.Long)
    private Long shopId;

    /**
     * 商品名称
     */
    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String goodsName;

    /**
     * 前台类目id
     */
    @Field(type = FieldType.Text, analyzer = "standard", fielddata = true)
    private String goodsForegroundCategoryIdStr;

    /**
     * 前台类目名称
     */
    @Field(type = FieldType.Text, analyzer = "whitespace")
    private String goodsForegroundCategoryNameStr;

    /**
     * 后台类目id
     */
    @Field(type = FieldType.Integer)
    private Integer goodsBackgroundCategoryId;

    /**
     * 品牌id
     */
    @Field(type = FieldType.Integer, fielddata = true)
    private Integer brandId;

    /**
     * 品牌名称
     */
    @Field(type = FieldType.Text, analyzer = "whitespace")
    private String brandName;

    /**
     * 列表价
     */
    @Field(type = FieldType.Double)
    private BigDecimal listPrice;

    /**
     * 图片 keyword：不分词，只能搜索该字段的完整的值，只用于 filtering
     */
    @Field(type = FieldType.Keyword)
    private String pictureUrls;

    /**
     * 库存
     */
    @Field(type = FieldType.Integer)
    private Integer inventory;

    /**
     * 销量
     */
    @Field(type = FieldType.Integer)
    private Integer sales;

    /**
     * 浏览量
     */
    @Field(type = FieldType.Integer)
    private Integer viewCount;

    /**
     * 状态
     */
    @Field(type = FieldType.Integer)
    private Byte goodsStatus;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Keyword)
    private String createTime;

    /**
     * 更新时间
     */
    @Field(type = FieldType.Keyword)
    private String updateTime;

    /**
     * 是否删除: 0.未删除 1.已删除
     */
    @Field(type = FieldType.Boolean)
    private Boolean isDeleted;


}
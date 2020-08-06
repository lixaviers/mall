package com.suyan.mall.goods.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsSku {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品编码
     */
    private String skuCode;
    
    /**
     * 店铺id
     */
    private Long shopId;
    
    /**
     * 商品id
     */
    private Long goodsId;
    
    /**
     * 规格值
     */
    private String specValue;
    
    /**
     * 价格
     */
    private BigDecimal price;
    
    /**
     * 库存
     */
    private Integer inventory;
    
    /**
     * 销量
     */
    private Integer sales;
    
    /**
     * 状态
     */
    private Byte commonStatus;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 是否删除: 0.未删除 1.已删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 商品名称
     */
    private String goodsName;


}
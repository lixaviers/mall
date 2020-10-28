package com.suyan.mall.goods.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GoodsAttribute {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品id
     */
    private Long goodsId;
    
    /**
     * 商品类目属性id
     */
    private Long goodsCategoryAttributeId;
    
    /**
     * 商品类目属性名称
     */
    private String goodsCategoryAttributeName;
    
    /**
     * 商品类目属性值id
     */
    private Long goodsCategoryAttributeValueId;
    
    /**
     * 商品类目属性值名称
     */
    private String goodsCategoryAttributeValueName;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
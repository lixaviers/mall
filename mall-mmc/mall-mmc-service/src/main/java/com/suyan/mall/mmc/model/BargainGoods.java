package com.suyan.mall.mmc.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BargainGoods {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 砍价活动id
     */
    private Long bargainActivityId;
    
    /**
     * 有效期类型 1.24h 2.48h 3.72h
     */
    private Byte validityDateType;
    
    /**
     * 商品编码
     */
    private String goodsSkuCode;
    
    /**
     * 价格
     */
    private BigDecimal price;
    
    /**
     * 库存
     */
    private Integer inventory;
    
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
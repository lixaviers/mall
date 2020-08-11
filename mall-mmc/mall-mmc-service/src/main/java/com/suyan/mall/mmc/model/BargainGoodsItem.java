package com.suyan.mall.mmc.model;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BargainGoodsItem {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 砍价商品id
     */
    private Long bargainGoodsId;
    
    /**
     * 最小人数
     */
    private Integer numberMin;
    
    /**
     * 最大人数
     */
    private Integer numberMax;
    
    /**
     * 最小比例
     */
    private BigDecimal promotionMin;
    
    /**
     * 最大比例
     */
    private BigDecimal promotionMax;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
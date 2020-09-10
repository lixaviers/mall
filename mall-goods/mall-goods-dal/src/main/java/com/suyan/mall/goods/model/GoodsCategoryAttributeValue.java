package com.suyan.mall.goods.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GoodsCategoryAttributeValue {

    
    /**
     * id
     */
    private Long id;
    
    /**
     * 商品类目属性id
     */
    private Long goodsCategoryAttributeId;
    
    /**
     * 值名称
     */
    private String valueName;
    
    /**
     * 排序
     */
    private Integer sortNumber;
    
    /**
     * 是否启用
     */
    private Boolean isEnable;
    
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
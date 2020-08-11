package com.suyan.mall.goods.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GoodsBrand {

    
    /**
     * id
     */
    private Integer id;
    
    /**
     * 品牌名称
     */
    private String brandName;
    
    /**
     * 品牌logo
     */
    private String brandLogo;
    
    /**
     * 品牌介绍
     */
    private String brandIntroduce;
    
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
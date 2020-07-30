package com.suyan.mall.goods.model;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsCategory {

    
    /**
     * id
     */
    private Integer id;
    
    /**
     * 父类id
     */
    private Integer parentId;
    
    /**
     * 类目名称
     */
    private String categoryName;
    
    /**
     * 是否启用
     */
    private Boolean isEnable;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
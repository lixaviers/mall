package com.suyan.mall.operation.model;

import lombok.Data;

@Data
public class Address {

    
    /**
     * id
     */
    private Integer id;
    
    /**
     * 父类id
     */
    private Integer parentId;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 排序
     */
    private Integer orderNum;
    
    /**
     * 层级
     */
    private Byte addressLevel;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
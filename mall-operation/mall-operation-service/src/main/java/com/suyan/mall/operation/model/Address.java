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
     * 拼音
     */
    private String pinyin;
    
    /**
     * 编码
     */
    private String addressCode;
    
    /**
     * 区号
     */
    private String areaCode;
    
    /**
     * 邮政编码
     */
    private String zipCode;
    
    /**
     * 层级
     */
    private Byte addressLevel;
    
    /**
     * 排序
     */
    private Integer orderNum;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
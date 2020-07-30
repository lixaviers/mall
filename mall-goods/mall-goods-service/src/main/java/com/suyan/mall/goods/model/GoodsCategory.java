package com.suyan.mall.goods.model;

import lombok.Data;

import java.time.LocalDateTime;

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
     * 类型 1.前台 2.后台
     */
    private Byte categoryType;

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
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}
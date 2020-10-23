package com.suyan.mall.goods.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GoodsCategoryAttribute {


    /**
     * id
     */
    private Long id;

    /**
     * 类目id
     */
    private Integer categoryId;

    /**
     * 属性名称
     */
    private String attributeName;

    /**
     * 是否枚举
     */
    private Boolean isEnum;

    /**
     * 是否输入
     */
    private Boolean isInput;

    /**
     * 是否必须
     */
    private Boolean isMust;

    /**
     * 是否多选
     */
    private Boolean isMultiSelect;

    /**
     * 是否搜索字段
     */
    private Boolean isSearchField;

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

    private List<GoodsCategoryAttributeValue> attributeValues;

}
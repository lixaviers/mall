/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GoodsCategoryRelation {


    /**
     * id
     */
    private Long id;

    /**
     * 前台类目id
     */
    private Integer leftId;

    /**
     * 后台类目id
     */
    private Integer rightId;

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
package com.suyan.mall.operation.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Shop {


    /**
     * 店铺id
     */
    private Long id;

    /**
     * 用户唯一标识
     */
    private String uniqueUserId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺logo地址
     */
    private String shopLogoUrl;

    /**
     * 店铺简介
     */
    private String shopIntroduction;

    /**
     * 省份id
     */
    private Integer provinceId;

    /**
     * 省份
     */
    private String provinceName;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 区id
     */
    private Integer areaId;

    /**
     * 区
     */
    private String areaName;

    /**
     * 详细地址
     */
    private String detailAddress;

    /**
     * 状态
     */
    private Byte commonStatus;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除：0.未删除，1.已删除
     */
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


    /**
     * 类目id
     */
    private Integer categoryId;

}
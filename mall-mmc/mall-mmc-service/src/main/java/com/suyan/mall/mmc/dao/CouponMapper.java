/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.Coupon;
import com.suyan.mall.mmc.model.CouponExample;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {

    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Coupon selectByPrimaryKeyForUpdate(Long id);

    List<Coupon> queryCoupon(CouponQueryDTO couponQuery);

    int insertBatch(@Param("modelList") List<Coupon> modelList);


}
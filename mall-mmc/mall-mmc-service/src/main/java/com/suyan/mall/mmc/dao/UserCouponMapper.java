/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.UserCoupon;
import com.suyan.mall.mmc.model.UserCouponExample;
import com.suyan.mall.mmc.req.UserCouponQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserCouponMapper {
    
    long countByExample(UserCouponExample example);

    int deleteByExample(UserCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCoupon record);

    int insertSelective(UserCoupon record);

    List<UserCoupon> selectByExample(UserCouponExample example);

    UserCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCoupon record, @Param("example") UserCouponExample example);

    int updateByExample(@Param("record") UserCoupon record, @Param("example") UserCouponExample example);

    int updateByPrimaryKeySelective(UserCoupon record);

    int updateByPrimaryKey(UserCoupon record);


    UserCoupon selectByPrimaryKeyForUpdate(Long id);

    List<UserCoupon> queryUserCoupon(UserCouponQueryDTO userCouponQuery);

    int insertBatch(@Param("modelList") List<UserCoupon> modelList);


    UserCoupon selectByCouponCode(@Param("couponCode") String couponCode);    


}
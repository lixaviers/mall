/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.CouponChannel;
import com.suyan.mall.mmc.model.CouponChannelExample;
import com.suyan.mall.mmc.req.CouponChannelQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CouponChannelMapper {
    
    long countByExample(CouponChannelExample example);

    int deleteByExample(CouponChannelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponChannel record);

    int insertSelective(CouponChannel record);

    List<CouponChannel> selectByExample(CouponChannelExample example);

    CouponChannel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CouponChannel record, @Param("example") CouponChannelExample example);

    int updateByExample(@Param("record") CouponChannel record, @Param("example") CouponChannelExample example);

    int updateByPrimaryKeySelective(CouponChannel record);

    int updateByPrimaryKey(CouponChannel record);


    CouponChannel selectByPrimaryKeyForUpdate(Long id);

    List<CouponChannel> queryCouponChannel(CouponChannelQueryDTO couponChannelQuery);

    int insertBatch(@Param("modelList") List<CouponChannel> modelList);

    
    List<CouponChannel> selectByCouponId(@Param("couponId") Long couponId);


}
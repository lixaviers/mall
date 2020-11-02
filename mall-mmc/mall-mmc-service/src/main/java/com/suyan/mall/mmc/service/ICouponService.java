/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.CouponDTO;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import com.suyan.mall.mmc.resp.CouponVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface ICouponService {

    /**
     * 删除优惠券
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteCoupon(Long id);
    
    /**
     * 创建优惠券
     * 
     * @param couponDTO
     * @return
     */
    Long createCoupon(CouponDTO couponDTO);


    /**
     * 更新优惠券
     * 
     * @param couponDTO
     * @return
     */
    int updateCoupon(CouponDTO couponDTO);
    
    /**
     * 根据ID获取优惠券信息
     * 
     * @param id
     * @return
     */
    CouponVO getCoupon(Long id);

    /**
     * 分页查询优惠券信息
     * 
     * @param couponQueryDTO
     * @return
     */
    QueryResultVO<CouponVO> queryCoupon(CouponQueryDTO couponQueryDTO);



}
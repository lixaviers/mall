/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.ICouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.CouponBiz;
import com.suyan.mall.mmc.convertor.CouponConvertor;
import com.suyan.mall.mmc.model.Coupon;
import com.suyan.mall.mmc.req.CouponDTO;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import com.suyan.mall.mmc.resp.CouponVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 优惠券管理类>
 */
@Slf4j
@Service("couponService")
public class CouponServiceImpl implements ICouponService {

    @Autowired
    private CouponBiz couponBiz;

    @Override
    public int deleteCoupon(Long id) {
        return couponBiz.deleteCoupon(id);
    }

    @Override
    public Long createCoupon(CouponDTO couponDTO) {
        return couponBiz.createCoupon(CouponConvertor.toCoupon(couponDTO));
    }

    @Override
    public int updateCoupon(CouponDTO couponDTO) {
        return couponBiz.updateCoupon(CouponConvertor.toCoupon(couponDTO));
    }

    @Override
    public CouponVO getCoupon(Long id ) {
        return CouponConvertor.toCouponVO(couponBiz.getCoupon(id));
    }

    @Override
    public QueryResultVO<CouponVO> queryCoupon(CouponQueryDTO couponQueryDTO) {
        return CouponConvertor.toQueryResult(couponBiz.queryCoupon(couponQueryDTO));
    }

}
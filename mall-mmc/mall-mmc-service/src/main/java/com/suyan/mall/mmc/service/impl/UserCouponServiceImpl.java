/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.IUserCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.UserCouponBiz;
import com.suyan.mall.mmc.convertor.UserCouponConvertor;
import com.suyan.mall.mmc.model.UserCoupon;
import com.suyan.mall.mmc.req.UserCouponDTO;
import com.suyan.mall.mmc.req.UserCouponQueryDTO;
import com.suyan.mall.mmc.resp.UserCouponVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 用户优惠券管理类>
 */
@Slf4j
@Service("userCouponService")
public class UserCouponServiceImpl implements IUserCouponService {

    @Autowired
    private UserCouponBiz userCouponBiz;

    @Override
    public int deleteUserCoupon(Long id) {
        return userCouponBiz.deleteUserCoupon(id);
    }

    @Override
    public Long createUserCoupon(UserCouponDTO userCouponDTO) {
        return userCouponBiz.createUserCoupon(UserCouponConvertor.toUserCoupon(userCouponDTO));
    }

    @Override
    public int updateUserCoupon(UserCouponDTO userCouponDTO) {
        return userCouponBiz.updateUserCoupon(UserCouponConvertor.toUserCoupon(userCouponDTO));
    }

    @Override
    public UserCouponVO getUserCoupon(Long id ) {
        return UserCouponConvertor.toUserCouponVO(userCouponBiz.getUserCoupon(id));
    }

    @Override
    public QueryResultVO<UserCouponVO> queryUserCoupon(UserCouponQueryDTO userCouponQueryDTO) {
        return UserCouponConvertor.toQueryResult(userCouponBiz.queryUserCoupon(userCouponQueryDTO));
    }

}
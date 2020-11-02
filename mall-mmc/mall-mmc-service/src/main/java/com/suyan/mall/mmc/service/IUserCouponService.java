/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.UserCouponDTO;
import com.suyan.mall.mmc.req.UserCouponQueryDTO;
import com.suyan.mall.mmc.resp.UserCouponVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IUserCouponService {

    /**
     * 删除用户优惠券
     * 
     * @author 
     * @param id
     * @return
     */
    int deleteUserCoupon(Long id);
    
    /**
     * 创建用户优惠券
     * 
     * @param userCouponDTO
     * @return
     */
    Long createUserCoupon(UserCouponDTO userCouponDTO);


    /**
     * 更新用户优惠券
     * 
     * @param userCouponDTO
     * @return
     */
    int updateUserCoupon(UserCouponDTO userCouponDTO);
    
    /**
     * 根据ID获取用户优惠券信息
     * 
     * @param id
     * @return
     */
    UserCouponVO getUserCoupon(Long id);

    /**
     * 分页查询用户优惠券信息
     * 
     * @param userCouponQueryDTO
     * @return
     */
    QueryResultVO<UserCouponVO> queryUserCoupon(UserCouponQueryDTO userCouponQueryDTO);



}
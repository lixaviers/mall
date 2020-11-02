/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.UserCouponMapper;
import com.suyan.mall.mmc.model.UserCoupon;
import com.suyan.mall.mmc.req.UserCouponQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层用户优惠券管理类>
 */
@Slf4j
@Service
public class UserCouponBiz {

    @Autowired
    private UserCouponMapper userCouponMapper;


    /**
     * 删除用户优惠券
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteUserCoupon(Long id) {
        // TODO: Describe business logic and implement it
        getBaseUserCoupon(id);
        return userCouponMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建用户优惠券
     *
     * @param userCoupon
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createUserCoupon(UserCoupon userCoupon) {
        // TODO: Describe business logic and implement it
        userCouponMapper.insertSelective(userCoupon);
        return userCoupon.getId();
    }

    /**
     * 批量创建
     *
     * @param userCouponList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateUserCoupon(List<UserCoupon> userCouponList) {
        // TODO: Describe business logic and implement it
        return userCouponMapper.insertBatch(userCouponList);
    }

    /**
     * 更新用户优惠券
     *
     * @param userCoupon
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateUserCoupon(UserCoupon userCoupon) {
        getBaseUserCoupon(userCoupon.getId());
        return userCouponMapper.updateByPrimaryKeySelective(userCoupon);
    }

    /**
     * 根据ID获取用户优惠券信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public UserCoupon getUserCoupon(Long id) {
        return getBaseUserCoupon(id);
    }

    @Transactional(readOnly = true)
    public UserCoupon getBaseUserCoupon(Long id) {
        UserCoupon userCoupon = userCouponMapper.selectByPrimaryKey(id);
        if (userCoupon == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "用户优惠券");
        }
        return userCoupon;
    }

    /**
     * 分页查询用户优惠券信息
     *
     * @param userCouponQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<UserCoupon> queryUserCoupon(UserCouponQueryDTO userCouponQuery) {
        QueryResultVO<UserCoupon> queryResult = new QueryResultVO<UserCoupon>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(userCouponQuery.getPageNo(), userCouponQuery.getPageSize());
        List<UserCoupon> userCouponList = userCouponMapper.queryUserCoupon(userCouponQuery);
        PageInfo<UserCoupon> pageInfo = new PageInfo<UserCoupon>(userCouponList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(userCouponList);
        return queryResult;
    }

}
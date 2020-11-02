/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.UserCoupon;
import com.suyan.mall.mmc.req.UserCouponDTO;
import com.suyan.mall.mmc.resp.UserCouponVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class UserCouponConvertor {

    private static final BeanCopier beanCopierForUserCouponVO = BeanCopier.create(UserCoupon.class, UserCouponVO.class, false);
    private static final BeanCopier beanCopierForUserCoupon = BeanCopier.create(UserCouponDTO.class, UserCoupon.class, false);

    public static UserCouponVO toUserCouponVO(UserCoupon userCoupon) {
        if (userCoupon == null) {
            return null;
        }
        UserCouponVO userCouponVO = new UserCouponVO();
        beanCopierForUserCouponVO.copy(userCoupon, userCouponVO, null);
        return userCouponVO;
    }

    public static UserCoupon toUserCoupon(UserCouponDTO userCouponDTO) {
        UserCoupon userCoupon = new UserCoupon();
        beanCopierForUserCoupon.copy(userCouponDTO, userCoupon, null);
        return userCoupon;
    }

    public static List<UserCouponVO> toUserCouponVOList(List<UserCoupon> userCouponList) {
        if (userCouponList == null || userCouponList.isEmpty()) {
            return null;
        }
        List<UserCouponVO> userCouponInfoList = new ArrayList<UserCouponVO>(userCouponList.size());
        for (UserCoupon userCoupon : userCouponList) {
            userCouponInfoList.add(toUserCouponVO(userCoupon));
        }
        return userCouponInfoList;
    }

    public static List<UserCoupon> toUserCouponList(List<UserCouponDTO> userCouponDTOList) {
        if (userCouponDTOList == null || userCouponDTOList.isEmpty()) {
            return null;
        }
        List<UserCoupon> userCouponList = new ArrayList<UserCoupon>(userCouponDTOList.size());
        for (UserCouponDTO userCouponDTO : userCouponDTOList) {
            userCouponList.add(toUserCoupon(userCouponDTO));
        }
        return userCouponList;
    }

    public static QueryResultVO<UserCouponVO> toQueryResult(QueryResultVO<UserCoupon> queryResult) {
        QueryResultVO<UserCouponVO> queryResultInfo = new QueryResultVO<UserCouponVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toUserCouponVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
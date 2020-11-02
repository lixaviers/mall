/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.convertor;

import com.suyan.mall.mmc.model.CouponChannel;
import com.suyan.mall.mmc.req.CouponChannelDTO;
import com.suyan.mall.mmc.resp.CouponChannelVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class CouponChannelConvertor {

    private static final BeanCopier beanCopierForCouponChannelVO = BeanCopier.create(CouponChannel.class, CouponChannelVO.class, false);
    private static final BeanCopier beanCopierForCouponChannel = BeanCopier.create(CouponChannelDTO.class, CouponChannel.class, false);

    public static CouponChannelVO toCouponChannelVO(CouponChannel couponChannel) {
        if (couponChannel == null) {
            return null;
        }
        CouponChannelVO couponChannelVO = new CouponChannelVO();
        beanCopierForCouponChannelVO.copy(couponChannel, couponChannelVO, null);
        return couponChannelVO;
    }

    public static CouponChannel toCouponChannel(CouponChannelDTO couponChannelDTO) {
        CouponChannel couponChannel = new CouponChannel();
        beanCopierForCouponChannel.copy(couponChannelDTO, couponChannel, null);
        return couponChannel;
    }

    public static List<CouponChannelVO> toCouponChannelVOList(List<CouponChannel> couponChannelList) {
        if (couponChannelList == null || couponChannelList.isEmpty()) {
            return null;
        }
        List<CouponChannelVO> couponChannelInfoList = new ArrayList<CouponChannelVO>(couponChannelList.size());
        for (CouponChannel couponChannel : couponChannelList) {
            couponChannelInfoList.add(toCouponChannelVO(couponChannel));
        }
        return couponChannelInfoList;
    }

    public static List<CouponChannel> toCouponChannelList(List<CouponChannelDTO> couponChannelDTOList) {
        if (couponChannelDTOList == null || couponChannelDTOList.isEmpty()) {
            return null;
        }
        List<CouponChannel> couponChannelList = new ArrayList<CouponChannel>(couponChannelDTOList.size());
        for (CouponChannelDTO couponChannelDTO : couponChannelDTOList) {
            couponChannelList.add(toCouponChannel(couponChannelDTO));
        }
        return couponChannelList;
    }

    public static QueryResultVO<CouponChannelVO> toQueryResult(QueryResultVO<CouponChannel> queryResult) {
        QueryResultVO<CouponChannelVO> queryResultInfo = new QueryResultVO<CouponChannelVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toCouponChannelVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
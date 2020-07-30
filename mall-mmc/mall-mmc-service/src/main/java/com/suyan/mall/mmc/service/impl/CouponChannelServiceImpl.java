package com.suyan.mall.mmc.service.impl;

import com.suyan.mall.mmc.service.ICouponChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyan.mall.mmc.biz.CouponChannelBiz;
import com.suyan.mall.mmc.convertor.CouponChannelConvertor;
import com.suyan.mall.mmc.model.CouponChannel;
import com.suyan.mall.mmc.req.CouponChannelDTO;
import com.suyan.mall.mmc.req.CouponChannelQueryDTO;
import com.suyan.mall.mmc.resp.CouponChannelVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 优惠券渠道管理类>
 */
@Slf4j
@Service("couponChannelService")
public class CouponChannelServiceImpl implements ICouponChannelService {

    @Autowired
    private CouponChannelBiz couponChannelBiz;

    @Override
    public int deleteCouponChannel(Long id) {
        return couponChannelBiz.deleteCouponChannel(id);
    }

    @Override
    public Long createCouponChannel(CouponChannelDTO couponChannelDTO) {
        return couponChannelBiz.createCouponChannel(CouponChannelConvertor.toCouponChannel(couponChannelDTO));
    }

    @Override
    public int updateCouponChannel(CouponChannelDTO couponChannelDTO) {
        return couponChannelBiz.updateCouponChannel(CouponChannelConvertor.toCouponChannel(couponChannelDTO));
    }

    @Override
    public CouponChannelVO getCouponChannel(Long id ) {
        return CouponChannelConvertor.toCouponChannelVO(couponChannelBiz.getCouponChannel(id));
    }

    @Override
    public QueryResultVO<CouponChannelVO> queryCouponChannel(CouponChannelQueryDTO couponChannelQueryDTO) {
        return CouponChannelConvertor.toQueryResult(couponChannelBiz.queryCouponChannel(couponChannelQueryDTO));
    }

}
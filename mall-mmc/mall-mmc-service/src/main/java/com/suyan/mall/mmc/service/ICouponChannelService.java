package com.suyan.mall.mmc.service;

import com.suyan.mall.mmc.req.CouponChannelDTO;
import com.suyan.mall.mmc.req.CouponChannelQueryDTO;
import com.suyan.mall.mmc.resp.CouponChannelVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface ICouponChannelService {

    /**
     * 删除优惠券渠道
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteCouponChannel(Long id);
    
    /**
     * 创建优惠券渠道
     * 
     * @param couponChannelDTO
     * @return
     */
    Long createCouponChannel(CouponChannelDTO couponChannelDTO);


    /**
     * 更新优惠券渠道
     * 
     * @param couponChannelDTO
     * @return
     */
    int updateCouponChannel(CouponChannelDTO couponChannelDTO);
    
    /**
     * 根据ID获取优惠券渠道信息
     * 
     * @param id
     * @return
     */
    CouponChannelVO getCouponChannel(Long id);

    /**
     * 分页查询优惠券渠道信息
     * 
     * @param couponChannelQueryDTO
     * @return
     */
    QueryResultVO<CouponChannelVO> queryCouponChannel(CouponChannelQueryDTO couponChannelQueryDTO);



}
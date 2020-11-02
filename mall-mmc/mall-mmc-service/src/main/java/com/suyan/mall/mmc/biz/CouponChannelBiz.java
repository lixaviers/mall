/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.biz;

import com.suyan.mall.mmc.dao.CouponChannelMapper;
import com.suyan.mall.mmc.model.CouponChannel;
import com.suyan.mall.mmc.model.CouponChannelExample;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层优惠券渠道管理类>
 */
@Slf4j
@Service
public class CouponChannelBiz {

    @Autowired
    private CouponChannelMapper couponChannelMapper;

    /**
     * 批量创建
     *
     * @param couponChannelList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void batchCreateCouponChannel(Long couponId, List<CouponChannel> couponChannelList) {
        if (CollectionsUtil.isNotEmpty(couponChannelList)) {
            couponChannelList.forEach(couponChannel -> {
                couponChannel.setCouponId(couponId);
            });
            couponChannelMapper.insertBatch(couponChannelList);
        }
    }

    /**
     * 更新优惠券渠道
     *
     * @param couponChannelList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateCouponChannel(Long couponId, List<CouponChannel> couponChannelList) {
        List<CouponChannel> oldCouponChannel = getCouponChannelList(couponId);
        List<Byte> oldChannelIdList = oldCouponChannel.stream().map(CouponChannel::getChannelId).collect(Collectors.toList());
        List<Byte> newChannelIdList = couponChannelList.stream().map(CouponChannel::getChannelId).collect(Collectors.toList());

        // 新增的列表
        List<CouponChannel> addList = couponChannelList.stream().filter(item -> !oldChannelIdList.contains(item.getChannelId())).collect(Collectors.toList());
        batchCreateCouponChannel(couponId, addList);
        // 删除的列表
        List<Long> deleteIdList = oldCouponChannel.stream().filter(item -> !newChannelIdList.contains(item.getChannelId())).map(CouponChannel::getId).collect(Collectors.toList());
        if (CollectionsUtil.isNotEmpty(deleteIdList)) {
            CouponChannelExample example = new CouponChannelExample();
            example.createCriteria().andIdIn(deleteIdList);
            couponChannelMapper.deleteByExample(example);
        }

        // 编辑的列表
        List<CouponChannel> updateList = couponChannelList.stream().filter(item -> {
            for (CouponChannel couponChannel : oldCouponChannel) {
                if (item.getChannelId().equals(couponChannel.getChannelId())) {
                    item.setId(couponChannel.getId());
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());
        if (CollectionsUtil.isNotEmpty(updateList)) {
            for (CouponChannel couponChannel : updateList) {
                couponChannelMapper.updateByPrimaryKeySelective(couponChannel);
            }
        }

    }

    /**
     * 根据优惠券ID获取优惠券渠道信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<CouponChannel> getCouponChannelList(Long couponId) {
        CouponChannelExample example = new CouponChannelExample();
        example.createCriteria().andCouponIdEqualTo(couponId);
        return couponChannelMapper.selectByExample(example);
    }

}
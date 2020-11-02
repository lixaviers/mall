/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.biz;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.CouponMapper;
import com.suyan.mall.mmc.enums.CommonStatusMmcEnum;
import com.suyan.mall.mmc.enums.PromotionScopeEnum;
import com.suyan.mall.mmc.enums.PromotionTypeEnum;
import com.suyan.mall.mmc.enums.PromotionUseTypeEnum;
import com.suyan.mall.mmc.model.Coupon;
import com.suyan.mall.mmc.model.CouponChannel;
import com.suyan.mall.mmc.model.PromotionScope;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
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
 * @Comments: <业务层优惠券管理类>
 */
@Slf4j
@Service
public class CouponBiz {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private PromotionScopeBiz promotionScopeBiz;
    @Autowired
    private CouponChannelBiz couponChannelBiz;


    /**
     * 删除优惠券
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteCoupon(Long id) {
        getBaseCoupon(id);
        return couponMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建优惠券
     *
     * @param coupon
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createCoupon(Coupon coupon) {
        UserInfoVO shopUser = UserUtil.getShopUser();
        coupon.setShopId(shopUser.getShopId());
        // 已保存
        coupon.setCouponStatus(CommonStatusMmcEnum.SAVED.getValue());
        if (PromotionUseTypeEnum.FULL_LADDER_COUPON.equal(coupon.getCouponType())) {
            // 阶梯满减券
            coupon.setPromotionScopeAmount(JSON.toJSONString(coupon.getPromotionAmountScopeList()));
        }
        // 库存
        coupon.setInventory(coupon.getChannelList().stream().mapToInt(CouponChannel::getInventory).sum());
        couponMapper.insertSelective(coupon);
        if (PromotionScopeEnum.GOODS_CATEGORY.equal(coupon.getCouponScope())) {
            // 按商品类目
            promotionScopeBiz.batchCreatePromotionScope(PromotionTypeEnum.COUPON.getValue(), coupon.getId(), coupon.getPromotionScopeList());
        }

        // 渠道
        couponChannelBiz.batchCreateCouponChannel(coupon.getId(), coupon.getChannelList());

        return coupon.getId();
    }

    /**
     * 更新优惠券
     *
     * @param coupon
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateCoupon(Coupon coupon) {
        Coupon couponLast = getBaseCoupon(coupon.getId());
        UserInfoVO shopUser = UserUtil.getShopUser();
        if (!couponLast.getShopId().equals(shopUser.getShopId())) {
            // 非本店铺优惠券
            throw new CommonException(ResultCode.NO_PERMISSION_OPERATE, "此优惠券");
        }

        if (coupon.getCouponScope().equals(couponLast.getCouponScope())) {
            if (PromotionScopeEnum.GOODS_CATEGORY.equal(coupon.getCouponScope())) {
                // 按商品类目 对比类目
                List<PromotionScope> oldPromotionScopeList = promotionScopeBiz.getPromotionScopeListByPromotion(PromotionTypeEnum.COUPON.getValue(), coupon.getId());
                List<Integer> oldGoodsCategoryIdIdList = oldPromotionScopeList.stream().map(PromotionScope::getGoodsCategoryId).collect(Collectors.toList());

                List<Integer> newGoodsCategoryIdIdList = coupon.getPromotionScopeList().stream().map(PromotionScope::getGoodsCategoryId).collect(Collectors.toList());

                // 删除的列表
                List<Long> deleteIdList = oldPromotionScopeList.stream().filter(item -> !newGoodsCategoryIdIdList.contains(item.getGoodsCategoryId()))
                        .map(PromotionScope::getId).collect(Collectors.toList());
                if (CollectionsUtil.isNotEmpty(deleteIdList)) {
                    promotionScopeBiz.deletePromotionScope(deleteIdList);
                }
                // 新增的列表
                List<PromotionScope> addList = coupon.getPromotionScopeList().stream().filter(item -> !oldGoodsCategoryIdIdList.contains(item.getGoodsCategoryId())).collect(Collectors.toList());
                if (CollectionsUtil.isNotEmpty(addList)) {
                    promotionScopeBiz.batchCreatePromotionScope(PromotionTypeEnum.COUPON.getValue(), coupon.getId(), addList);
                }
            }
        } else {
            if (PromotionScopeEnum.GOODS_CATEGORY.equal(coupon.getCouponType())) {
                // 新增为[按商品类目]
                promotionScopeBiz.batchCreatePromotionScope(PromotionTypeEnum.COUPON.getValue(), coupon.getId(), coupon.getPromotionScopeList());
            } else if (PromotionScopeEnum.SHOP.equal(coupon.getCouponType())) {
                // 新增为[全店通用]
                promotionScopeBiz.deletePromotionScopeByPromotion(PromotionTypeEnum.COUPON.getValue(), coupon.getId());
            }
        }

        // 更新渠道
        couponChannelBiz.updateCouponChannel(coupon.getId(), coupon.getChannelList());

        // 库存
        coupon.setInventory(coupon.getChannelList().stream().mapToInt(CouponChannel::getInventory).sum());
        return couponMapper.updateByPrimaryKeySelective(coupon);
    }

    /**
     * 根据ID获取优惠券信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Coupon getCoupon(Long id) {
        Coupon coupon = getBaseCoupon(id);
        coupon.setPromotionScopeList(promotionScopeBiz.getPromotionScopeListByPromotion(PromotionTypeEnum.COUPON.getValue(), id));
        coupon.setChannelList(couponChannelBiz.getCouponChannelList(id));
        return coupon;
    }

    @Transactional(readOnly = true)
    public Coupon getBaseCoupon(Long id) {
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        if (coupon == null || coupon.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "优惠券");
        }
        return coupon;
    }

    /**
     * 分页查询优惠券信息
     *
     * @param couponQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Coupon> queryCoupon(CouponQueryDTO couponQuery) {
        QueryResultVO<Coupon> queryResult = new QueryResultVO<Coupon>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(couponQuery.getPageNo(), couponQuery.getPageSize());
        List<Coupon> couponList = couponMapper.queryCoupon(couponQuery);
        PageInfo<Coupon> pageInfo = new PageInfo<Coupon>(couponList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(couponList);
        return queryResult;
    }

}
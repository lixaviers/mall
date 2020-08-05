package com.suyan.mall.mmc.biz;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.mmc.dao.CouponMapper;
import com.suyan.mall.mmc.enums.CommonStatusMmcEnum;
import com.suyan.mall.mmc.enums.PromotionTypeEnum;
import com.suyan.mall.mmc.enums.PromotionScopeEnum;
import com.suyan.mall.mmc.enums.PromotionUseTypeEnum;
import com.suyan.mall.mmc.model.Coupon;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
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
 * @Comments: <业务层优惠券管理类>
 */
@Slf4j
@Service
public class CouponBiz {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private PromotionScopeBiz promotionScopeBiz;


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
        couponMapper.insertSelective(coupon);
        if (PromotionScopeEnum.GOODS_CATEGORY.equal(coupon.getCouponScope())) {
            coupon.getPromotionScopeList().forEach(promotionScope -> {
                promotionScope.setPromotionType(PromotionTypeEnum.COUPON.getValue());
                promotionScope.setPromotionId(coupon.getId());
            });
            // 按商品类目
            promotionScopeBiz.batchCreatePromotionScope(coupon.getPromotionScopeList());
        }
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
        return getBaseCoupon(id);
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
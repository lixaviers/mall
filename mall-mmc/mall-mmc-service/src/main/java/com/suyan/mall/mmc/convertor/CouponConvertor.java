package com.suyan.mall.mmc.convertor;

import com.alibaba.fastjson.JSON;
import com.suyan.mall.mmc.enums.PromotionUseTypeEnum;
import com.suyan.mall.mmc.model.Coupon;
import com.suyan.mall.mmc.model.PromotionAmountScope;
import com.suyan.mall.mmc.req.CouponDTO;
import com.suyan.mall.mmc.resp.CouponVO;
import com.suyan.mall.mmc.resp.PromotionAmountScopeVO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.BeanUtil;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class CouponConvertor {

    private static final BeanCopier beanCopierForCouponVO = BeanCopier.create(Coupon.class, CouponVO.class, false);
    private static final BeanCopier beanCopierForCoupon = BeanCopier.create(CouponDTO.class, Coupon.class, false);

    public static CouponVO toCouponVO(Coupon coupon) {
        if (coupon == null) {
            return null;
        }
        CouponVO couponVO = new CouponVO();
        beanCopierForCouponVO.copy(coupon, couponVO, null);
        couponVO.setCouponTypeDesc(PromotionUseTypeEnum.getDescByValue(coupon.getCouponType()));
        couponVO.setPromotionAmountScopeList(JSON.parseArray(coupon.getPromotionScopeAmount(), PromotionAmountScopeVO.class));
        return couponVO;
    }

    public static Coupon toCoupon(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        beanCopierForCoupon.copy(couponDTO, coupon, null);
        coupon.setPromotionAmountScopeList(BeanUtil.fastBeanCopy(couponDTO.getPromotionScopeList(), PromotionAmountScope.class));
        coupon.setPromotionScopeList(PromotionScopeConvertor.toPromotionScopeList(couponDTO.getPromotionScopeList()));
        return coupon;
    }

    public static List<CouponVO> toCouponVOList(List<Coupon> couponList) {
        if (couponList == null || couponList.isEmpty()) {
            return null;
        }
        List<CouponVO> couponInfoList = new ArrayList<CouponVO>(couponList.size());
        for (Coupon coupon : couponList) {
            couponInfoList.add(toCouponVO(coupon));
        }
        return couponInfoList;
    }

    public static List<Coupon> toCouponList(List<CouponDTO> couponDTOList) {
        if (couponDTOList == null || couponDTOList.isEmpty()) {
            return null;
        }
        List<Coupon> couponList = new ArrayList<Coupon>(couponDTOList.size());
        for (CouponDTO couponDTO : couponDTOList) {
            couponList.add(toCoupon(couponDTO));
        }
        return couponList;
    }

    public static QueryResultVO<CouponVO> toQueryResult(QueryResultVO<Coupon> queryResult) {
        QueryResultVO<CouponVO> queryResultInfo = new QueryResultVO<CouponVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toCouponVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
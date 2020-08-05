package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.enums.PromotionScopeEnum;
import com.suyan.mall.mmc.req.CouponDTO;
import com.suyan.mall.mmc.req.CouponQueryDTO;
import com.suyan.mall.mmc.resp.CouponVO;
import com.suyan.mall.mmc.service.ICouponService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/b/coupon")
@RestController
@Api(tags = "优惠券管理接口")
public class CouponController extends BaseController {

    @Autowired
    private ICouponService couponService;

    @ApiOperation(value = "删除优惠券", notes = "删除优惠券")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(couponService.deleteCoupon(id));
    }

    @ApiOperation(value = "创建优惠券", notes = "创建优惠券")
    @PostMapping("addOrUpdate")
    public Result<Long> addOrUpdate(@Validated({BaseInterface.class}) @RequestBody CouponDTO couponDTO) {
        if (PromotionScopeEnum.GOODS_CATEGORY.equal(couponDTO.getCouponScope()) && CollectionUtils.isEmpty(couponDTO.getPromotionScopeList())) {
            return Result.newError(ResultCode.COMMON_MESSAGE, "请选择商品类目");
        }
        if (couponDTO.getId() == null) {
            couponService.createCoupon(couponDTO);
        } else {
            couponService.updateCoupon(couponDTO);
        }
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取优惠券信息", notes = "根据优惠券ID获取优惠券信息")
    @GetMapping("get/{id}")
    public Result<CouponVO> get(@PathVariable Long id) {
        return Result.newSuccess(couponService.getCoupon(id));
    }

    @ApiOperation(value = "获取优惠券列表信息", notes = "分页获取优惠券列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<CouponVO>> queryCoupon(@Validated @RequestBody CouponQueryDTO couponQueryDTO) {
        couponQueryDTO.setShopId(getUser().getShopId());
        couponQueryDTO.setIsDeleted(false);
        return Result.newSuccess(couponService.queryCoupon(couponQueryDTO));
    }
}

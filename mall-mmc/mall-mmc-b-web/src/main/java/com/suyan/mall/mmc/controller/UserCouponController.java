package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.req.UserCouponDTO;
import com.suyan.mall.mmc.req.UserCouponQueryDTO;
import com.suyan.mall.mmc.resp.UserCouponVO;
import com.suyan.mall.mmc.service.IUserCouponService;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/b/userCoupon")
@RestController
@Api(tags = "用户优惠券管理接口")
public class UserCouponController extends BaseController {

    @Autowired
    private IUserCouponService userCouponService;

    @ApiOperation(value = "更新用户优惠券", notes = "更新用户优惠券")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody UserCouponDTO userCouponDTO) {
        UserInfoVO user = getUser();
        userCouponDTO.setCreateTime(null);
        userCouponDTO.setCreateUser(null);
        userCouponDTO.setCreateUserName(null);
        userCouponDTO.setUpdateTime(null);
        return Result.newSuccess(userCouponService.updateUserCoupon(userCouponDTO));
    }

    @ApiOperation(value = "获取用户优惠券信息", notes = "根据用户优惠券ID获取用户优惠券信息")
    @GetMapping("get/{id}")
    public Result<UserCouponVO> get(@PathVariable Long id) {
        return Result.newSuccess(userCouponService.getUserCoupon(id));
    }

    @ApiOperation(value = "获取用户优惠券列表信息", notes = "分页获取用户优惠券列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<UserCouponVO>> queryUserCoupon(@Validated @RequestBody UserCouponQueryDTO userCouponQueryDTO) {
        return Result.newSuccess(userCouponService.queryUserCoupon(userCouponQueryDTO));
    }

}

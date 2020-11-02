/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.controller;

import com.suyan.annotation.PassLogin;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.mall.operation.service.IShopService;
import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/c/shop")
@RestController
@Api(value = "/c/shop", tags = "店铺管理接口")
public class ShopController extends BaseController {

    @Autowired
    private IShopService shopService;

    @ApiOperation(value = "店铺信息", notes = "店铺信息(设置用户店铺id)")
    @GetMapping("getShopInfo/{id}")
    @PassLogin
    public Result<ShopVO> getShopInfo(@PathVariable Long id) {
        ShopVO shop = shopService.getShop(id);
        shop.setUniqueUserId(null);
        UserInfoVO user = getUser();
        if (user != null && (user.getShopId() == null || !shop.getId().equals(user.getShopId()))) {
            user.setShopId(shop.getId());
            UserUtil.setRedisUser(user, user.getSessionId(), SystemPlatformEnum.C.getCode());
        }
        return Result.newSuccess(shop);
    }

}

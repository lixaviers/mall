/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.controller;

import com.suyan.mall.operation.req.ShopDTO;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.mall.operation.service.IShopService;
import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/b/shop")
@RestController
@Api(value = "/b/shop", tags = "店铺管理接口")
public class ShopController extends BaseController {

    @Autowired
    private IShopService shopService;

    @ApiOperation(value = "创建店铺", notes = "创建店铺")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody ShopDTO shopDTO) {
        UserInfoVO user = getUser();
        shopDTO.setUniqueUserId(user.getUniqueUserId());
        shopDTO.setCreateUser(user.getUserName());
        shopDTO.setCreateUserName(user.getNickName());
        return Result.newSuccess(shopService.createShop(shopDTO));
    }

    @ApiOperation(value = "店铺列表", notes = "查询用户店铺列表")
    @GetMapping("list")
    public Result<List<ShopVO>> list() {
        return Result.newSuccess(shopService.getShopList(getUser().getUniqueUserId()));
    }

    @ApiOperation(value = "选择店铺", notes = "用户选择店铺")
    @GetMapping("select/{id}")
    public Result select(@PathVariable Long id) {
        UserInfoVO shopUser = getUser();
        ShopVO shopVO = shopService.select(shopUser.getUniqueUserId(), id);
        shopUser.setShopId(id);
        shopUser.setShopName(shopVO.getShopName());
        UserUtil.setRedisUser(shopUser, shopUser.getSessionId(), SystemPlatformEnum.B.getCode());
        return Result.newSuccess();
    }

    @ApiOperation(value = "店铺信息", notes = "店铺信息")
    @GetMapping("info")
    public Result<ShopVO> info() {
        return Result.newSuccess(shopService.getShop(getUser().getShopId()));
    }

    @ApiOperation(value = "修改店铺", notes = "修改店铺信息")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody ShopDTO shopDTO) {
        UserInfoVO user = getUser();
        shopDTO.setId(user.getShopId());
        return Result.newSuccess(shopService.updateShop(shopDTO));
    }

}

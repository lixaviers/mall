/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.controller;

import com.suyan.mall.user.req.ShopCollectDTO;
import com.suyan.mall.user.req.ShopCollectQueryDTO;
import com.suyan.mall.user.resp.ShopCollectVO;
import com.suyan.mall.user.service.IShopCollectService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/c/shopCollect")
@RestController
@Api(tags = "店铺收藏管理接口")
public class ShopCollectController extends BaseController {

    @Autowired
    private IShopCollectService shopCollectService;

    @ApiOperation(value = "删除店铺收藏", notes = "删除店铺收藏")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(shopCollectService.deleteShopCollect(id));
    }

    @ApiOperation(value = "创建店铺收藏", notes = "创建店铺收藏")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody ShopCollectDTO shopCollectDTO) {
        return Result.newSuccess(shopCollectService.createShopCollect(shopCollectDTO));
    }

    @ApiOperation(value = "置顶店铺收藏", notes = "置顶店铺收藏")
    @PostMapping("setTop")
    public Result<Integer> setTop(@Validated({UpdateInterface.class}) @RequestBody ShopCollectDTO shopCollectDTO) {
        shopCollectService.setTop(shopCollectDTO);
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取店铺收藏列表信息", notes = "分页获取店铺收藏列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<ShopCollectVO>> queryShopCollect(@Validated @RequestBody ShopCollectQueryDTO shopCollectQueryDTO) {
        shopCollectQueryDTO.setIsDeleted(false);
        return Result.newSuccess(shopCollectService.queryShopCollect(shopCollectQueryDTO));
    }
}

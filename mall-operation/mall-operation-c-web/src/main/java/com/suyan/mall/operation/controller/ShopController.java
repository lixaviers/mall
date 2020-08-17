package com.suyan.mall.operation.controller;

import com.suyan.annotation.PassLogin;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.mall.operation.service.IShopService;
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

    @ApiOperation(value = "店铺信息", notes = "店铺信息")
    @GetMapping("getShop/{id}")
    @PassLogin
    public Result<ShopVO> getShop(@PathVariable Long id) {
        ShopVO shop = shopService.getShop(id);
        shop.setUniqueUserId(null);
        return Result.newSuccess(shop);
    }

}

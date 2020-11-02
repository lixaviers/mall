/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.goods.service.IGoodsSkuService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/c/goodsSku")
@RestController
@Api(tags = "商品sku管理接口")
public class GoodsSkuController extends BaseController {

    @Autowired
    private IGoodsSkuService goodsSkuService;

    @ApiOperation(value = "获取商品信息", notes = "根据商品sku获取商品信息")
    @PostMapping("getInfo")
    public Result<List<GoodsSkuVO>> getInfo(@RequestBody List<String> skuCodeList) {
        return Result.newSuccess(goodsSkuService.getGoodsSku(skuCodeList));
    }

}

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.feigncontroller;

import com.suyan.mall.goods.feignClient.c.GoodsCFeignClient;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.goods.service.IGoodsService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/feign/c/goods")
@RestController
@Api(tags = "商品feign管理接口")
public class GoodsFeignController implements GoodsCFeignClient {

    @Autowired
    private IGoodsService getGoodsSku;

    @Override
    @ApiOperation(value = "根据商品id查询信息", notes = "根据商品id查询信息")
    @PostMapping("/get/{id}")
    public Result<GoodsVO> get(@PathVariable Long id) {
        return Result.newSuccess(getGoodsSku.getGoodsInfo(id));
    }

    @Override
    @ApiOperation(value = "根据商品id列表查询信息", notes = "根据商品id列表查询信息")
    @PostMapping("/get")
    public Result<List<GoodsVO>> get(@RequestBody List<Long> idList) {
        return Result.newSuccess(getGoodsSku.getGoodsInfo(idList));
    }

}

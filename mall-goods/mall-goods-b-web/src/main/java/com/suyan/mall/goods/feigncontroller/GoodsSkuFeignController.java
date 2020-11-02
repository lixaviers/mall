/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.feigncontroller;

import com.suyan.mall.goods.feignClient.b.GoodsSkuFeignClient;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.mall.goods.service.IGoodsSkuService;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/feign/b/goodsSku")
@RestController
@Api(tags = "商品skufeign管理接口")
public class GoodsSkuFeignController implements GoodsSkuFeignClient {

    @Autowired
    private IGoodsSkuService goodsSkuService;

    @Override
    @ApiOperation(value = "修改库存", notes = "修改库存")
    @PostMapping(value = "/updateInventory")
    public Result<Integer> updateInventory(@Validated({BaseInterface.class}) @RequestBody GoodsSkuInventoryLogDTO logDTO) {
        goodsSkuService.updateInventory(logDTO);
        return Result.newSuccess();
    }
}

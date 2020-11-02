/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.feigncontroller;

import com.suyan.mall.goods.feignClient.c.GoodsSkuCFeignClient;
import com.suyan.mall.goods.req.GoodsSkuDTO;
import com.suyan.mall.goods.req.c.GoodsSkuDeductionInventoryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.goods.service.IGoodsSkuService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/feign/c/goodsSku")
@RestController
@Api(tags = "商品skufeign管理接口")
public class GoodsSkuFeignController implements GoodsSkuCFeignClient {

    @Autowired
    private IGoodsSkuService goodsSkuService;

    @Override
    @ApiOperation(value = "根据商品编码查询信息", notes = "根据商品编码查询信息")
    @PostMapping("/get")
    public Result<List<GoodsSkuVO>> get(@RequestBody List<String> skuCodeList) {
        return Result.newSuccess(goodsSkuService.getGoodsSku(skuCodeList));
    }

    @Override
    @ApiOperation(value = "扣减库存", notes = "根据商品编码列表扣减库存")
    @PostMapping("/deductionInventory")
    public Result<Integer> deductionInventory(@Validated(GoodsSkuDTO.DeductionInventory.class) @RequestBody GoodsSkuDeductionInventoryDTO dto) {
        goodsSkuService.deductionInventory(dto);
        return Result.newSuccess();
    }

}

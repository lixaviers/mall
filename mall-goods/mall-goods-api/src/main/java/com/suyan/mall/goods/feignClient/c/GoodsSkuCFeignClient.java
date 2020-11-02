/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.feignClient.c;

import com.suyan.mall.goods.req.c.GoodsSkuDeductionInventoryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "mall-goods-c-web", path = "/feign/c/goodsSku")
public interface GoodsSkuCFeignClient {

    /**
     * 根据商品编码查询信息
     *
     * @return
     */
    @PostMapping("/get")
    Result<List<GoodsSkuVO>> get(@RequestBody List<String> skuCodeList);

    /**
     * 扣减库存
     *
     * @return
     */
    @PostMapping("/deductionInventory")
    Result<Integer> deductionInventory(@RequestBody GoodsSkuDeductionInventoryDTO dto);

}

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.feignClient.b;

import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "mall-goods-b-web", path = "/feign/b/goodsSku")
public interface GoodsSkuFeignClient {

    /**
     * 修改库存
     *
     * @return
     */
    @PostMapping(value = "/updateInventory")
    Result<Integer> updateInventory(@RequestBody GoodsSkuInventoryLogDTO logDTO);

}

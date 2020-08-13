package com.suyan.mall.goods.feignClient;

import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "mall-goods-b-web", path = "/feign/goodsSku")
public interface GoodsSkuFeignClient {

    /**
     * 修改库存
     *
     * @return
     */
    @PostMapping(value = "/updateInventory")
    Result<Integer> updateInventory(@RequestBody GoodsSkuInventoryLogDTO logDTO);

}

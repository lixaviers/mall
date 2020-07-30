package com.suyan.mall.operation.feignClient;

import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "mall-operation-b-web", path = "/feign/shop")
public interface ShopFeignClient {

    /**
     * 获取用户店铺列表
     *
     * @param uniqueUserId 用户唯一标识
     * @return
     */
    @GetMapping(value = "/getUserShopList")
    Result<List<ShopVO>> getUserShopList(@RequestParam("uniqueUserId") String uniqueUserId);


}

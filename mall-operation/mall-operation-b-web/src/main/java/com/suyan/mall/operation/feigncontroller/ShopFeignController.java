package com.suyan.mall.operation.feigncontroller;

import com.suyan.mall.operation.feignClient.b.ShopFeignClient;
import com.suyan.mall.operation.resp.ShopVO;
import com.suyan.mall.operation.service.IShopService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/feign/shop")
@RestController
@Api(tags = "店铺feign管理接口")
public class ShopFeignController implements ShopFeignClient {

    @Autowired
    private IShopService shopService;

    @GetMapping(value = "/getUserShopList")
    @Override
    public Result<List<ShopVO>> getUserShopList(@RequestParam("uniqueUserId") String uniqueUserId) {
        return Result.newSuccess(shopService.getShopList(uniqueUserId));
    }

}

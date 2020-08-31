package com.suyan.mall.user.feigncontroller;

import com.suyan.mall.user.feignClient.c.DeliverAddressCFeignClient;
import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.mall.user.service.IDeliverAddressService;
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
@RequestMapping("/feign/c/deliverAddress")
@RestController
@Api(tags = "收货地址管理接口")
public class DeliverAddressFeignController implements DeliverAddressCFeignClient {

    @Autowired
    private IDeliverAddressService deliverAddressService;

    @Override
    @ApiOperation(value = "获取收货地址信息", notes = "根据收货地址ID获取收货地址信息")
    @GetMapping("get/{id}")
    public Result<DeliverAddressVO> get(@PathVariable Long id) {
        return Result.newSuccess(deliverAddressService.getDeliverAddress(id));
    }

}

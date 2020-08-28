package com.suyan.mall.operation.feigncontroller;

import com.suyan.mall.operation.feignClient.c.AddressFeignClient;
import com.suyan.mall.operation.req.c.AddressListDTO;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.mall.operation.service.IAddressService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/feign/c/address")
@RestController
@Api(tags = "地址feign管理接口")
public class AddressFeignController implements AddressFeignClient {

    @Autowired
    private IAddressService addressService;

    @GetMapping(value = "/getAddressByCode")
    @Override
    public Result<List<AddressVO>> getAddressByCode(@RequestParam("addressCode") String addressCode) {
        return Result.newSuccess(addressService.getAddressByCode(addressCode));
    }

}

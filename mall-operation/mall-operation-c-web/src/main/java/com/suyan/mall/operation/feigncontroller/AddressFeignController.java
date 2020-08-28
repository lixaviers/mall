package com.suyan.mall.operation.feigncontroller;

import com.suyan.mall.operation.feignClient.c.AddressFeignClient;
import com.suyan.mall.operation.req.c.AddressListDTO;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.mall.operation.service.IAddressService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/feign/c/shop")
@RestController
@Api(tags = "地址feign管理接口")
public class AddressFeignController implements AddressFeignClient {

    @Autowired
    private IAddressService addressService;

    @GetMapping(value = "/getAddressList")
    @Override
    public Result<List<AddressVO>> getAddressList(@RequestBody AddressListDTO dto) {
        return Result.newSuccess(addressService.getAddressList(dto));
    }

}

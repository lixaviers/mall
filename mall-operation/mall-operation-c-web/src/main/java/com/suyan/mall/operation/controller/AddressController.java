package com.suyan.mall.operation.controller;

import com.suyan.annotation.PassLogin;
import com.suyan.mall.operation.resp.AddressVO;
import com.suyan.mall.operation.service.IAddressService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/c/address")
@RestController
@Api(tags = "地址管理接口")
public class AddressController {

    @Autowired
    private IAddressService addressService;

}

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
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
@RequestMapping("/b/address")
@RestController
@Api(value = "/b/address", tags = "地址管理接口")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @ApiOperation(value = "获取地址信息", notes = "获取地址信息")
    @GetMapping("get/{parentId}")
    @PassLogin
    public Result<List<AddressVO>> get(@PathVariable Integer parentId) {
        return Result.newSuccess(addressService.getAddress(parentId));
    }

}

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.feigncontroller;

import com.suyan.mall.operation.controller.BaseController;
import com.suyan.mall.operation.feignClient.b.MqMessageDataFeignClient;
import com.suyan.mall.operation.req.MqMessageDataDTO;
import com.suyan.mall.operation.service.IMqMessageDataService;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/feign/mqMessageData")
@RestController
@Api(tags = "消息数据管理接口")
public class MqMessageDataFeignController implements MqMessageDataFeignClient {

    @Autowired
    private IMqMessageDataService mqMessageDataService;

    @ApiOperation(value = "创建消息数据", notes = "创建消息数据")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody MqMessageDataDTO mqMessageDataDTO) {
        return Result.newSuccess(mqMessageDataService.createMqMessageData(mqMessageDataDTO));
    }

}

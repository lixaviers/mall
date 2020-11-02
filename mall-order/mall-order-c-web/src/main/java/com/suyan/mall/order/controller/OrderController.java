/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.controller;

import com.suyan.mall.order.req.OrderDTO;
import com.suyan.mall.order.req.OrderQueryDTO;
import com.suyan.mall.order.resp.OrderVO;
import com.suyan.mall.order.service.IOrderService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/c/order")
@RestController
@Api(tags = "订单管理接口")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation(value = "创建订单", notes = "创建订单")
    @PostMapping("add")
    public Result<OrderVO> add(@Validated({BaseInterface.class}) @RequestBody OrderDTO orderDTO) {
        return Result.newSuccess(orderService.createOrder(orderDTO));
    }

    @ApiOperation(value = "删除订单", notes = "删除订单")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(orderService.deleteOrder(id));
    }

    @ApiOperation(value = "获取订单信息", notes = "根据订单号获取订单信息")
    @GetMapping("get/{orderNumber}")
    public Result<OrderVO> get(@PathVariable String orderNumber) {
        return Result.newSuccess(orderService.getOrder(orderNumber));
    }

    @ApiOperation(value = "获取订单列表信息", notes = "分页获取订单列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<OrderVO>> queryOrder(@Validated @RequestBody OrderQueryDTO orderQueryDTO) {
        orderQueryDTO.setIsDeleted(false);
        return Result.newSuccess(orderService.queryOrder(orderQueryDTO));
    }

}

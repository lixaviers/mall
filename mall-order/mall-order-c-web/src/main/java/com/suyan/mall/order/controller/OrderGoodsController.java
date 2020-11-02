/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.order.controller;

import com.suyan.mall.order.req.OrderGoodsQueryDTO;
import com.suyan.mall.order.resp.OrderGoodsVO;
import com.suyan.mall.order.service.IOrderGoodsService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/c/orderGoods")
@RestController
@Api(tags = "订单商品管理接口")
public class OrderGoodsController extends BaseController {

    @Autowired
    private IOrderGoodsService orderGoodsService;

    @ApiOperation(value = "删除订单商品", notes = "删除订单商品")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(orderGoodsService.deleteOrderGoods(id));
    }

    @ApiOperation(value = "获取订单商品信息", notes = "根据订单商品ID获取订单商品信息")
    @GetMapping("get/{id}")
    public Result<OrderGoodsVO> get(@PathVariable Long id) {
        return Result.newSuccess(orderGoodsService.getOrderGoods(id));
    }

    @ApiOperation(value = "获取订单商品列表信息", notes = "分页获取订单商品列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<OrderGoodsVO>> queryOrderGoods(@Validated @RequestBody OrderGoodsQueryDTO orderGoodsQueryDTO) {
        orderGoodsQueryDTO.setIsDeleted(false);
        return Result.newSuccess(orderGoodsService.queryOrderGoods(orderGoodsQueryDTO));
    }
}

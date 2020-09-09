package com.suyan.mall.order.controller;

import com.suyan.mall.order.req.ShoppingCartDTO;
import com.suyan.mall.order.req.ShoppingCartQueryDTO;
import com.suyan.mall.order.resp.ShoppingCartVO;
import com.suyan.mall.order.service.IShoppingCartService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/c/shoppingCart")
@RestController
@Api(tags = "购物车管理接口")
public class ShoppingCartController extends BaseController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @ApiOperation(value = "创建购物车", notes = "创建购物车")
    @PostMapping("add")
    public Result add(@Validated({BaseInterface.class}) @RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.createShoppingCart(shoppingCartDTO);
        return Result.newSuccess();
    }

    @ApiOperation(value = "修改数量", notes = "修改数量")
    @PostMapping("updateNumber")
    public Result updateNumber(@Validated({ShoppingCartDTO.UpdateNumber.class}) @RequestBody ShoppingCartDTO shoppingCartDTO) {
        shoppingCartService.updateNumber(shoppingCartDTO);
        return Result.newSuccess();
    }

    @ApiOperation(value = "删除购物车", notes = "删除购物车")
    @PostMapping("delete")
    public Result delete(@RequestBody List<Long> idList) {
        shoppingCartService.deleteShoppingCart(idList);
        return Result.newSuccess();
    }

    @ApiOperation(value = "移入收藏夹", notes = "移入收藏夹")
    @PostMapping("collect")
    public Result collect(@RequestBody List<Long> idList) {
        shoppingCartService.collect(idList);
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取购物车信息", notes = "根据购物车ID获取购物车信息")
    @GetMapping("get/{id}")
    public Result<ShoppingCartVO> get(@PathVariable Long id) {
        return Result.newSuccess(shoppingCartService.getShoppingCart(id));
    }

    @ApiOperation(value = "获取购物车列表信息", notes = "分页获取购物车列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<ShoppingCartVO>> queryShoppingCart(@Validated @RequestBody ShoppingCartQueryDTO shoppingCartQueryDTO) {
        shoppingCartQueryDTO.setIsDeleted(false);
        return Result.newSuccess(shoppingCartService.queryShoppingCart(shoppingCartQueryDTO));
    }

}

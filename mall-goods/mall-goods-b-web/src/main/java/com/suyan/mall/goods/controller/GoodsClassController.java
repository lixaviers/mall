/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.req.GoodsClassDTO;
import com.suyan.mall.goods.req.GoodsClassQueryDTO;
import com.suyan.mall.goods.resp.GoodsClassVO;
import com.suyan.mall.goods.service.IGoodsClassService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("goodsClass")
@RestController
@Api(tags = "商品分类管理接口")
public class GoodsClassController extends BaseController {

    @Autowired
    private IGoodsClassService goodsClassService;

    @ApiOperation(value = "删除商品分类", notes = "删除商品分类")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(goodsClassService.deleteGoodsClass(id));
    }

    @ApiOperation(value = "创建/更新商品分类", notes = "创建/更新商品分类")
    @PostMapping("addOrUpdate")
    public Result addOrUpdate(@Validated({BaseInterface.class}) @RequestBody GoodsClassDTO goodsClassDTO) {
        goodsClassDTO.setShopId(getUser().getShopId());
        if (goodsClassDTO.getId() == null) {
            goodsClassService.createGoodsClass(goodsClassDTO);
        } else {
            goodsClassService.updateGoodsClass(goodsClassDTO);
        }
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取商品分类信息", notes = "根据商品分类ID获取商品分类信息")
    @GetMapping("get/{id}")
    public Result<GoodsClassVO> get(@ApiParam("id") @PathVariable Long id) {
        return Result.newSuccess(goodsClassService.getGoodsClass(id));
    }

    @ApiOperation(value = "获取商品分类列表信息", notes = "分页获取商品分类列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsClassVO>> queryGoodsClass(@Validated @RequestBody GoodsClassQueryDTO goodsClassQueryDTO) {
        goodsClassQueryDTO.setIsDeleted(false);
        goodsClassQueryDTO.setShopId(getUser().getShopId());
        return Result.newSuccess(goodsClassService.queryGoodsClass(goodsClassQueryDTO));
    }
}

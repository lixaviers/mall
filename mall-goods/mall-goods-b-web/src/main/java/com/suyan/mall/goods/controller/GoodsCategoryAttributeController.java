/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.resp.GoodsCategoryAttributeVO;
import com.suyan.mall.goods.service.IGoodsCategoryAttributeService;
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
@RequestMapping("goodsCategoryAttribute")
@RestController
@Api(tags = "商品类目属性管理接口")
public class GoodsCategoryAttributeController extends BaseController {

    @Autowired
    private IGoodsCategoryAttributeService goodsCategoryAttributeService;

    @ApiOperation(value = "获取商品类目属性列表信息", notes = "获取商品类目属性列表信息")
    @GetMapping("getTreeByCategoryId/{categoryId}")
    public Result<List<GoodsCategoryAttributeVO>> getTreeByCategoryId(@PathVariable Integer categoryId) {
        return Result.newSuccess(goodsCategoryAttributeService.getTreeByCategoryId(categoryId));
    }

}

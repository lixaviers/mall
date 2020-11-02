/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.controller;

import com.suyan.mall.operation.resp.CategoryVO;
import com.suyan.mall.operation.service.ICategoryService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/b/category")
@RestController
@Api(value = "/b/category", tags = "类目管理接口")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "获取类目树", notes = "获取所有类目树")
    @GetMapping("getTree")
    public Result<List<CategoryVO>> getTree() {
        return Result.newSuccess(categoryService.getTree());
    }

}

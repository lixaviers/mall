package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.resp.GoodsCategoryVO;
import com.suyan.mall.goods.service.IGoodsCategoryService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("goodsCategory")
@RestController
@Api(tags = "商品类目管理接口")
public class GoodsCategoryController extends BaseController {

    @Autowired
    private IGoodsCategoryService goodsCategoryService;

    @ApiOperation(value = "获取类目树", notes = "获取所有类目树")
    @GetMapping("getTree/{type}")
    public Result<List<GoodsCategoryVO>> getTree(@PathVariable @ApiParam("1.前台 2.后台") byte type) {
        return Result.newSuccess(goodsCategoryService.getTree(type));
    }

    @ApiOperation(value = "根据父类id查询类目", notes = "根据父类id查询类目")
    @GetMapping("getByParentId/{parentId}/{type}")
    public Result<List<GoodsCategoryVO>> getByParentId(@PathVariable @ApiParam("父类id") Integer parentId, @PathVariable @ApiParam("1.前台 2.后台") byte type) {
        return Result.newSuccess(goodsCategoryService.getByParentId(parentId, type));
    }

    @ApiOperation(value = "根据ID获取商品类目信息", notes = "根据ID获取商品类目信息")
    @GetMapping("get/{id}")
    public Result<GoodsCategoryVO> get(@PathVariable Integer id) {
        return Result.newSuccess(goodsCategoryService.getGoodsCategory(id));
    }

    @ApiOperation(value = "获取最近发布的商品类目", notes = "获取最近发布的商品类目")
    @GetMapping("getRecentlyReleasedGoodsCategory")
    public Result<GoodsCategoryVO> getRecentlyReleasedGoodsCategory() {
        return Result.newSuccess(goodsCategoryService.getRecentlyReleasedGoodsCategory());
    }


}

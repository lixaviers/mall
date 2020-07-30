package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.resp.GoodsCategoryVO;
import com.suyan.mall.goods.service.IGoodsCategoryService;
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
@RequestMapping("/b/goodsCategory")
@RestController
@Api(value = "/b/goodsCategory", tags = "商品类目管理接口")
public class GoodsCategoryController extends BaseController {

    @Autowired
    private IGoodsCategoryService goodsCategoryService;

    @ApiOperation(value = "获取类目树", notes = "获取所有类目树")
    @GetMapping("getTree")
    public Result<List<GoodsCategoryVO>> getTree() {
        return Result.newSuccess(goodsCategoryService.getTree());
    }


}

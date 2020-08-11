package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.resp.GoodsBrandVO;
import com.suyan.mall.goods.service.IGoodsBrandService;
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
@RequestMapping("/b/goodsBrand")
@RestController
@Api(tags = "商品品牌管理接口")
public class GoodsBrandController extends BaseController {

    @Autowired
    private IGoodsBrandService goodsBrandService;

    @ApiOperation(value = "获取商品品牌信息", notes = "根据商品类目ID获取商品品牌信息")
    @GetMapping("get/{categoryId}")
    public Result<List<GoodsBrandVO>> get(@PathVariable Integer categoryId) {
        return Result.newSuccess(goodsBrandService.getGoodsBrandListByCategoryId(categoryId));
    }

}

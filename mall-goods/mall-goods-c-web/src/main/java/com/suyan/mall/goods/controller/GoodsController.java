package com.suyan.mall.goods.controller;

import com.suyan.annotation.PassLogin;
import com.suyan.mall.goods.req.GoodsSearchDTO;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.goods.service.IGoodsService;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RequestMapping("/c/goods")
@RestController
@Api(tags = "商品管理接口")
public class GoodsController extends BaseController {

    @Autowired
    private IGoodsService goodsService;

    @ApiOperation(value = "商品搜索", notes = "分页商品搜索信息")
    @PostMapping("search")
    @PassLogin
    public Result<Map<String, Object>> search(@Validated @RequestBody GoodsSearchDTO goodsSearchDTO) {
        return Result.newSuccess(goodsService.search(goodsSearchDTO));
    }

    @ApiOperation(value = "获取商品信息", notes = "根据商品ID获取商品信息")
    @GetMapping("get/{id}")
    @PassLogin
    public Result<GoodsVO> get(@PathVariable Long id) {
        return Result.newSuccess(goodsService.getGoodsForC(id));
    }

}

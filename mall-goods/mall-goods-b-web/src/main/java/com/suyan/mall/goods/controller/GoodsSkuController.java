package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.goods.service.IGoodsSkuService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("goodsSku")
@RestController
@Api(tags = "商品规格管理接口")
public class GoodsSkuController extends BaseController {

    @Autowired
    private IGoodsSkuService goodsSkuService;

    @ApiOperation(value = "获取商品规格列表信息", notes = "分页获取商品规格列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsSkuVO>> queryGoodsSku(@Validated @RequestBody GoodsSkuQueryDTO goodsSkuQueryDTO) {
        goodsSkuQueryDTO.setIsDeleted(false);
        return Result.newSuccess(goodsSkuService.queryGoodsSku(goodsSkuQueryDTO));
    }

    @ApiOperation(value = "获取商品信息", notes = "根据商品编码获取商品信息")
    @GetMapping("get")
    public Result<GoodsSkuVO> get(String skuCode) {
        return Result.newSuccess(goodsSkuService.getGoodsSku(skuCode));
    }


}

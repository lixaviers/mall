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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/b/goodsSku")
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
}

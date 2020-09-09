package com.suyan.mall.user.controller;

import com.suyan.mall.user.req.GoodsCollectDTO;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import com.suyan.mall.user.resp.GoodsCollectVO;
import com.suyan.mall.user.service.IGoodsCollectService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/c/goodsCollect")
@RestController
@Api(tags = "商品收藏管理接口")
public class GoodsCollectController extends BaseController {

    @Autowired
    private IGoodsCollectService goodsCollectService;

    @ApiOperation(value = "删除商品收藏", notes = "删除商品收藏")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(goodsCollectService.deleteGoodsCollect(id));
    }

    @ApiOperation(value = "创建商品收藏", notes = "创建商品收藏")
    @PostMapping("add")
    public Result add(@Validated({BaseInterface.class}) @RequestBody GoodsCollectDTO goodsCollectDTO) {
        goodsCollectService.createGoodsCollect(goodsCollectDTO);
        return Result.newSuccess();
    }

    @ApiOperation(value = "根据商品id查询是否收藏", notes = "根据商品id查询是否收藏")
    @GetMapping("get/{goodsId}")
    public Result<Boolean> get(@PathVariable Long goodsId) {
        return Result.newSuccess(goodsCollectService.get(goodsId));
    }

    @ApiOperation(value = "查询收藏商品数", notes = "查询收藏商品数")
    @GetMapping("getNumber")
    public Result<Integer> getNumber() {
        return Result.newSuccess(goodsCollectService.getNumber());
    }

    @ApiOperation(value = "获取商品收藏列表信息", notes = "分页获取商品收藏列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsCollectVO>> queryGoodsCollect(@Validated @RequestBody GoodsCollectQueryDTO goodsCollectQueryDTO) {
        goodsCollectQueryDTO.setIsDeleted(false);
        return Result.newSuccess(goodsCollectService.queryGoodsCollect(goodsCollectQueryDTO));
    }

}

package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.enums.GoodsStatusEnum;
import com.suyan.mall.goods.req.GoodsDTO;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.mall.goods.service.IGoodsService;
import com.suyan.mall.user.resp.b.UserInfoVO;
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
@RequestMapping("/c/goods")
@RestController
@Api(tags = "商品管理接口")
public class GoodsController extends BaseController {

    @Autowired
    private IGoodsService goodsService;

    @ApiOperation(value = "创建/编辑商品", notes = "创建/编辑商品")
    @PostMapping("addOrUpdate")
    public Result<Long> addOrUpdate(@Validated({BaseInterface.class}) @RequestBody GoodsDTO goodsDTO) {
        UserInfoVO user = getUser();
        goodsDTO.setShopId(user.getShopId());
        if (goodsDTO.getId() == null) {
            goodsService.createGoods(goodsDTO);
        } else {
            goodsService.updateGoods(goodsDTO);
        }
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取商品列表信息", notes = "分页获取商品列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsVO>> queryGoods(@Validated @RequestBody GoodsQueryDTO goodsQueryDTO) {
        UserInfoVO user = getUser();
        goodsQueryDTO.setShopId(user.getShopId());
        goodsQueryDTO.setIsDeleted(false);
        return Result.newSuccess(goodsService.queryGoods(goodsQueryDTO));
    }

    @ApiOperation(value = "获取商品信息", notes = "根据商品ID获取商品信息")
    @GetMapping("get/{id}")
    public Result<GoodsVO> get(@PathVariable Long id) {
        return Result.newSuccess(goodsService.getGoods(id));
    }


    @ApiOperation(value = "商品上下架", notes = "商品上下架")
    @PostMapping("shelves/{id}/{opt}")
    public Result shelves(@PathVariable Long id, @ApiParam(name = "opt", value = "操作：1.上架 2.下架") @PathVariable int opt) {
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(id);
        goodsDTO.setGoodsStatus(opt == 1 ? GoodsStatusEnum.NORMAL.getValue() : GoodsStatusEnum.THE_SHELVES.getValue());
        goodsService.shelves(goodsDTO);
        return Result.newSuccess();
    }

}

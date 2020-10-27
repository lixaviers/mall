package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.req.GoodsSpecificationNameDTO;
import com.suyan.mall.goods.req.GoodsSpecificationNameQueryDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationNameVO;
import com.suyan.mall.goods.service.IGoodsSpecificationNameService;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("goodsSpecificationName")
@RestController
@Api(tags = "商品规格名管理接口")
public class GoodsSpecificationNameController extends BaseController {

    @Autowired
    private IGoodsSpecificationNameService goodsSpecificationNameService;

    @ApiOperation(value = "删除商品规格名", notes = "删除商品规格名")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        UserInfoVO user = getUser();
        return Result.newSuccess(goodsSpecificationNameService.deleteGoodsSpecificationName(id));
    }

    @ApiOperation(value = "创建商品规格名", notes = "创建商品规格名")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody GoodsSpecificationNameDTO goodsSpecificationNameDTO) {
        UserInfoVO user = getUser();
        goodsSpecificationNameDTO.setCreateTime(null);
        goodsSpecificationNameDTO.setUpdateTime(null);
        return Result.newSuccess(goodsSpecificationNameService.createGoodsSpecificationName(goodsSpecificationNameDTO));
    }

    @ApiOperation(value = "更新商品规格名", notes = "更新商品规格名")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody GoodsSpecificationNameDTO goodsSpecificationNameDTO) {
        UserInfoVO user = getUser();
        goodsSpecificationNameDTO.setCreateTime(null);
        goodsSpecificationNameDTO.setUpdateTime(null);
        return Result.newSuccess(goodsSpecificationNameService.updateGoodsSpecificationName(goodsSpecificationNameDTO));
    }

    @ApiOperation(value = "获取商品规格名信息", notes = "根据商品规格名ID获取商品规格名信息")
    @GetMapping("get/{id}")
    public Result<GoodsSpecificationNameVO> get(@PathVariable Long id) {
        return Result.newSuccess(goodsSpecificationNameService.getGoodsSpecificationName(id));
    }

    @ApiOperation(value = "获取商品规格名列表信息", notes = "分页获取商品规格名列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsSpecificationNameVO>> queryGoodsSpecificationName(@Validated @RequestBody GoodsSpecificationNameQueryDTO goodsSpecificationNameQueryDTO) {
        return Result.newSuccess(goodsSpecificationNameService.queryGoodsSpecificationName(goodsSpecificationNameQueryDTO));
    }
}

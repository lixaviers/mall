package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.req.GoodsSpecificationValueDTO;
import com.suyan.mall.goods.req.GoodsSpecificationValueQueryDTO;
import com.suyan.mall.goods.resp.GoodsSpecificationValueVO;
import com.suyan.mall.goods.service.IGoodsSpecificationValueService;
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
@RequestMapping("/b/goodsSpecificationValue")
@RestController
@Api(value = "/b/goodsSpecificationValue", tags = "商品规格值管理接口")
public class GoodsSpecificationValueController extends BaseController {

    @Autowired
    private IGoodsSpecificationValueService goodsSpecificationValueService;

    @ApiOperation(value = "删除商品规格值", notes = "删除商品规格值")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        UserInfoVO user = getUser();
        return Result.newSuccess(goodsSpecificationValueService.deleteGoodsSpecificationValue(id));
    }

    @ApiOperation(value = "创建商品规格值", notes = "创建商品规格值")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody GoodsSpecificationValueDTO goodsSpecificationValueDTO) {
        UserInfoVO user = getUser();
        goodsSpecificationValueDTO.setCreateTime(null);
        goodsSpecificationValueDTO.setUpdateTime(null);
        return Result.newSuccess(goodsSpecificationValueService.createGoodsSpecificationValue(goodsSpecificationValueDTO));
    }

    @ApiOperation(value = "更新商品规格值", notes = "更新商品规格值")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody GoodsSpecificationValueDTO goodsSpecificationValueDTO) {
        UserInfoVO user = getUser();
        goodsSpecificationValueDTO.setCreateTime(null);
        goodsSpecificationValueDTO.setUpdateTime(null);
        return Result.newSuccess(goodsSpecificationValueService.updateGoodsSpecificationValue(goodsSpecificationValueDTO));
    }

    @ApiOperation(value = "获取商品规格值信息", notes = "根据商品规格值ID获取商品规格值信息")
    @GetMapping("get/{id}")
    public Result<GoodsSpecificationValueVO> get(@PathVariable Long id) {
        return Result.newSuccess(goodsSpecificationValueService.getGoodsSpecificationValue(id));
    }

    @ApiOperation(value = "获取商品规格值列表信息", notes = "分页获取商品规格值列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsSpecificationValueVO>> queryGoodsSpecificationValue(@Validated @RequestBody GoodsSpecificationValueQueryDTO goodsSpecificationValueQueryDTO) {
        goodsSpecificationValueQueryDTO.setIsDeleted(false);
        return Result.newSuccess(goodsSpecificationValueService.queryGoodsSpecificationValue(goodsSpecificationValueQueryDTO));
    }
}

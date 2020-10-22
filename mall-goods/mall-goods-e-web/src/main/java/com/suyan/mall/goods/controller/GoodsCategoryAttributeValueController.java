package com.suyan.mall.goods.controller;

import com.suyan.mall.goods.req.GoodsCategoryAttributeValueDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeValueVO;
import com.suyan.mall.goods.service.IGoodsCategoryAttributeValueService;
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
@RequestMapping("goodsCategoryAttributeValue")
@RestController
@Api(tags = "商品类目属性值管理接口")
public class GoodsCategoryAttributeValueController extends BaseController {

    @Autowired
    private IGoodsCategoryAttributeValueService goodsCategoryAttributeValueService;

    @ApiOperation(value = "删除商品类目属性值", notes = "删除商品类目属性值")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(goodsCategoryAttributeValueService.deleteGoodsCategoryAttributeValue(id));
    }

    @ApiOperation(value = "更新商品类目属性值", notes = "更新商品类目属性值")
    @PostMapping("update")
    public Result<Integer> update(@Validated({BaseInterface.class, UpdateInterface.class}) @RequestBody GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO) {
        return Result.newSuccess(goodsCategoryAttributeValueService.updateGoodsCategoryAttributeValue(goodsCategoryAttributeValueDTO));
    }

    @ApiOperation(value = "获取商品类目属性值信息", notes = "根据商品类目属性值ID获取商品类目属性值信息")
    @GetMapping("get/{id}")
    public Result<GoodsCategoryAttributeValueVO> get(@PathVariable Long id) {
        return Result.newSuccess(goodsCategoryAttributeValueService.getGoodsCategoryAttributeValue(id));
    }

}

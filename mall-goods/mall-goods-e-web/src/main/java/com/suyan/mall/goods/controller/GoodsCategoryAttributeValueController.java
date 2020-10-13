package com.suyan.mall.goods.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.suyan.mall.goods.convertor.GoodsCategoryAttributeValueConvertor;
import org.springframework.validation.BindingResult;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeValueQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeValueVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import com.suyan.mall.goods.service.IGoodsCategoryAttributeValueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

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

    @ApiOperation(value = "创建商品类目属性值", notes = "创建商品类目属性值")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO) {
        return Result.newSuccess(goodsCategoryAttributeValueService.createGoodsCategoryAttributeValue(goodsCategoryAttributeValueDTO));
    }
    
    @ApiOperation(value = "更新商品类目属性值", notes = "更新商品类目属性值")
    @PostMapping("update")
    public Result<Integer> update(@Validated({BaseInterface.class, UpdateInterface.class}) @RequestBody GoodsCategoryAttributeValueDTO goodsCategoryAttributeValueDTO) {
        return Result.newSuccess(goodsCategoryAttributeValueService.updateGoodsCategoryAttributeValue(goodsCategoryAttributeValueDTO));
    }
    
    @ApiOperation(value = "获取商品类目属性值信息", notes = "根据商品类目属性值ID获取商品类目属性值信息")
    @GetMapping("get/{id}")
    public Result<GoodsCategoryAttributeValueVO> get(@PathVariable Long id ){
        return Result.newSuccess(goodsCategoryAttributeValueService.getGoodsCategoryAttributeValue(id));
    }
    
    @ApiOperation(value = "获取商品类目属性值列表信息", notes = "分页获取商品类目属性值列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsCategoryAttributeValueVO>> queryGoodsCategoryAttributeValue(@Validated @RequestBody GoodsCategoryAttributeValueQueryDTO goodsCategoryAttributeValueQueryDTO){
        goodsCategoryAttributeValueQueryDTO.setIsDeleted(false);
        return Result.newSuccess(goodsCategoryAttributeValueService.queryGoodsCategoryAttributeValue(goodsCategoryAttributeValueQueryDTO));
    }
}

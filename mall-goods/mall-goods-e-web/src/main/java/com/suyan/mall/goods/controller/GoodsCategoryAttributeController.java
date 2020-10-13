package com.suyan.mall.goods.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.suyan.mall.goods.convertor.GoodsCategoryAttributeConvertor;
import org.springframework.validation.BindingResult;
import com.suyan.mall.goods.req.GoodsCategoryAttributeDTO;
import com.suyan.mall.goods.req.GoodsCategoryAttributeQueryDTO;
import com.suyan.mall.goods.resp.GoodsCategoryAttributeVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import com.suyan.mall.goods.service.IGoodsCategoryAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;

@Slf4j
@RequestMapping("goodsCategoryAttribute")
@RestController
@Api(tags = "商品类目属性管理接口")
public class GoodsCategoryAttributeController extends BaseController {

    @Autowired
    private IGoodsCategoryAttributeService goodsCategoryAttributeService;

    @ApiOperation(value = "删除商品类目属性", notes = "删除商品类目属性")
    @PostMapping("delete/{id}")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(goodsCategoryAttributeService.deleteGoodsCategoryAttribute(id));
    }

    @ApiOperation(value = "创建商品类目属性", notes = "创建商品类目属性")
    @PostMapping("addOrUpdate")
    public Result addOrUpdate(@Validated({BaseInterface.class}) @RequestBody GoodsCategoryAttributeDTO goodsCategoryAttributeDTO) {
        if (goodsCategoryAttributeDTO.getId() == null) {
            goodsCategoryAttributeService.createGoodsCategoryAttribute(goodsCategoryAttributeDTO);
        } else {
            goodsCategoryAttributeService.updateGoodsCategoryAttribute(goodsCategoryAttributeDTO);
        }
        return Result.newSuccess();
    }
    
    @ApiOperation(value = "获取商品类目属性信息", notes = "根据商品类目属性ID获取商品类目属性信息")
    @GetMapping("get/{id}")
    public Result<GoodsCategoryAttributeVO> get(@PathVariable Long id ){
        return Result.newSuccess(goodsCategoryAttributeService.getGoodsCategoryAttribute(id));
    }
    
    @ApiOperation(value = "获取商品类目属性列表信息", notes = "分页获取商品类目属性列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<GoodsCategoryAttributeVO>> queryGoodsCategoryAttribute(@Validated @RequestBody GoodsCategoryAttributeQueryDTO goodsCategoryAttributeQueryDTO){
        goodsCategoryAttributeQueryDTO.setIsDeleted(false);
        return Result.newSuccess(goodsCategoryAttributeService.queryGoodsCategoryAttribute(goodsCategoryAttributeQueryDTO));
    }
}

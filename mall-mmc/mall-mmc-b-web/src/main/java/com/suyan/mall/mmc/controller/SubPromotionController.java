/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.req.SubPromotionDTO;
import com.suyan.mall.mmc.req.SubPromotionQueryDTO;
import com.suyan.mall.mmc.resp.SubPromotionVO;
import com.suyan.mall.mmc.service.ISubPromotionService;
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
@RequestMapping("/b/subPromotion")
@RestController
@Api(tags = "订单促销管理接口")
public class SubPromotionController extends BaseController {

    @Autowired
    private ISubPromotionService subPromotionService;

    @ApiOperation(value = "删除订单促销", notes = "删除订单促销")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(subPromotionService.deleteSubPromotion(id));
    }

    @ApiOperation(value = "创建/编辑订单促销", notes = "创建/编辑订单促销")
    @PostMapping("addOrUpdate")
    public Result<Long> addOrUpdate(@Validated({BaseInterface.class}) @RequestBody SubPromotionDTO subPromotionDTO) {
        if (subPromotionDTO.getId() == null) {
            subPromotionService.createSubPromotion(subPromotionDTO);
        } else {
            subPromotionService.updateSubPromotion(subPromotionDTO);
        }
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取订单促销信息", notes = "根据订单促销ID获取订单促销信息")
    @GetMapping("get/{id}")
    public Result<SubPromotionVO> get(@PathVariable Long id) {
        return Result.newSuccess(subPromotionService.getSubPromotion(id));
    }

    @ApiOperation(value = "获取订单促销列表信息", notes = "分页获取订单促销列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<SubPromotionVO>> querySubPromotion(@Validated @RequestBody SubPromotionQueryDTO subPromotionQueryDTO) {
        subPromotionQueryDTO.setIsDeleted(false);
        return Result.newSuccess(subPromotionService.querySubPromotion(subPromotionQueryDTO));
    }
}

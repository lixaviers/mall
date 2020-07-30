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

    @ApiOperation(value = "创建订单促销", notes = "创建订单促销")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody SubPromotionDTO subPromotionDTO) {
        UserInfoVO user = getUser();
        subPromotionDTO.setCreateTime(null);
        subPromotionDTO.setUpdateTime(null);
        return Result.newSuccess(subPromotionService.createSubPromotion(subPromotionDTO));
    }

    @ApiOperation(value = "更新订单促销", notes = "更新订单促销")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody SubPromotionDTO subPromotionDTO) {
        UserInfoVO user = getUser();
        subPromotionDTO.setCreateTime(null);
        subPromotionDTO.setUpdateTime(null);
        return Result.newSuccess(subPromotionService.updateSubPromotion(subPromotionDTO));
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

package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.req.BargainGoodsDTO;
import com.suyan.mall.mmc.req.BargainGoodsQueryDTO;
import com.suyan.mall.mmc.resp.BargainGoodsVO;
import com.suyan.mall.mmc.service.IBargainGoodsService;
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
@RequestMapping("/b/bargainGoods")
@RestController
@Api(tags = "砍价商品管理接口")
public class BargainGoodsController extends BaseController {

    @Autowired
    private IBargainGoodsService bargainGoodsService;

    @ApiOperation(value = "删除砍价商品", notes = "删除砍价商品")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        UserInfoVO user = getUser();
        return Result.newSuccess(bargainGoodsService.deleteBargainGoods(id));
    }

    @ApiOperation(value = "创建砍价商品", notes = "创建砍价商品")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody BargainGoodsDTO bargainGoodsDTO) {
        UserInfoVO user = getUser();
        return Result.newSuccess(bargainGoodsService.createBargainGoods(bargainGoodsDTO));
    }

    @ApiOperation(value = "更新砍价商品", notes = "更新砍价商品")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody BargainGoodsDTO bargainGoodsDTO) {
        UserInfoVO user = getUser();
        return Result.newSuccess(bargainGoodsService.updateBargainGoods(bargainGoodsDTO));
    }

    @ApiOperation(value = "获取砍价商品信息", notes = "根据砍价商品ID获取砍价商品信息")
    @GetMapping("get/{id}")
    public Result<BargainGoodsVO> get(@PathVariable Long id) {
        return Result.newSuccess(bargainGoodsService.getBargainGoods(id));
    }

    @ApiOperation(value = "获取砍价商品列表信息", notes = "分页获取砍价商品列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<BargainGoodsVO>> queryBargainGoods(@Validated @RequestBody BargainGoodsQueryDTO bargainGoodsQueryDTO) {
        bargainGoodsQueryDTO.setIsDeleted(false);
        return Result.newSuccess(bargainGoodsService.queryBargainGoods(bargainGoodsQueryDTO));
    }
}

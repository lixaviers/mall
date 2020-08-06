package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.req.BargainActivityDTO;
import com.suyan.mall.mmc.req.BargainActivityQueryDTO;
import com.suyan.mall.mmc.resp.BargainActivityVO;
import com.suyan.mall.mmc.service.IBargainActivityService;
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
@RequestMapping("/b/bargainActivity")
@RestController
@Api(tags = "砍价活动管理接口")
public class BargainActivityController extends BaseController {

    @Autowired
    private IBargainActivityService bargainActivityService;

    @ApiOperation(value = "删除砍价活动", notes = "删除砍价活动")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        UserInfoVO user = getUser();
        return Result.newSuccess(bargainActivityService.deleteBargainActivity(id));
    }

    @ApiOperation(value = "创建砍价活动", notes = "创建砍价活动")
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody BargainActivityDTO bargainActivityDTO) {
        UserInfoVO user = getUser();
        bargainActivityDTO.setCreateTime(null);
        bargainActivityDTO.setUpdateTime(null);
        return Result.newSuccess(bargainActivityService.createBargainActivity(bargainActivityDTO));
    }

    @ApiOperation(value = "更新砍价活动", notes = "更新砍价活动")
    @PostMapping("update")
    public Result<Integer> update(@Validated({UpdateInterface.class}) @RequestBody BargainActivityDTO bargainActivityDTO) {
        UserInfoVO user = getUser();
        bargainActivityDTO.setCreateTime(null);
        bargainActivityDTO.setUpdateTime(null);
        return Result.newSuccess(bargainActivityService.updateBargainActivity(bargainActivityDTO));
    }

    @ApiOperation(value = "获取砍价活动信息", notes = "根据砍价活动ID获取砍价活动信息")
    @GetMapping("get/{id}")
    public Result<BargainActivityVO> get(@PathVariable Long id) {
        return Result.newSuccess(bargainActivityService.getBargainActivity(id));
    }

    @ApiOperation(value = "获取砍价活动列表信息", notes = "分页获取砍价活动列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<BargainActivityVO>> queryBargainActivity(@Validated @RequestBody BargainActivityQueryDTO bargainActivityQueryDTO) {
        bargainActivityQueryDTO.setIsDeleted(false);
        return Result.newSuccess(bargainActivityService.queryBargainActivity(bargainActivityQueryDTO));
    }
}

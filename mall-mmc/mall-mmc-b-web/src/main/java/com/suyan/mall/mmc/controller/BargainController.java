package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.req.BargainDTO;
import com.suyan.mall.mmc.req.BargainQueryDTO;
import com.suyan.mall.mmc.resp.BargainVO;
import com.suyan.mall.mmc.service.IBargainService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/b/bargain")
@RestController
@Api(tags = "砍价管理接口")
public class BargainController extends BaseController {

    @Autowired
    private IBargainService bargainService;

    @ApiOperation(value = "删除砍价", notes = "删除砍价")
    @PostMapping("delete")
    public Result<Integer> delete(@PathVariable Long id) {
        return Result.newSuccess(bargainService.deleteBargain(id));
    }

    @ApiOperation(value = "创建/编辑砍价", notes = "创建/编辑砍价")
    @PostMapping("addOrUpdate")
    public Result<Long> addOrUpdate(@Validated({BaseInterface.class}) @RequestBody BargainDTO bargainDTO) {
        bargainDTO.setShopId(getUser().getShopId());
        if (bargainDTO.getId() == null) {
            bargainService.createBargain(bargainDTO);
        } else {
            bargainService.updateBargain(bargainDTO);
        }
        return Result.newSuccess();
    }

    @ApiOperation(value = "获取砍价信息", notes = "根据砍价ID获取砍价信息")
    @GetMapping("get/{id}")
    public Result<BargainVO> get(@PathVariable Long id) {
        return Result.newSuccess(bargainService.getBargain(id));
    }

    @ApiOperation(value = "获取砍价列表信息", notes = "分页获取砍价列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<BargainVO>> queryBargain(@Validated @RequestBody BargainQueryDTO bargainQueryDTO) {
        bargainQueryDTO.setIsDeleted(false);
        return Result.newSuccess(bargainService.queryBargain(bargainQueryDTO));
    }
}

package com.suyan.mall.mmc.controller;

import com.suyan.mall.mmc.req.BargainItemQueryDTO;
import com.suyan.mall.mmc.resp.BargainItemVO;
import com.suyan.mall.mmc.service.IBargainItemService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/b/bargainItem")
@RestController
@Api(tags = "砍价阶段管理接口")
public class BargainItemController extends BaseController {

    @Autowired
    private IBargainItemService bargainItemService;

    @ApiOperation(value = "获取砍价阶段列表信息", notes = "分页获取砍价阶段列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<BargainItemVO>> queryBargainItem(@Validated @RequestBody BargainItemQueryDTO bargainItemQueryDTO) {
        return Result.newSuccess(bargainItemService.queryBargainItem(bargainItemQueryDTO));
    }
}

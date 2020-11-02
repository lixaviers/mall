/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.controller;

import com.suyan.mall.operation.req.SystemLogQueryDTO;
import com.suyan.mall.operation.resp.SystemLogVO;
import com.suyan.mall.operation.service.ISystemLogService;
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
@RequestMapping("/b/systemLog")
@RestController
@Api(value = "systemLog", tags = "系统日志管理接口")
public class SystemLogController extends BaseController {

    @Autowired
    private ISystemLogService systemLogService;

    @ApiOperation(value = "获取系统日志列表信息", notes = "分页获取系统日志列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<SystemLogVO>> querySystemLog(@Validated @RequestBody SystemLogQueryDTO systemLogQueryDTO) {
        systemLogQueryDTO.setShopId(getUser().getShopId());
        return Result.newSuccess(systemLogService.querySystemLog(systemLogQueryDTO));
    }

}

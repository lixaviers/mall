/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.controller;

import com.suyan.mall.message.req.ChannelDTO;
import com.suyan.mall.message.req.ChannelQueryDTO;
import com.suyan.mall.message.resp.ChannelVO;
import com.suyan.mall.message.service.IChannelService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/e/channel")
@RestController
@Api(tags = "短信渠道管理接口")
@Slf4j
public class ChannelController {

    @Autowired
    private IChannelService channelService;

    @ApiOperation(value = "创建短信渠道", notes = "创建短信渠道")
    @PostMapping("add")
    public Result<Integer> add(@Valid @RequestBody ChannelDTO channelDTO) {
        return Result.newSuccess(channelService.createChannel(channelDTO));
    }

    @ApiOperation(value = "更新短信渠道", notes = "更新短信渠道")
    @PostMapping("update")
    public Result<Integer> update(@Valid @RequestBody ChannelDTO channelDTO) {
        return Result.newSuccess(channelService.updateChannel(channelDTO));
    }

    @ApiOperation(value = "根据短信渠道ID获取短信渠道信息", notes = "根据短信渠道ID获取短信渠道信息")
    @GetMapping("get/{id}")
    public Result<ChannelVO> getChannel(@PathVariable Integer id) {
        return Result.newSuccess(channelService.getChannel(id));
    }

    @ApiOperation(value = "分页获取短信渠道列表信息", notes = "分页获取短信渠道列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<ChannelVO>> queryChannel(@Valid @RequestBody ChannelQueryDTO channelQueryDTO) {
        channelQueryDTO.setIsDeleted(false);
        return Result.newSuccess(channelService.queryChannel(channelQueryDTO));
    }
}

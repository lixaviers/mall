package com.suyan.mall.message.controller;

import com.suyan.mall.message.req.MessageRecordQueryDTO;
import com.suyan.mall.message.resp.MessageRecordVO;
import com.suyan.mall.message.service.IMessageRecordService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/e/messageRecord")
@RestController
@Api(value = "/e/messageRecord", tags = "SMS短信消息记录管理接口")
public class MessageRecordController {

    @Autowired
    private IMessageRecordService messageRecordService;

    @ApiOperation(value = "queryMessageRecord", notes = "分页获取SMS短信消息记录列表信息")
    @PostMapping("queryMessageRecord")
    public Result<QueryResultVO<MessageRecordVO>> queryMessageRecord(@Valid @RequestBody MessageRecordQueryDTO messageRecordQueryDTO) {
        return Result.newSuccess(messageRecordService.queryMessageRecord(messageRecordQueryDTO));
    }

}

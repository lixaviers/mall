package com.suyan.mall.operation.feigncontroller;

import com.suyan.mall.operation.feignClient.b.SystemLogFeignClient;
import com.suyan.mall.operation.req.SystemLogDTO;
import com.suyan.mall.operation.service.ISystemLogService;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
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
@RequestMapping("/feign/systemLog")
@RestController
@Api(tags = "系统日志管理接口")
public class SystemLogFeignController implements SystemLogFeignClient {

    @Autowired
    private ISystemLogService systemLogService;

    @ApiOperation(value = "创建系统日志", notes = "创建系统日志")
    @PostMapping("add")
    @Override
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody SystemLogDTO systemLogDTO) {
        return Result.newSuccess(systemLogService.createSystemLog(systemLogDTO));
    }

}

package com.suyan.mall.operation.feignClient.b;

import com.suyan.mall.operation.req.SystemLogDTO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "mall-operation-b-web", path = "/feign/systemLog")
public interface SystemLogFeignClient {

    /**
     * 创建系统日志
     *
     * @param systemLogDTO
     * @return
     */
    @PostMapping(value = "/add")
    Result<Long> add(@RequestBody SystemLogDTO systemLogDTO);


}

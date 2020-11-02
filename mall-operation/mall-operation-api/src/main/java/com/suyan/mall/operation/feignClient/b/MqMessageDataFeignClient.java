/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.feignClient.b;

import com.suyan.mall.operation.req.MqMessageDataDTO;
import com.suyan.result.Result;
import com.suyan.service.BaseInterface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "mall-operation-b-web", path = "/feign/mqMessageData")
public interface MqMessageDataFeignClient {

    /**
     * 创建消息数据
     *
     * @param mqMessageDataDTO
     * @return
     */
    @PostMapping("add")
    public Result<Long> add(@Validated({BaseInterface.class}) @RequestBody MqMessageDataDTO mqMessageDataDTO);


}

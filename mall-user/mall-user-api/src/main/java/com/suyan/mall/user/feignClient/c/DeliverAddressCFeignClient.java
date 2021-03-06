/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.feignClient.c;

import com.suyan.mall.user.resp.DeliverAddressVO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-user-c-web", path = "/feign/c/deliverAddress")
public interface DeliverAddressCFeignClient {

    /**
     * 获取收货地址信息
     *
     * @return
     */
    @GetMapping("/get/{id}")
    Result<DeliverAddressVO> get(@PathVariable(value = "id") Long id);

}

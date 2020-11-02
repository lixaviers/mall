/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.feignClient.c;

import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "mall-goods-c-web", path = "/feign/c/goods")
public interface GoodsCFeignClient {

    /**
     * 根据id查询信息
     *
     * @return
     */
    @PostMapping("/get/{id}")
    Result<GoodsVO> get(@PathVariable(name = "id") Long id);

    /**
     * 根据id列表查询信息
     *
     * @return
     */
    @PostMapping("/get")
    Result<List<GoodsVO>> get(@RequestBody List<Long> idList);

}

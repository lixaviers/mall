/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.client;

import com.suyan.exception.CommonException;
import com.suyan.mall.goods.feignClient.c.GoodsCFeignClient;
import com.suyan.mall.goods.resp.GoodsVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 商品feign调用
 */
@Slf4j
@Component
public class GoodsClient {

    @Autowired
    private GoodsCFeignClient goodsCFeignClient;

    /**
     * 获取商品信息
     *
     * @param goodsId
     * @return
     */
    public Result<GoodsVO> getGoodsInfo(Long goodsId) {
        log.info("根据商品id查询商品信息入参={}", JsonUtil.toJsonString(goodsId));
        Result<GoodsVO> result = goodsCFeignClient.get(goodsId);
        log.info("根据商品id查询商品信息出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
        }
        if (result.getData() == null) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
        }
        return result;
    }

    /**
     * 获取商品信息
     *
     * @param goodsIdList
     * @return
     */
    public List<GoodsVO> getGoodsInfo(List<Long> goodsIdList) {
        log.info("根据商品id列表查询商品信息入参={}", JsonUtil.toJsonString(goodsIdList));
        Result<List<GoodsVO>> result = goodsCFeignClient.get(goodsIdList);
        log.info("根据商品id列表查询商品信息出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
        }
        return result.getData();
    }

}

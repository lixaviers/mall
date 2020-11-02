/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.controller;

import com.suyan.exception.CommonException;
import com.suyan.mall.goods.feignClient.c.GoodsSkuCFeignClient;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.mmc.enums.CommonStatusMmcEnum;
import com.suyan.mall.mmc.req.BargainQueryDTO;
import com.suyan.mall.mmc.resp.BargainVO;
import com.suyan.mall.mmc.service.IBargainService;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/c/bargain")
@RestController
@Api(tags = "砍价管理接口")
public class BargainController extends BaseController {

    @Autowired
    private GoodsSkuCFeignClient goodsSkuCFeignClient;

    @Autowired
    private IBargainService bargainService;

    @ApiOperation(value = "获取砍价列表信息", notes = "分页获取砍价列表信息")
    @PostMapping("query")
    public Result<QueryResultVO<BargainVO>> queryBargain(@Validated @RequestBody BargainQueryDTO bargainQueryDTO) {
        bargainQueryDTO.setActivityStatus(CommonStatusMmcEnum.ONGOING.getValue());
        bargainQueryDTO.setIsDeleted(false);
        QueryResultVO<BargainVO> queryResultVO = bargainService.queryBargain(bargainQueryDTO);
        if (queryResultVO.getTotalRecords() > 0) {
            // 封装商品信息
            List<String> goodsSkuCodeList = queryResultVO.getRecords().stream().map(BargainVO::getGoodsSkuCode).collect(Collectors.toList());
            log.info("根据商品编码列表查询商品信息入参={}", JsonUtil.toJsonString(goodsSkuCodeList));
            Result<List<GoodsSkuVO>> result = goodsSkuCFeignClient.get(goodsSkuCodeList);
            log.info("根据商品编码列表查询商品信息出参={}", JsonUtil.toJsonString(result));
            if (!result.isSuccess()) {
                throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
            }
            if (CollectionsUtil.isNotEmpty(result.getData())) {
                Map<String, GoodsSkuVO> map = result.getData().stream().collect(Collectors.toMap(GoodsSkuVO::getSkuCode, item -> item));
                for (BargainVO bargainVO : queryResultVO.getRecords()) {
                    GoodsSkuVO goodsSkuVO = map.get(bargainVO.getGoodsSkuCode());
                    if (goodsSkuVO != null) {
                        bargainVO.setGoodsId(goodsSkuVO.getGoodsId());
                        bargainVO.setGoodsName(goodsSkuVO.getGoodsName());
                        bargainVO.setGoodsPicture(goodsSkuVO.getGoodsPicture());
                        bargainVO.setGoodsSpecValue(goodsSkuVO.getSpecValue());
                    }
                }
            }
        }
        return Result.newSuccess(queryResultVO);
    }

}

package com.suyan.mall.user.feigncontroller;

import com.suyan.mall.user.feignClient.c.GoodsCollectCFeignClient;
import com.suyan.mall.user.req.c.BatchGoodsCollectDTO;
import com.suyan.mall.user.service.IGoodsCollectService;
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

import java.util.List;

@Slf4j
@RequestMapping("/feign/c/goodsCollect")
@RestController
@Api(tags = "商品收藏feign管理接口")
public class GoodsCollectFeignController implements GoodsCollectCFeignClient {

    @Autowired
    private IGoodsCollectService goodsCollectService;

    @ApiOperation(value = "批量创建商品收藏", notes = "批量创建商品收藏")
    @PostMapping("batchAdd")
    public Result batchAdd(@Validated @RequestBody BatchGoodsCollectDTO batchGoodsCollectDTO) {
        goodsCollectService.batchCreateGoodsCollect(batchGoodsCollectDTO);
        return Result.newSuccess();
    }

}

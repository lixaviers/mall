package com.suyan.mall.user.feignClient.c;

import com.suyan.mall.user.req.c.BatchGoodsCollectDTO;
import com.suyan.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "mall-user-c-web", path = "/feign/c/goodsCollect")
public interface GoodsCollectCFeignClient {

    /**
     * 批量收藏商品
     *
     * @return
     */
    @PostMapping("batchAdd")
    Result batchAdd(@RequestBody BatchGoodsCollectDTO batchGoodsCollectDTO);

}

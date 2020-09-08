package com.suyan.mall.user.client;

import com.suyan.exception.CommonException;
import com.suyan.mall.goods.feignClient.c.GoodsSkuCFeignClient;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GoodsSkuClient {

    @Autowired
    private GoodsSkuCFeignClient goodsSkuCFeignClient;

    /**
     * 获取商品信息
     *
     * @param goodsSkuCodeList
     * @return
     */
    public Result<List<GoodsSkuVO>> getGoodsInfo(List<String> goodsSkuCodeList) {
        log.info("根据商品编码列表查询商品信息入参={}", JsonUtil.toJsonString(goodsSkuCodeList));
        Result<List<GoodsSkuVO>> result = goodsSkuCFeignClient.get(goodsSkuCodeList);
        log.info("根据商品编码列表查询商品信息出参={}", JsonUtil.toJsonString(result));
        if (!result.isSuccess()) {
            throw new CommonException(ResultCode.API_INVLID_DATA, "商品");
        }
        return result;
    }

}

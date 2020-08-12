package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsSkuInventoryLogBiz;
import com.suyan.mall.goods.convertor.GoodsSkuInventoryLogConvertor;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogQueryDTO;
import com.suyan.mall.goods.resp.GoodsSkuInventoryLogVO;
import com.suyan.mall.goods.service.IGoodsSkuInventoryLogService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品sku库存日志管理类>
 */
@Slf4j
@Service("goodsSkuInventoryLogService")
public class GoodsSkuInventoryLogServiceImpl implements IGoodsSkuInventoryLogService {

    @Autowired
    private GoodsSkuInventoryLogBiz goodsSkuInventoryLogBiz;

    @Override
    public QueryResultVO<GoodsSkuInventoryLogVO> queryGoodsSkuInventoryLog(GoodsSkuInventoryLogQueryDTO goodsSkuInventoryLogQueryDTO) {
        return GoodsSkuInventoryLogConvertor.toQueryResult(goodsSkuInventoryLogBiz.queryGoodsSkuInventoryLog(goodsSkuInventoryLogQueryDTO));
    }

}
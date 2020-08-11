package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsSkuBiz;
import com.suyan.mall.goods.convertor.GoodsSkuConvertor;
import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.goods.service.IGoodsSkuService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 商品规格管理类>
 */
@Slf4j
@Service("goodsSkuService")
public class GoodsSkuServiceImpl implements IGoodsSkuService {

    @Autowired
    private GoodsSkuBiz goodsSkuBiz;

    @Override
    public QueryResultVO<GoodsSkuVO> queryGoodsSku(GoodsSkuQueryDTO goodsSkuQueryDTO) {
        return GoodsSkuConvertor.toQueryResult(goodsSkuBiz.queryGoodsSku(goodsSkuQueryDTO));
    }

    @Override
    public GoodsSkuVO getGoodsSku(String skuCode) {
        return GoodsSkuConvertor.toGoodsSkuVO(goodsSkuBiz.getGoodsSku(skuCode));
    }

}
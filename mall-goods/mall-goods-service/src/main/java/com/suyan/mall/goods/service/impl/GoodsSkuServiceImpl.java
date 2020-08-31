package com.suyan.mall.goods.service.impl;

import com.suyan.mall.goods.biz.GoodsSkuBiz;
import com.suyan.mall.goods.convertor.GoodsSkuConvertor;
import com.suyan.mall.goods.convertor.GoodsSkuInventoryLogConvertor;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogDTO;
import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import com.suyan.mall.goods.req.c.GoodsSkuDeductionInventoryDTO;
import com.suyan.mall.goods.resp.GoodsSkuVO;
import com.suyan.mall.goods.service.IGoodsSkuService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public List<GoodsSkuVO> getGoodsSku(List<String> skuCodeList) {
        return GoodsSkuConvertor.toGoodsSkuVOList(goodsSkuBiz.getGoodsSku(skuCodeList));
    }

    @Override
    public void updateInventory(GoodsSkuInventoryLogDTO logDTO) {
        goodsSkuBiz.updateInventory(GoodsSkuInventoryLogConvertor.toGoodsSkuInventoryLog(logDTO));
    }

    @Override
    public void deductionInventory(GoodsSkuDeductionInventoryDTO dto) {
        goodsSkuBiz.deductionInventory(dto);
    }
}
package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsSkuMapper;
import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.req.GoodsSkuQueryDTO;

import java.util.List;

public interface GoodsSkuBizMapper extends GoodsSkuMapper {
    
    String getMaxSkuCode();

}
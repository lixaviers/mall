package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsSkuMapper;

public interface GoodsSkuBizMapper extends GoodsSkuMapper {
    
    String getMaxSkuCode();

}
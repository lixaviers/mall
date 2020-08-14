package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsMapper;
import com.suyan.mall.goods.model.Goods;
import com.suyan.mall.goods.model.GoodsExample;
import com.suyan.mall.goods.req.GoodsQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsBizMapper extends GoodsMapper {
    
    List<Goods> queryGoods(GoodsQueryDTO goodsQuery);

}
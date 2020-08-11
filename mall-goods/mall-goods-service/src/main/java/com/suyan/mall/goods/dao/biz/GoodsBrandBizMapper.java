package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsBrandMapper;
import com.suyan.mall.goods.model.GoodsBrand;
import com.suyan.mall.goods.model.GoodsBrandExample;
import com.suyan.mall.goods.req.GoodsBrandQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsBrandBizMapper extends GoodsBrandMapper {
    
    List<GoodsBrand> getGoodsBrandListByCategoryId(Integer categoryId);

}
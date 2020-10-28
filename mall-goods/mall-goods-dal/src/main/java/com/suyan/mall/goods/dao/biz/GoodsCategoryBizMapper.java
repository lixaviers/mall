package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsCategoryMapper;
import com.suyan.mall.goods.model.GoodsCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryBizMapper extends GoodsCategoryMapper {

    List<GoodsCategory> getForegroundCategorysByBackgroundCategoryId(@Param("backgroundCategoryId") Integer backgroundCategoryId);

    /**
     * 获取最近发布的商品类目
     *
     * @param shopId
     * @return
     */
    GoodsCategory getRecentlyReleasedGoodsCategory(@Param("shopId") Long shopId);

}
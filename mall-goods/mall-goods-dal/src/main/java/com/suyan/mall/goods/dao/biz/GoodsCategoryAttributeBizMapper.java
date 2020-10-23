package com.suyan.mall.goods.dao.biz;

import com.suyan.mall.goods.dao.GoodsCategoryAttributeMapper;
import com.suyan.mall.goods.model.GoodsCategoryAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryAttributeBizMapper extends GoodsCategoryAttributeMapper {

    int getMaxSortNumberByCategoryId(@Param("categoryId") Integer categoryId);

    List<GoodsCategoryAttribute> getTreeByCategoryId(@Param("categoryId") Integer categoryId);

}
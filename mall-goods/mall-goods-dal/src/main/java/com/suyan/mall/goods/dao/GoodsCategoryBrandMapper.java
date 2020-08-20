package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsCategoryBrand;
import com.suyan.mall.goods.model.GoodsCategoryBrandExample;
import com.suyan.mall.goods.req.GoodsCategoryBrandQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryBrandMapper {
    
    long countByExample(GoodsCategoryBrandExample example);

    int deleteByExample(GoodsCategoryBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategoryBrand record);

    int insertSelective(GoodsCategoryBrand record);

    List<GoodsCategoryBrand> selectByExample(GoodsCategoryBrandExample example);

    GoodsCategoryBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCategoryBrand record, @Param("example") GoodsCategoryBrandExample example);

    int updateByExample(@Param("record") GoodsCategoryBrand record, @Param("example") GoodsCategoryBrandExample example);

    int updateByPrimaryKeySelective(GoodsCategoryBrand record);

    int updateByPrimaryKey(GoodsCategoryBrand record);


    GoodsCategoryBrand selectByPrimaryKeyForUpdate(Long id);

    List<GoodsCategoryBrand> queryGoodsCategoryBrand(GoodsCategoryBrandQueryDTO goodsCategoryBrandQuery);

    int insertBatch(@Param("modelList") List<GoodsCategoryBrand> modelList);

    
    List<GoodsCategoryBrand> selectByGoodsBrandId(@Param("goodsBrandId") Integer goodsBrandId);
    
    List<GoodsCategoryBrand> selectByGoodsCategoryId(@Param("goodsCategoryId") Integer goodsCategoryId);


}
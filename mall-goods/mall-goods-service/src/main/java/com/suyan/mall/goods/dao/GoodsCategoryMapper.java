package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsCategory;
import com.suyan.mall.goods.model.GoodsCategoryExample;
import com.suyan.mall.goods.req.GoodsCategoryQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper {

    long countByExample(GoodsCategoryExample example);

    int deleteByExample(GoodsCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    List<GoodsCategory> selectByExample(GoodsCategoryExample example);

    GoodsCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    int updateByExample(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);


    GoodsCategory selectByPrimaryKeyForUpdate(Integer id);

    List<GoodsCategory> queryGoodsCategory(GoodsCategoryQueryDTO goodsCategoryQuery);

    int insertBatch(@Param("modelList") List<GoodsCategory> modelList);


    List<GoodsCategory> selectByParentId(@Param("parentId") Integer parentId);


}
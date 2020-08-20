package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsCategoryRelation;
import com.suyan.mall.goods.model.GoodsCategoryRelationExample;
import com.suyan.mall.goods.req.GoodsCategoryRelationQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryRelationMapper {
    
    long countByExample(GoodsCategoryRelationExample example);

    int deleteByExample(GoodsCategoryRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategoryRelation record);

    int insertSelective(GoodsCategoryRelation record);

    List<GoodsCategoryRelation> selectByExample(GoodsCategoryRelationExample example);

    GoodsCategoryRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCategoryRelation record, @Param("example") GoodsCategoryRelationExample example);

    int updateByExample(@Param("record") GoodsCategoryRelation record, @Param("example") GoodsCategoryRelationExample example);

    int updateByPrimaryKeySelective(GoodsCategoryRelation record);

    int updateByPrimaryKey(GoodsCategoryRelation record);


    GoodsCategoryRelation selectByPrimaryKeyForUpdate(Long id);

    List<GoodsCategoryRelation> queryGoodsCategoryRelation(GoodsCategoryRelationQueryDTO goodsCategoryRelationQuery);

    int insertBatch(@Param("modelList") List<GoodsCategoryRelation> modelList);



}
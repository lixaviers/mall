package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsSpecificationName;
import com.suyan.mall.goods.model.GoodsSpecificationNameExample;
import com.suyan.mall.goods.req.GoodsSpecificationNameQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSpecificationNameMapper {
    
    long countByExample(GoodsSpecificationNameExample example);

    int deleteByExample(GoodsSpecificationNameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSpecificationName record);

    int insertSelective(GoodsSpecificationName record);

    List<GoodsSpecificationName> selectByExample(GoodsSpecificationNameExample example);

    GoodsSpecificationName selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSpecificationName record, @Param("example") GoodsSpecificationNameExample example);

    int updateByExample(@Param("record") GoodsSpecificationName record, @Param("example") GoodsSpecificationNameExample example);

    int updateByPrimaryKeySelective(GoodsSpecificationName record);

    int updateByPrimaryKey(GoodsSpecificationName record);


    GoodsSpecificationName selectByPrimaryKeyForUpdate(Long id);

    List<GoodsSpecificationName> queryGoodsSpecificationName(GoodsSpecificationNameQueryDTO goodsSpecificationNameQuery);

    int insertBatch(@Param("modelList") List<GoodsSpecificationName> modelList);



}
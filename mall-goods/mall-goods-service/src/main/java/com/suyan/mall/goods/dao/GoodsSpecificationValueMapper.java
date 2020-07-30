package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsSpecificationValue;
import com.suyan.mall.goods.model.GoodsSpecificationValueExample;
import com.suyan.mall.goods.req.GoodsSpecificationValueQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSpecificationValueMapper {
    
    long countByExample(GoodsSpecificationValueExample example);

    int deleteByExample(GoodsSpecificationValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSpecificationValue record);

    int insertSelective(GoodsSpecificationValue record);

    List<GoodsSpecificationValue> selectByExample(GoodsSpecificationValueExample example);

    GoodsSpecificationValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSpecificationValue record, @Param("example") GoodsSpecificationValueExample example);

    int updateByExample(@Param("record") GoodsSpecificationValue record, @Param("example") GoodsSpecificationValueExample example);

    int updateByPrimaryKeySelective(GoodsSpecificationValue record);

    int updateByPrimaryKey(GoodsSpecificationValue record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsSpecificationValue selectByPrimaryKeyForUpdate(Long id);

    List<GoodsSpecificationValue> queryGoodsSpecificationValue(GoodsSpecificationValueQueryDTO goodsSpecificationValueQuery);

    int insertBatch(@Param("modelList") List<GoodsSpecificationValue> modelList);



}
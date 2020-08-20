package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsSku;
import com.suyan.mall.goods.model.GoodsSkuExample;
import com.suyan.mall.goods.req.GoodsSkuQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSkuMapper {
    
    long countByExample(GoodsSkuExample example);

    int deleteByExample(GoodsSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSku record);

    int insertSelective(GoodsSku record);

    List<GoodsSku> selectByExample(GoodsSkuExample example);

    GoodsSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSku record, @Param("example") GoodsSkuExample example);

    int updateByExample(@Param("record") GoodsSku record, @Param("example") GoodsSkuExample example);

    int updateByPrimaryKeySelective(GoodsSku record);

    int updateByPrimaryKey(GoodsSku record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsSku selectByPrimaryKeyForUpdate(Long id);

    List<GoodsSku> queryGoodsSku(GoodsSkuQueryDTO goodsSkuQuery);

    int insertBatch(@Param("modelList") List<GoodsSku> modelList);


    GoodsSku selectBySkuCode(@Param("skuCode") String skuCode);    


}
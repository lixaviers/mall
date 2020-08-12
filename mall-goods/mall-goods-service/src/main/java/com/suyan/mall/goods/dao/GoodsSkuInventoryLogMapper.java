package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsSkuInventoryLog;
import com.suyan.mall.goods.model.GoodsSkuInventoryLogExample;
import com.suyan.mall.goods.req.GoodsSkuInventoryLogQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsSkuInventoryLogMapper {
    
    long countByExample(GoodsSkuInventoryLogExample example);

    int deleteByExample(GoodsSkuInventoryLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsSkuInventoryLog record);

    int insertSelective(GoodsSkuInventoryLog record);

    List<GoodsSkuInventoryLog> selectByExample(GoodsSkuInventoryLogExample example);

    GoodsSkuInventoryLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsSkuInventoryLog record, @Param("example") GoodsSkuInventoryLogExample example);

    int updateByExample(@Param("record") GoodsSkuInventoryLog record, @Param("example") GoodsSkuInventoryLogExample example);

    int updateByPrimaryKeySelective(GoodsSkuInventoryLog record);

    int updateByPrimaryKey(GoodsSkuInventoryLog record);


    GoodsSkuInventoryLog selectByPrimaryKeyForUpdate(Long id);

    List<GoodsSkuInventoryLog> queryGoodsSkuInventoryLog(GoodsSkuInventoryLogQueryDTO goodsSkuInventoryLogQuery);

    int insertBatch(@Param("modelList") List<GoodsSkuInventoryLog> modelList);



}
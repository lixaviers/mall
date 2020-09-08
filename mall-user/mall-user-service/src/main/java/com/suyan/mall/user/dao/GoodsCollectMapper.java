package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.GoodsCollect;
import com.suyan.mall.user.model.GoodsCollectExample;
import com.suyan.mall.user.req.GoodsCollectQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsCollectMapper {
    
    long countByExample(GoodsCollectExample example);

    int deleteByExample(GoodsCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCollect record);

    int insertSelective(GoodsCollect record);

    List<GoodsCollect> selectByExample(GoodsCollectExample example);

    GoodsCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCollect record, @Param("example") GoodsCollectExample example);

    int updateByExample(@Param("record") GoodsCollect record, @Param("example") GoodsCollectExample example);

    int updateByPrimaryKeySelective(GoodsCollect record);

    int updateByPrimaryKey(GoodsCollect record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    GoodsCollect selectByPrimaryKeyForUpdate(Long id);

    List<GoodsCollect> queryGoodsCollect(GoodsCollectQueryDTO goodsCollectQuery);

    int insertBatch(@Param("modelList") List<GoodsCollect> modelList);

    
    List<GoodsCollect> selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);


}
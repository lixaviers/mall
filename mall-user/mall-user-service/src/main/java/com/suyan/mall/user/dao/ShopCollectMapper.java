package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.ShopCollect;
import com.suyan.mall.user.model.ShopCollectExample;
import com.suyan.mall.user.req.ShopCollectQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ShopCollectMapper {
    
    long countByExample(ShopCollectExample example);

    int deleteByExample(ShopCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopCollect record);

    int insertSelective(ShopCollect record);

    List<ShopCollect> selectByExample(ShopCollectExample example);

    ShopCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopCollect record, @Param("example") ShopCollectExample example);

    int updateByExample(@Param("record") ShopCollect record, @Param("example") ShopCollectExample example);

    int updateByPrimaryKeySelective(ShopCollect record);

    int updateByPrimaryKey(ShopCollect record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    ShopCollect selectByPrimaryKeyForUpdate(Long id);

    List<ShopCollect> queryShopCollect(ShopCollectQueryDTO shopCollectQuery);

    int insertBatch(@Param("modelList") List<ShopCollect> modelList);

    
    List<ShopCollect> selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);


}
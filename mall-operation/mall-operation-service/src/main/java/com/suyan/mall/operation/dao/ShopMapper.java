package com.suyan.mall.operation.dao;

import com.suyan.mall.operation.model.Shop;
import com.suyan.mall.operation.model.ShopExample;
import com.suyan.mall.operation.req.ShopQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
    
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExample(ShopExample example);

    Shop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Shop selectByPrimaryKeyForUpdate(Long id);

    List<Shop> queryShop(ShopQueryDTO shopQuery);

    int insertBatch(@Param("modelList") List<Shop> modelList);

    
    List<Shop> selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);


}
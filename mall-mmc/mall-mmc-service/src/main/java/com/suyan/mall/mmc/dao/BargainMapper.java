package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.Bargain;
import com.suyan.mall.mmc.model.BargainExample;
import com.suyan.mall.mmc.req.BargainQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BargainMapper {
    
    long countByExample(BargainExample example);

    int deleteByExample(BargainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bargain record);

    int insertSelective(Bargain record);

    List<Bargain> selectByExample(BargainExample example);

    Bargain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bargain record, @Param("example") BargainExample example);

    int updateByExample(@Param("record") Bargain record, @Param("example") BargainExample example);

    int updateByPrimaryKeySelective(Bargain record);

    int updateByPrimaryKey(Bargain record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Bargain selectByPrimaryKeyForUpdate(Long id);

    List<Bargain> queryBargain(BargainQueryDTO bargainQuery);

    int insertBatch(@Param("modelList") List<Bargain> modelList);

    
    List<Bargain> selectByShopId(@Param("shopId") Long shopId);


}
package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.BargainActivity;
import com.suyan.mall.mmc.model.BargainActivityExample;
import com.suyan.mall.mmc.req.BargainActivityQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BargainActivityMapper {
    
    long countByExample(BargainActivityExample example);

    int deleteByExample(BargainActivityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BargainActivity record);

    int insertSelective(BargainActivity record);

    List<BargainActivity> selectByExample(BargainActivityExample example);

    BargainActivity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BargainActivity record, @Param("example") BargainActivityExample example);

    int updateByExample(@Param("record") BargainActivity record, @Param("example") BargainActivityExample example);

    int updateByPrimaryKeySelective(BargainActivity record);

    int updateByPrimaryKey(BargainActivity record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    BargainActivity selectByPrimaryKeyForUpdate(Long id);

    List<BargainActivity> queryBargainActivity(BargainActivityQueryDTO bargainActivityQuery);

    int insertBatch(@Param("modelList") List<BargainActivity> modelList);



}
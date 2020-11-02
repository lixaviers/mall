/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.BargainItem;
import com.suyan.mall.mmc.model.BargainItemExample;
import com.suyan.mall.mmc.req.BargainItemQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BargainItemMapper {
    
    long countByExample(BargainItemExample example);

    int deleteByExample(BargainItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BargainItem record);

    int insertSelective(BargainItem record);

    List<BargainItem> selectByExample(BargainItemExample example);

    BargainItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BargainItem record, @Param("example") BargainItemExample example);

    int updateByExample(@Param("record") BargainItem record, @Param("example") BargainItemExample example);

    int updateByPrimaryKeySelective(BargainItem record);

    int updateByPrimaryKey(BargainItem record);


    BargainItem selectByPrimaryKeyForUpdate(Long id);

    List<BargainItem> queryBargainItem(BargainItemQueryDTO bargainItemQuery);

    int insertBatch(@Param("modelList") List<BargainItem> modelList);

    
    List<BargainItem> selectByBargainId(@Param("bargainId") Long bargainId);


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.SubPromotion;
import com.suyan.mall.mmc.model.SubPromotionExample;
import com.suyan.mall.mmc.req.SubPromotionQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SubPromotionMapper {
    
    long countByExample(SubPromotionExample example);

    int deleteByExample(SubPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubPromotion record);

    int insertSelective(SubPromotion record);

    List<SubPromotion> selectByExample(SubPromotionExample example);

    SubPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubPromotion record, @Param("example") SubPromotionExample example);

    int updateByExample(@Param("record") SubPromotion record, @Param("example") SubPromotionExample example);

    int updateByPrimaryKeySelective(SubPromotion record);

    int updateByPrimaryKey(SubPromotion record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    SubPromotion selectByPrimaryKeyForUpdate(Long id);

    List<SubPromotion> querySubPromotion(SubPromotionQueryDTO subPromotionQuery);

    int insertBatch(@Param("modelList") List<SubPromotion> modelList);



}
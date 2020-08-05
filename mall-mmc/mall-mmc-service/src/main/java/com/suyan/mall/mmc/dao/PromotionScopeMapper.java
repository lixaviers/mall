package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.PromotionScope;
import com.suyan.mall.mmc.model.PromotionScopeExample;
import com.suyan.mall.mmc.req.PromotionScopeQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PromotionScopeMapper {
    
    long countByExample(PromotionScopeExample example);

    int deleteByExample(PromotionScopeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionScope record);

    int insertSelective(PromotionScope record);

    List<PromotionScope> selectByExample(PromotionScopeExample example);

    PromotionScope selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromotionScope record, @Param("example") PromotionScopeExample example);

    int updateByExample(@Param("record") PromotionScope record, @Param("example") PromotionScopeExample example);

    int updateByPrimaryKeySelective(PromotionScope record);

    int updateByPrimaryKey(PromotionScope record);


    PromotionScope selectByPrimaryKeyForUpdate(Long id);

    List<PromotionScope> queryPromotionScope(PromotionScopeQueryDTO promotionScopeQuery);

    int insertBatch(@Param("modelList") List<PromotionScope> modelList);



}
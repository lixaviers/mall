package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.BargainGoodsItem;
import com.suyan.mall.mmc.model.BargainGoodsItemExample;
import com.suyan.mall.mmc.req.BargainGoodsItemQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BargainGoodsItemMapper {
    
    long countByExample(BargainGoodsItemExample example);

    int deleteByExample(BargainGoodsItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BargainGoodsItem record);

    int insertSelective(BargainGoodsItem record);

    List<BargainGoodsItem> selectByExample(BargainGoodsItemExample example);

    BargainGoodsItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BargainGoodsItem record, @Param("example") BargainGoodsItemExample example);

    int updateByExample(@Param("record") BargainGoodsItem record, @Param("example") BargainGoodsItemExample example);

    int updateByPrimaryKeySelective(BargainGoodsItem record);

    int updateByPrimaryKey(BargainGoodsItem record);


    BargainGoodsItem selectByPrimaryKeyForUpdate(Long id);

    List<BargainGoodsItem> queryBargainGoodsItem(BargainGoodsItemQueryDTO bargainGoodsItemQuery);

    int insertBatch(@Param("modelList") List<BargainGoodsItem> modelList);

    
    List<BargainGoodsItem> selectByBargainGoodsId(@Param("bargainGoodsId") Long bargainGoodsId);


}
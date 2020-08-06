package com.suyan.mall.mmc.dao;

import com.suyan.mall.mmc.model.BargainGoods;
import com.suyan.mall.mmc.model.BargainGoodsExample;
import com.suyan.mall.mmc.req.BargainGoodsQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BargainGoodsMapper {
    
    long countByExample(BargainGoodsExample example);

    int deleteByExample(BargainGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BargainGoods record);

    int insertSelective(BargainGoods record);

    List<BargainGoods> selectByExample(BargainGoodsExample example);

    BargainGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BargainGoods record, @Param("example") BargainGoodsExample example);

    int updateByExample(@Param("record") BargainGoods record, @Param("example") BargainGoodsExample example);

    int updateByPrimaryKeySelective(BargainGoods record);

    int updateByPrimaryKey(BargainGoods record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    BargainGoods selectByPrimaryKeyForUpdate(Long id);

    List<BargainGoods> queryBargainGoods(BargainGoodsQueryDTO bargainGoodsQuery);

    int insertBatch(@Param("modelList") List<BargainGoods> modelList);

    
    List<BargainGoods> selectByBargainActivityId(@Param("bargainActivityId") Long bargainActivityId);


}
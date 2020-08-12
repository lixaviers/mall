package com.suyan.mall.goods.dao;

import com.suyan.mall.goods.model.GoodsPicture;
import com.suyan.mall.goods.model.GoodsPictureExample;
import com.suyan.mall.goods.req.GoodsPictureQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsPictureMapper {
    
    long countByExample(GoodsPictureExample example);

    int deleteByExample(GoodsPictureExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsPicture record);

    int insertSelective(GoodsPicture record);

    List<GoodsPicture> selectByExample(GoodsPictureExample example);

    GoodsPicture selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") GoodsPicture record, @Param("example") GoodsPictureExample example);

    int updateByExample(@Param("record") GoodsPicture record, @Param("example") GoodsPictureExample example);

    int updateByPrimaryKeySelective(GoodsPicture record);

    int updateByPrimaryKey(GoodsPicture record);


    GoodsPicture selectByPrimaryKeyForUpdate(Long goodsId);

    List<GoodsPicture> queryGoodsPicture(GoodsPictureQueryDTO goodsPictureQuery);

    int insertBatch(@Param("modelList") List<GoodsPicture> modelList);



}
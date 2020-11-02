/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.dao;

import com.suyan.mall.operation.model.MqMessageData;
import com.suyan.mall.operation.model.MqMessageDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MqMessageDataMapper {

    long countByExample(MqMessageDataExample example);

    int deleteByExample(MqMessageDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MqMessageData record);

    int insertSelective(MqMessageData record);

    List<MqMessageData> selectByExample(MqMessageDataExample example);

    MqMessageData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MqMessageData record, @Param("example") MqMessageDataExample example);

    int updateByExample(@Param("record") MqMessageData record, @Param("example") MqMessageDataExample example);

    int updateByPrimaryKeySelective(MqMessageData record);

    int updateByPrimaryKey(MqMessageData record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    MqMessageData selectByPrimaryKeyForUpdate(Long id);

    int insertBatch(@Param("modelList") List<MqMessageData> modelList);


}
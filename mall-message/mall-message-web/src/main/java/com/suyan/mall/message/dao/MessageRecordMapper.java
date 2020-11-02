/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.dao;

import com.suyan.mall.message.model.MessageRecord;
import com.suyan.mall.message.model.MessageRecordExample;
import com.suyan.mall.message.req.MessageRecordQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageRecordMapper {
    
    long countByExample(MessageRecordExample example);

    int deleteByExample(MessageRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageRecord record);

    int insertSelective(MessageRecord record);

    List<MessageRecord> selectByExample(MessageRecordExample example);

    MessageRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    int updateByExample(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    int updateByPrimaryKeySelective(MessageRecord record);

    int updateByPrimaryKey(MessageRecord record);


    MessageRecord selectByPrimaryKeyForUpdate(Long id);

    List<MessageRecord> queryMessageRecord(MessageRecordQueryDTO messageRecordQuery);

    int insertBatch(@Param("modelList") List<MessageRecord> modelList);

    
    List<MessageRecord> selectById(@Param("id") Long id);


}
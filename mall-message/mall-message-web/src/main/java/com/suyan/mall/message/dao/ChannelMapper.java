/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.dao;

import com.suyan.mall.message.model.Channel;
import com.suyan.mall.message.model.ChannelExample;
import com.suyan.mall.message.req.ChannelQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelMapper {
    
    long countByExample(ChannelExample example);

    int deleteByExample(ChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelExample example);

    Channel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Integer id
    );

    Channel selectByPrimaryKeyForUpdate(Integer id);

    List<Channel> queryChannel(ChannelQueryDTO channelQuery);

    int insertBatch(@Param("modelList") List<Channel> modelList);


    Channel selectByChannelCode(@Param("channelCode") String channelCode);    


}
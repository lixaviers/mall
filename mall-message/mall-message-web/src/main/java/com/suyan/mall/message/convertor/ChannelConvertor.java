/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.convertor;

import com.suyan.mall.message.model.Channel;
import com.suyan.mall.message.req.ChannelDTO;
import com.suyan.mall.message.resp.ChannelVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public abstract class ChannelConvertor {

    private static final BeanCopier beanCopierForChannelVO = BeanCopier.create(Channel.class, ChannelVO.class, false);
    private static final BeanCopier beanCopierForChannel = BeanCopier.create(ChannelDTO.class, Channel.class, false);

    public static ChannelVO toChannelVO(Channel channel) {
        if (channel == null) {
            return null;
        }
        ChannelVO channelVO = new ChannelVO();
        beanCopierForChannelVO.copy(channel, channelVO, null);
        return channelVO;
    }

    public static Channel toChannel(ChannelDTO channelDTO) {
        Channel channel = new Channel();
        beanCopierForChannel.copy(channelDTO, channel, null);
        return channel;
    }

    public static List<ChannelVO> toChannelVOList(List<Channel> channelList) {
        if (channelList == null || channelList.isEmpty()) {
            return null;
        }
        List<ChannelVO> channelInfoList = new ArrayList<ChannelVO>(channelList.size());
        for (Channel channel : channelList) {
            channelInfoList.add(toChannelVO(channel));
        }
        return channelInfoList;
    }

    public static List<Channel> toChannelList(List<ChannelDTO> channelDTOList) {
        if (channelDTOList == null || channelDTOList.isEmpty()) {
            return null;
        }
        List<Channel> channelList = new ArrayList<Channel>(channelDTOList.size());
        for (ChannelDTO channelDTO : channelDTOList) {
            channelList.add(toChannel(channelDTO));
        }
        return channelList;
    }

    public static QueryResultVO<ChannelVO> toQueryResult(QueryResultVO<Channel> queryResult) {
        QueryResultVO<ChannelVO> queryResultInfo = new QueryResultVO<ChannelVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toChannelVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
package com.suyan.mall.message.service.impl;

import com.suyan.mall.message.biz.ChannelBiz;
import com.suyan.mall.message.convertor.ChannelConvertor;
import com.suyan.mall.message.req.ChannelDTO;
import com.suyan.mall.message.req.ChannelQueryDTO;
import com.suyan.mall.message.resp.ChannelVO;
import com.suyan.mall.message.service.IChannelService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 短信渠道管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service("channelService")
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private ChannelBiz channelBiz;

    @Override
    public int deleteChannel(Integer id) {
        return channelBiz.deleteChannel(id);
    }

    @Override
    public Integer createChannel(ChannelDTO channelDTO) {
        return channelBiz.createChannel(ChannelConvertor.toChannel(channelDTO));
    }

    @Override
    public int updateChannel(ChannelDTO channelDTO) {
        return channelBiz.updateChannel(ChannelConvertor.toChannel(channelDTO));
    }

    @Override
    public ChannelVO getChannel(Integer id) {
        return ChannelConvertor.toChannelVO(channelBiz.getChannel(id));
    }

    @Override
    public QueryResultVO<ChannelVO> queryChannel(ChannelQueryDTO channelQueryDTO) {
        return ChannelConvertor.toQueryResult(channelBiz.queryChannel(channelQueryDTO));
    }

}
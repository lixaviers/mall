package com.suyan.mall.message.service;

import com.suyan.mall.message.req.ChannelDTO;
import com.suyan.mall.message.req.ChannelQueryDTO;
import com.suyan.mall.message.resp.ChannelVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @jdk 1.8
 */
public interface IChannelService {

    /**
     * 删除短信渠道
     *
     * @param id
     * @return
     * @author
     */
    int deleteChannel(Integer id);

    /**
     * 创建短信渠道
     *
     * @param channelDTO
     * @return
     */
    Integer createChannel(ChannelDTO channelDTO);


    /**
     * 更新短信渠道
     *
     * @param channelDTO
     * @return
     */
    int updateChannel(ChannelDTO channelDTO);

    /**
     * 根据ID获取短信渠道信息
     *
     * @param id
     * @return
     */
    ChannelVO getChannel(Integer id);

    /**
     * 分页查询短信渠道信息
     *
     * @param channelQueryDTO
     * @return
     */
    QueryResultVO<ChannelVO> queryChannel(ChannelQueryDTO channelQueryDTO);


}
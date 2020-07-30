package com.suyan.mall.message.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.message.dao.ChannelMapper;
import com.suyan.mall.message.model.Channel;
import com.suyan.mall.message.req.ChannelQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ChannelBiz {

    @Autowired
    private ChannelMapper channelMapper;

    /**
     * 逻辑删除短信渠道
     *
     * @param id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteChannel(Integer id) {
        return channelMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建短信渠道
     *
     * @param channel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer createChannel(Channel channel) {
        channel.setSecretKey(genKey(channel, "SecretKey"));
        channelMapper.insertSelective(channel);
        return channel.getId();
    }

    private String genKey(Channel channel, String slfSalt) {
        return DigestUtils.md5Hex(slfSalt + channel.toString() + System.currentTimeMillis() + "G#!n@SDFg@R");
    }

    /**
     * 更新短信渠道
     *
     * @param channel
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateChannel(Channel channel) {
        Channel channelLast = channelMapper.selectByPrimaryKey(channel.getId());
        if (channelLast == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "短信渠道");
        }
        return channelMapper.updateByPrimaryKeySelective(channel);
    }

    /**
     * 根据ID获取短信渠道信息
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Channel getChannel(Integer id) {
        return channelMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public Channel getChannel(String channelCode) {
        return channelMapper.selectByChannelCode(channelCode);
    }

    /**
     * 分页查询短信渠道信息
     *
     * @param channelQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<Channel> queryChannel(ChannelQueryDTO channelQuery) {
        QueryResultVO<Channel> queryResult = new QueryResultVO<Channel>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(channelQuery.getPageNo(), channelQuery.getPageSize());
        List<Channel> channelList = channelMapper.queryChannel(channelQuery);
        PageInfo<Channel> pageInfo = new PageInfo<Channel>(channelList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(channelList);
        return queryResult;
    }

}
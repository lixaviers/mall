/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.biz;

import com.suyan.exception.CommonException;
import com.suyan.mall.operation.dao.MqMessageDataMapper;
import com.suyan.mall.operation.model.MqMessageData;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层消息数据管理类>
 */
@Slf4j
@Service
public class MqMessageDataBiz {

    @Autowired
    private MqMessageDataMapper mqMessageDataMapper;

    /**
     * 删除消息数据
     *
     * @param id
     * @return
     */
    public Integer deleteMqMessageData(Long id) {
        // TODO: Describe business logic and implement it
        getBaseMqMessageData(id);
        return mqMessageDataMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建消息数据
     *
     * @param mqMessageData
     * @return
     */
    public Long createMqMessageData(MqMessageData mqMessageData) {
        mqMessageDataMapper.insertSelective(mqMessageData);
        return mqMessageData.getId();
    }

    /**
     * 更新消息数据
     *
     * @param mqMessageData
     * @return
     */
    public Integer updateMqMessageData(MqMessageData mqMessageData) {
        getBaseMqMessageData(mqMessageData.getId());
        return mqMessageDataMapper.updateByPrimaryKeySelective(mqMessageData);
    }

    /**
     * 根据ID获取消息数据信息
     *
     * @param id
     * @return
     */
    public MqMessageData getMqMessageData(Long id) {
        return getBaseMqMessageData(id);
    }

    @Transactional(readOnly = true)
    public MqMessageData getBaseMqMessageData(Long id) {
        MqMessageData mqMessageData = mqMessageDataMapper.selectByPrimaryKey(id);
        if (mqMessageData == null || mqMessageData.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "消息数据");
        }
        return mqMessageData;
    }


}
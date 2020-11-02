/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service.impl;

import com.suyan.mall.operation.biz.MqMessageDataBiz;
import com.suyan.mall.operation.convertor.MqMessageDataConvertor;
import com.suyan.mall.operation.req.MqMessageDataDTO;
import com.suyan.mall.operation.service.IMqMessageDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 消息数据管理类>
 */
@Slf4j
@Service("mqMessageDataService")
public class MqMessageDataServiceImpl implements IMqMessageDataService {

    @Autowired
    private MqMessageDataBiz mqMessageDataBiz;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createMqMessageData(MqMessageDataDTO mqMessageDataDTO) {
        return mqMessageDataBiz.createMqMessageData(MqMessageDataConvertor.toMqMessageData(mqMessageDataDTO));
    }

}
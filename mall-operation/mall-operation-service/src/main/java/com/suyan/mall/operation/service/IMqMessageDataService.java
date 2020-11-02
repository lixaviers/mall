/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service;

import com.suyan.mall.operation.req.MqMessageDataDTO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IMqMessageDataService {


    /**
     * 创建消息数据
     *
     * @param mqMessageDataDTO
     * @return
     */
    Long createMqMessageData(MqMessageDataDTO mqMessageDataDTO);

}
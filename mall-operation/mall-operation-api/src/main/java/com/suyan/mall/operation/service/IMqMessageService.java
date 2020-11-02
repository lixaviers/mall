/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：MqMessageService.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service;


import com.suyan.mall.operation.req.MqMessageDataDTO;

/**
 * The interface Tpc mq message feign api.
 *
 * @author paascloud.net @gmail.com
 */
public interface IMqMessageService {

    /**
     * 保存等待确认的消息(前置拦截器).
     *
     * @param mqMessageDataDTO the mq message data
     */
    void saveWaitConfirmMessage(MqMessageDataDTO mqMessageDataDTO);

    /**
     * 保存并发送消息(后置拦截器).
     *
     * @param mqMessageDataDTO the mq message data
     */
    void saveAndSendMessage(MqMessageDataDTO mqMessageDataDTO);

}

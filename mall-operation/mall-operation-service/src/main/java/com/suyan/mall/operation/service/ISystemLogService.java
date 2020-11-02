/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.service;

import com.suyan.mall.operation.req.SystemLogDTO;
import com.suyan.mall.operation.req.SystemLogQueryDTO;
import com.suyan.mall.operation.resp.SystemLogVO;
import com.suyan.query.QueryResultVO;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface ISystemLogService {


    /**
     * 创建系统日志
     *
     * @param systemLogDTO
     * @return
     */
    Long createSystemLog(SystemLogDTO systemLogDTO);

    /**
     * 分页查询系统日志信息
     *
     * @param systemLogQueryDTO
     * @return
     */
    QueryResultVO<SystemLogVO> querySystemLog(SystemLogQueryDTO systemLogQueryDTO);


}
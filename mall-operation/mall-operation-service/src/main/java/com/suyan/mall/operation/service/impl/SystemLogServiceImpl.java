package com.suyan.mall.operation.service.impl;

import com.suyan.mall.operation.biz.SystemLogBiz;
import com.suyan.mall.operation.convertor.SystemLogConvertor;
import com.suyan.mall.operation.model.SystemLog;
import com.suyan.mall.operation.req.SystemLogDTO;
import com.suyan.mall.operation.req.SystemLogQueryDTO;
import com.suyan.mall.operation.resp.SystemLogVO;
import com.suyan.mall.operation.service.ISystemLogService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 系统日志管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service("systemLogService")
public class SystemLogServiceImpl implements ISystemLogService {

    @Autowired
    private SystemLogBiz systemLogBiz;

    @Override
    public Long createSystemLog(SystemLogDTO systemLogDTO) {
        SystemLog systemLog = SystemLogConvertor.toSystemLog(systemLogDTO);
        return systemLogBiz.createSystemLog(systemLog);
    }

    @Override
    public QueryResultVO<SystemLogVO> querySystemLog(SystemLogQueryDTO systemLogQueryDTO) {
        return SystemLogConvertor.toQueryResult(systemLogBiz.querySystemLog(systemLogQueryDTO));
    }

}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.mall.operation.dao.SystemLogMapper;
import com.suyan.mall.operation.model.SystemLog;
import com.suyan.mall.operation.req.SystemLogQueryDTO;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层系统日志管理类>
 * @jdk 1.8
 * @Version: <1.0>
 */
@Slf4j
@Service
public class SystemLogBiz {

    @Autowired
    private SystemLogMapper systemLogMapper;


    /**
     * 创建系统日志
     *
     * @param systemLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createSystemLog(SystemLog systemLog) {
        systemLog.setCreateTime(null);
        systemLogMapper.insertSelective(systemLog);
        return systemLog.getId();
    }

    /**
     * 分页查询系统日志信息
     *
     * @param systemLogQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<SystemLog> querySystemLog(SystemLogQueryDTO systemLogQuery) {
        QueryResultVO<SystemLog> queryResult = new QueryResultVO<SystemLog>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(systemLogQuery.getPageNo(), systemLogQuery.getPageSize());
        List<SystemLog> systemLogList = systemLogMapper.querySystemLog(systemLogQuery);
        PageInfo<SystemLog> pageInfo = new PageInfo<SystemLog>(systemLogList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(systemLogList);
        return queryResult;
    }

}
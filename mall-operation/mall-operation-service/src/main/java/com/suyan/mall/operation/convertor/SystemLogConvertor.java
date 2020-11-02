/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.convertor;

import com.suyan.mall.operation.model.SystemLog;
import com.suyan.mall.operation.req.SystemLogDTO;
import com.suyan.mall.operation.resp.SystemLogVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class SystemLogConvertor {

    private static final BeanCopier beanCopierForSystemLogVO = BeanCopier.create(SystemLog.class, SystemLogVO.class, false);
    private static final BeanCopier beanCopierForSystemLog = BeanCopier.create(SystemLogDTO.class, SystemLog.class, false);

    public static SystemLogVO toSystemLogVO(SystemLog systemLog) {
        if (systemLog == null) {
            return null;
        }
        SystemLogVO systemLogVO = new SystemLogVO();
        beanCopierForSystemLogVO.copy(systemLog, systemLogVO, null);
        return systemLogVO;
    }

    public static SystemLog toSystemLog(SystemLogDTO systemLogDTO) {
        SystemLog systemLog = new SystemLog();
        beanCopierForSystemLog.copy(systemLogDTO, systemLog, null);
        return systemLog;
    }

    public static List<SystemLogVO> toSystemLogVOList(List<SystemLog> systemLogList) {
        if (systemLogList == null || systemLogList.isEmpty()) {
            return null;
        }
        List<SystemLogVO> systemLogInfoList = new ArrayList<SystemLogVO>(systemLogList.size());
        for (SystemLog systemLog : systemLogList) {
            systemLogInfoList.add(toSystemLogVO(systemLog));
        }
        return systemLogInfoList;
    }

    public static List<SystemLog> toSystemLogList(List<SystemLogDTO> systemLogDTOList) {
        if (systemLogDTOList == null || systemLogDTOList.isEmpty()) {
            return null;
        }
        List<SystemLog> systemLogList = new ArrayList<SystemLog>(systemLogDTOList.size());
        for (SystemLogDTO systemLogDTO : systemLogDTOList) {
            systemLogList.add(toSystemLog(systemLogDTO));
        }
        return systemLogList;
    }

    public static QueryResultVO<SystemLogVO> toQueryResult(QueryResultVO<SystemLog> queryResult) {
        QueryResultVO<SystemLogVO> queryResultInfo = new QueryResultVO<SystemLogVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toSystemLogVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
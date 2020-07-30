package com.suyan.mall.operation.dao;

import com.suyan.mall.operation.model.SystemLog;
import com.suyan.mall.operation.model.SystemLogExample;
import com.suyan.mall.operation.req.SystemLogQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemLogMapper {
    
    long countByExample(SystemLogExample example);

    int deleteByExample(SystemLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    List<SystemLog> selectByExample(SystemLogExample example);

    SystemLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    int updateByExample(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);


    SystemLog selectByPrimaryKeyForUpdate(Long id);

    List<SystemLog> querySystemLog(SystemLogQueryDTO systemLogQuery);

    int insertBatch(@Param("modelList") List<SystemLog> modelList);

    
    List<SystemLog> selectByShopId(@Param("shopId") Long shopId);


}
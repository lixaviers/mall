/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.AdminRole;
import com.suyan.mall.user.model.AdminRoleExample;
import com.suyan.mall.user.req.AdminRoleQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminRoleMapper {
    
    long countByExample(AdminRoleExample example);

    int deleteByExample(AdminRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    List<AdminRole> selectByExample(AdminRoleExample example);

    AdminRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    int updateByExample(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);


    AdminRole selectByPrimaryKeyForUpdate(Long id);

    List<AdminRole> queryAdminRole(AdminRoleQueryDTO adminRoleQuery);

    int insertBatch(@Param("modelList") List<AdminRole> modelList);

    
    List<AdminRole> selectByAdminId(@Param("adminId") Long adminId);
    
    List<AdminRole> selectByRoleId(@Param("roleId") Long roleId);


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.RoleMenu;
import com.suyan.mall.user.model.RoleMenuExample;
import com.suyan.mall.user.req.RoleMenuQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RoleMenuMapper {
    
    long countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    RoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);


    RoleMenu selectByPrimaryKeyForUpdate(Long id);

    List<RoleMenu> queryRoleMenu(RoleMenuQueryDTO roleMenuQuery);

    int insertBatch(@Param("modelList") List<RoleMenu> modelList);

    
    List<RoleMenu> selectByMenuId(@Param("menuId") Long menuId);
    
    List<RoleMenu> selectByRoleId(@Param("roleId") Long roleId);


}
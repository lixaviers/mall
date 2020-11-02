/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.dao.biz;

import com.suyan.mall.user.dao.MenuMapper;
import com.suyan.mall.user.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuBizMapper extends MenuMapper {

    List<Menu> getAdminMenu(@Param("adminId") Long adminId, @Param("menuType") Byte menuType);

    List<Integer> getRoleMenuIds(@Param("roleId") Long roleId);

}
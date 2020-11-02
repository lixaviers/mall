/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service;

import com.suyan.mall.user.req.MenuDTO;
import com.suyan.mall.user.req.MenuQueryDTO;
import com.suyan.mall.user.resp.MenuVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IMenuService {

    /**
     * 删除菜单
     *
     * @param id
     * @return
     * @author
     */
    int deleteMenu(Long id);

    /**
     * 创建菜单
     *
     * @param menuDTO
     * @return
     */
    Long createMenu(MenuDTO menuDTO);


    /**
     * 更新菜单
     *
     * @param menuDTO
     * @return
     */
    int updateMenu(MenuDTO menuDTO);

    /**
     * 根据ID获取菜单信息
     *
     * @param id
     * @return
     */
    MenuVO getMenu(Long id);

    /**
     * 分页查询菜单信息
     *
     * @param menuQueryDTO
     * @return
     */
    QueryResultVO<MenuVO> queryMenu(MenuQueryDTO menuQueryDTO);

    /**
     * 获取当前登录管理员菜单
     *
     * @return
     */
    List<MenuVO> getAdminMenu();

    /**
     * 获取所有菜单信息
     *
     * @return
     */
    List<MenuVO> getAllMenu();


}
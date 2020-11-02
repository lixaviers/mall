/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.user.dao.biz.MenuBizMapper;
import com.suyan.mall.user.enums.MenuTypeEnum;
import com.suyan.mall.user.model.Admin;
import com.suyan.mall.user.model.Menu;
import com.suyan.mall.user.model.MenuExample;
import com.suyan.mall.user.req.MenuQueryDTO;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层菜单管理类>
 */
@Slf4j
@Service
public class MenuBiz {

    @Autowired
    private MenuBizMapper menuBizMapper;

    @Autowired
    private AdminBiz adminBiz;

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    public Integer deleteMenu(Long id) {
        getBaseMenu(id);
        return menuBizMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建菜单
     *
     * @param menu
     * @return
     */
    public Long createMenu(Menu menu) {
        menuBizMapper.insertSelective(menu);
        return menu.getId();
    }

    /**
     * 更新菜单
     *
     * @param menu
     * @return
     */
    public Integer updateMenu(Menu menu) {
        getBaseMenu(menu.getId());
        return menuBizMapper.updateByPrimaryKeySelective(menu);
    }

    /**
     * 根据ID获取菜单信息
     *
     * @param id
     * @return
     */
    public Menu getMenu(Long id) {
        return getBaseMenu(id);
    }

    @Transactional(readOnly = true)
    public Menu getBaseMenu(Long id) {
        Menu menu = menuBizMapper.selectByPrimaryKey(id);
        if (menu == null || menu.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "菜单");
        }
        return menu;
    }

    /**
     * 分页查询菜单信息
     *
     * @param menuQuery
     * @return
     */
    public QueryResultVO<Menu> queryMenu(MenuQueryDTO menuQuery) {
        QueryResultVO<Menu> queryResult = new QueryResultVO<Menu>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(menuQuery.getPageNo(), menuQuery.getPageSize());
        List<Menu> menuList = menuBizMapper.queryMenu(menuQuery);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(menuList);
        return queryResult;
    }

    public List<Menu> getAdminMenu() {
        Long adminId = UserUtil.getAdmin().getId();
        Admin admin = adminBiz.getBaseAdmin(adminId);
        if (admin.getIsSuperAdmin()) {
            // 超级管理员获取所有菜单
            return getAllMenu(true, MenuTypeEnum.PAGE.getValue());
        } else {
            return menuBizMapper.getAdminMenu(adminId, MenuTypeEnum.PAGE.getValue());
        }
    }

    /**
     * 获取所有菜单
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Menu> getAllMenu(Boolean isEnable, Byte menuType) {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria().andIsDeletedEqualTo(false);
        if (isEnable != null) {
            criteria.andIsEnableEqualTo(isEnable);
        }
        if (menuType != null) {
            criteria.andMenuTypeEqualTo(menuType);
        }
        example.setOrderByClause("sort_number");
        return menuBizMapper.selectByExample(example);
    }
}
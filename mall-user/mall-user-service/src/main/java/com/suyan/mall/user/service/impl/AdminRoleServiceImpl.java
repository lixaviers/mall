/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.service.IAdminRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.suyan.mall.user.biz.AdminRoleBiz;
import com.suyan.mall.user.convertor.AdminRoleConvertor;
import com.suyan.mall.user.model.AdminRole;
import com.suyan.mall.user.req.AdminRoleDTO;
import com.suyan.mall.user.req.AdminRoleQueryDTO;
import com.suyan.mall.user.resp.AdminRoleVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 管理员角色管理类>
 */
@Slf4j
@Service("adminRoleService")
public class AdminRoleServiceImpl implements IAdminRoleService {

    @Autowired
    private AdminRoleBiz adminRoleBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteAdminRole(Long id) {
        return adminRoleBiz.deleteAdminRole(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createAdminRole(AdminRoleDTO adminRoleDTO) {
        return adminRoleBiz.createAdminRole(AdminRoleConvertor.toAdminRole(adminRoleDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateAdminRole(AdminRoleDTO adminRoleDTO) {
        return adminRoleBiz.updateAdminRole(AdminRoleConvertor.toAdminRole(adminRoleDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public AdminRoleVO getAdminRole(Long id ) {
        return AdminRoleConvertor.toAdminRoleVO(adminRoleBiz.getAdminRole(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<AdminRoleVO> queryAdminRole(AdminRoleQueryDTO adminRoleQueryDTO) {
        return AdminRoleConvertor.toQueryResult(adminRoleBiz.queryAdminRole(adminRoleQueryDTO));
    }

}
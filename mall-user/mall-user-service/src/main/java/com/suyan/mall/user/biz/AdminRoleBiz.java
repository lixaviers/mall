/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.user.dao.AdminRoleMapper;
import com.suyan.mall.user.model.AdminRole;
import com.suyan.mall.user.req.AdminRoleQueryDTO;
import com.suyan.exception.CommonException;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层管理员角色管理类>
 */
@Slf4j
@Service
public class AdminRoleBiz {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    /**
     * 删除管理员角色
     *
     * @param id
     * @return
     */
    public Integer deleteAdminRole(Long id) {
        // TODO: Describe business logic and implement it
        getBaseAdminRole(id);
        return adminRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建管理员角色
     * 
     * @param adminRole
     * @return
     */
    public Long createAdminRole(AdminRole adminRole) {
        // TODO: Describe business logic and implement it
        adminRoleMapper.insertSelective( adminRole );
        return adminRole.getId();
    }

    /**
    * 批量创建
    *
    * @param adminRoleList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateAdminRole(List<AdminRole> adminRoleList) {
        // TODO: Describe business logic and implement it
        return adminRoleMapper.insertBatch( adminRoleList );
    }

    /**
     * 更新管理员角色
     * 
     * @param adminRole
     * @return
     */
    public Integer updateAdminRole(AdminRole adminRole) {
        getBaseAdminRole(adminRole.getId());
        return adminRoleMapper.updateByPrimaryKeySelective(adminRole);
    }
    
    /**
     * 根据ID获取管理员角色信息
     * 
     * @param id
     * @return
     */
    public AdminRole getAdminRole(Long id) {
        return getBaseAdminRole(id);
    }

    @Transactional(readOnly = true)
    public AdminRole getBaseAdminRole(Long id) {
        AdminRole adminRole = adminRoleMapper.selectByPrimaryKey(id);
        if(adminRole == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "管理员角色");
        }
        return adminRole;
    }

    /**
     * 分页查询管理员角色信息
     * 
     * @param adminRoleQuery
     * @return
     */
    public QueryResultVO<AdminRole> queryAdminRole(AdminRoleQueryDTO adminRoleQuery) {
        QueryResultVO<AdminRole> queryResult = new QueryResultVO<AdminRole>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(adminRoleQuery.getPageNo(), adminRoleQuery.getPageSize());
        List<AdminRole> adminRoleList = adminRoleMapper.queryAdminRole(adminRoleQuery);
        PageInfo<AdminRole> pageInfo = new PageInfo<AdminRole>(adminRoleList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(adminRoleList);
        return queryResult;
    }

}
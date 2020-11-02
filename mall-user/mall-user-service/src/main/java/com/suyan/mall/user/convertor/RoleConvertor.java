/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.Role;
import com.suyan.mall.user.req.RoleDTO;
import com.suyan.mall.user.resp.RoleVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class RoleConvertor {

    private static final BeanCopier beanCopierForRoleVO = BeanCopier.create(Role.class, RoleVO.class, false);
    private static final BeanCopier beanCopierForRole = BeanCopier.create(RoleDTO.class, Role.class, false);

    public static RoleVO toRoleVO(Role role) {
        if (role == null) {
            return null;
        }
        RoleVO roleVO = new RoleVO();
        beanCopierForRoleVO.copy(role, roleVO, null);
        return roleVO;
    }

    public static Role toRole(RoleDTO roleDTO) {
        Role role = new Role();
        beanCopierForRole.copy(roleDTO, role, null);
        return role;
    }

    public static List<RoleVO> toRoleVOList(List<Role> roleList) {
        if (roleList == null || roleList.isEmpty()) {
            return null;
        }
        List<RoleVO> roleInfoList = new ArrayList<RoleVO>(roleList.size());
        for (Role role : roleList) {
            roleInfoList.add(toRoleVO(role));
        }
        return roleInfoList;
    }

    public static List<Role> toRoleList(List<RoleDTO> roleDTOList) {
        if (roleDTOList == null || roleDTOList.isEmpty()) {
            return null;
        }
        List<Role> roleList = new ArrayList<Role>(roleDTOList.size());
        for (RoleDTO roleDTO : roleDTOList) {
            roleList.add(toRole(roleDTO));
        }
        return roleList;
    }

    public static QueryResultVO<RoleVO> toQueryResult(QueryResultVO<Role> queryResult) {
        QueryResultVO<RoleVO> queryResultInfo = new QueryResultVO<RoleVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toRoleVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
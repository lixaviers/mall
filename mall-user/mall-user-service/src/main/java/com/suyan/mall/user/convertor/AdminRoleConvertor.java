/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.AdminRole;
import com.suyan.mall.user.req.AdminRoleDTO;
import com.suyan.mall.user.resp.AdminRoleVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class AdminRoleConvertor {

    private static final BeanCopier beanCopierForAdminRoleVO = BeanCopier.create(AdminRole.class, AdminRoleVO.class, false);
    private static final BeanCopier beanCopierForAdminRole = BeanCopier.create(AdminRoleDTO.class, AdminRole.class, false);

    public static AdminRoleVO toAdminRoleVO(AdminRole adminRole) {
        if (adminRole == null) {
            return null;
        }
        AdminRoleVO adminRoleVO = new AdminRoleVO();
        beanCopierForAdminRoleVO.copy(adminRole, adminRoleVO, null);
        return adminRoleVO;
    }

    public static AdminRole toAdminRole(AdminRoleDTO adminRoleDTO) {
        AdminRole adminRole = new AdminRole();
        beanCopierForAdminRole.copy(adminRoleDTO, adminRole, null);
        return adminRole;
    }

    public static List<AdminRoleVO> toAdminRoleVOList(List<AdminRole> adminRoleList) {
        if (adminRoleList == null || adminRoleList.isEmpty()) {
            return null;
        }
        List<AdminRoleVO> adminRoleInfoList = new ArrayList<AdminRoleVO>(adminRoleList.size());
        for (AdminRole adminRole : adminRoleList) {
            adminRoleInfoList.add(toAdminRoleVO(adminRole));
        }
        return adminRoleInfoList;
    }

    public static List<AdminRole> toAdminRoleList(List<AdminRoleDTO> adminRoleDTOList) {
        if (adminRoleDTOList == null || adminRoleDTOList.isEmpty()) {
            return null;
        }
        List<AdminRole> adminRoleList = new ArrayList<AdminRole>(adminRoleDTOList.size());
        for (AdminRoleDTO adminRoleDTO : adminRoleDTOList) {
            adminRoleList.add(toAdminRole(adminRoleDTO));
        }
        return adminRoleList;
    }

    public static QueryResultVO<AdminRoleVO> toQueryResult(QueryResultVO<AdminRole> queryResult) {
        QueryResultVO<AdminRoleVO> queryResultInfo = new QueryResultVO<AdminRoleVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toAdminRoleVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
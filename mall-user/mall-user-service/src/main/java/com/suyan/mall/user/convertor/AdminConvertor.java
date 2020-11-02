/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.Admin;
import com.suyan.mall.user.req.AdminDTO;
import com.suyan.mall.user.resp.AdminVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class AdminConvertor {

    private static final BeanCopier beanCopierForAdminVO = BeanCopier.create(Admin.class, AdminVO.class, false);
    private static final BeanCopier beanCopierForUserInfoVO = BeanCopier.create(Admin.class, UserInfoVO.class, false);
    private static final BeanCopier beanCopierForAdmin = BeanCopier.create(AdminDTO.class, Admin.class, false);

    public static AdminVO toAdminVO(Admin admin) {
        if (admin == null) {
            return null;
        }
        AdminVO adminVO = new AdminVO();
        beanCopierForAdminVO.copy(admin, adminVO, null);
        return adminVO;
    }

    public static UserInfoVO toUserInfoVO(Admin admin) {
        if (admin == null) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        beanCopierForUserInfoVO.copy(admin, userInfoVO, null);
        return userInfoVO;
    }

    public static Admin toAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        beanCopierForAdmin.copy(adminDTO, admin, null);
        return admin;
    }

    public static List<AdminVO> toAdminVOList(List<Admin> adminList) {
        if (adminList == null || adminList.isEmpty()) {
            return null;
        }
        List<AdminVO> adminInfoList = new ArrayList<AdminVO>(adminList.size());
        for (Admin admin : adminList) {
            adminInfoList.add(toAdminVO(admin));
        }
        return adminInfoList;
    }

    public static List<Admin> toAdminList(List<AdminDTO> adminDTOList) {
        if (adminDTOList == null || adminDTOList.isEmpty()) {
            return null;
        }
        List<Admin> adminList = new ArrayList<Admin>(adminDTOList.size());
        for (AdminDTO adminDTO : adminDTOList) {
            adminList.add(toAdmin(adminDTO));
        }
        return adminList;
    }

    public static QueryResultVO<AdminVO> toQueryResult(QueryResultVO<Admin> queryResult) {
        QueryResultVO<AdminVO> queryResultInfo = new QueryResultVO<AdminVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toAdminVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
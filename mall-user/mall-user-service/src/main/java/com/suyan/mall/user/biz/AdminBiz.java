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
import com.suyan.mall.user.dao.AdminMapper;
import com.suyan.mall.user.enums.CommonStatusEnum;
import com.suyan.mall.user.model.Admin;
import com.suyan.mall.user.req.AdminQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.PasswordEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层管理员管理类>
 */
@Slf4j
@Service
public class AdminBiz {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;

    /**
     * 删除管理员
     *
     * @param id
     * @return
     */
    public Integer deleteAdmin(Long id) {
        getBaseAdmin(id);
        return adminMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建管理员
     *
     * @param admin
     * @return
     */
    public Long createAdmin(Admin admin) {
        adminMapper.insertSelective(admin);
        return admin.getId();
    }

    /**
     * 更新管理员
     *
     * @param admin
     * @return
     */
    public Integer updateAdmin(Admin admin) {
        getBaseAdmin(admin.getId());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    /**
     * 根据ID获取管理员信息
     *
     * @param id
     * @return
     */
    public Admin getAdmin(Long id) {
        return getBaseAdmin(id);
    }

    public Admin getBaseAdmin(Long id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        if (admin == null || admin.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "管理员");
        }
        return admin;
    }

    /**
     * 分页查询管理员信息
     *
     * @param adminQuery
     * @return
     */
    public QueryResultVO<Admin> queryAdmin(AdminQueryDTO adminQuery) {
        QueryResultVO<Admin> queryResult = new QueryResultVO<Admin>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(adminQuery.getPageNo(), adminQuery.getPageSize());
        List<Admin> adminList = adminMapper.queryAdmin(adminQuery);
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(adminList);
        return queryResult;
    }

    public Admin login(Admin admin) {
        Admin adminLast = getAdminByUserName(admin.getUserName());
        if (Objects.isNull(adminLast)) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "用户名");
        }
        if (!passwordEncoderUtil.matches(admin.getUserPwd(), adminLast.getUserPwd())) {
            throw new CommonException(ResultCode.LOGIN_ERROR);
        }
        if (CommonStatusEnum.DISABLE.equal(adminLast.getUserStatus())) {
            throw new CommonException(ResultCode.USER_DISABLE_ERROR);
        }
        return adminLast;
    }

    /**
     * 根据用户名查询管理员是否存在
     *
     * @param userName
     * @return
     */
    @Transactional(readOnly = true)
    public Admin getAdminByUserName(String userName) {
        List<Admin> adminList = adminMapper.selectByUserName(userName);
        if (CollectionsUtil.isEmpty(adminList)) {
            return null;
        }
        return adminList.get(0);
    }


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.service;

import com.suyan.mall.user.req.AdminDTO;
import com.suyan.mall.user.req.AdminQueryDTO;
import com.suyan.mall.user.resp.AdminVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IAdminService {

    /**
     * 删除管理员
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteAdmin(Long id);
    
    /**
     * 创建管理员
     * 
     * @param adminDTO
     * @return
     */
    Long createAdmin(AdminDTO adminDTO);


    /**
     * 更新管理员
     * 
     * @param adminDTO
     * @return
     */
    int updateAdmin(AdminDTO adminDTO);
    
    /**
     * 根据ID获取管理员信息
     * 
     * @param id
     * @return
     */
    AdminVO getAdmin(Long id);

    /**
     * 分页查询管理员信息
     * 
     * @param adminQueryDTO
     * @return
     */
    QueryResultVO<AdminVO> queryAdmin(AdminQueryDTO adminQueryDTO);


    UserInfoVO login(AdminDTO adminDTO);


}
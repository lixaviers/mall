package com.suyan.mall.user.service;

import com.suyan.mall.user.req.AdminRoleDTO;
import com.suyan.mall.user.req.AdminRoleQueryDTO;
import com.suyan.mall.user.resp.AdminRoleVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IAdminRoleService {

    /**
     * 删除管理员角色
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteAdminRole(Long id);
    
    /**
     * 创建管理员角色
     * 
     * @param adminRoleDTO
     * @return
     */
    Long createAdminRole(AdminRoleDTO adminRoleDTO);


    /**
     * 更新管理员角色
     * 
     * @param adminRoleDTO
     * @return
     */
    int updateAdminRole(AdminRoleDTO adminRoleDTO);
    
    /**
     * 根据ID获取管理员角色信息
     * 
     * @param id
     * @return
     */
    AdminRoleVO getAdminRole(Long id);

    /**
     * 分页查询管理员角色信息
     * 
     * @param adminRoleQueryDTO
     * @return
     */
    QueryResultVO<AdminRoleVO> queryAdminRole(AdminRoleQueryDTO adminRoleQueryDTO);



}
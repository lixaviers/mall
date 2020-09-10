package com.suyan.mall.user.service;

import com.suyan.mall.user.req.RoleMenuDTO;
import com.suyan.mall.user.req.RoleMenuQueryDTO;
import com.suyan.mall.user.resp.RoleMenuVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IRoleMenuService {

    /**
     * 删除角色菜单
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteRoleMenu(Long id);
    
    /**
     * 创建角色菜单
     * 
     * @param roleMenuDTO
     * @return
     */
    Long createRoleMenu(RoleMenuDTO roleMenuDTO);


    /**
     * 更新角色菜单
     * 
     * @param roleMenuDTO
     * @return
     */
    int updateRoleMenu(RoleMenuDTO roleMenuDTO);
    
    /**
     * 根据ID获取角色菜单信息
     * 
     * @param id
     * @return
     */
    RoleMenuVO getRoleMenu(Long id);

    /**
     * 分页查询角色菜单信息
     * 
     * @param roleMenuQueryDTO
     * @return
     */
    QueryResultVO<RoleMenuVO> queryRoleMenu(RoleMenuQueryDTO roleMenuQueryDTO);



}
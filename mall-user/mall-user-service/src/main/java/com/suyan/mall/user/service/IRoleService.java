package com.suyan.mall.user.service;

import com.suyan.mall.user.req.RoleDTO;
import com.suyan.mall.user.req.RoleQueryDTO;
import com.suyan.mall.user.resp.RoleVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IRoleService {

    /**
     * 删除
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteRole(Long id);
    
    /**
     * 创建
     * 
     * @param roleDTO
     * @return
     */
    Long createRole(RoleDTO roleDTO);


    /**
     * 更新
     * 
     * @param roleDTO
     * @return
     */
    int updateRole(RoleDTO roleDTO);
    
    /**
     * 根据ID获取信息
     * 
     * @param id
     * @return
     */
    RoleVO getRole(Long id);

    /**
     * 分页查询信息
     * 
     * @param roleQueryDTO
     * @return
     */
    QueryResultVO<RoleVO> queryRole(RoleQueryDTO roleQueryDTO);



}
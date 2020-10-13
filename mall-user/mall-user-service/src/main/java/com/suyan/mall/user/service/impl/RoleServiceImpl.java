package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.biz.RoleBiz;
import com.suyan.mall.user.biz.RoleMenuBiz;
import com.suyan.mall.user.convertor.RoleConvertor;
import com.suyan.mall.user.req.RoleDTO;
import com.suyan.mall.user.req.RoleQueryDTO;
import com.suyan.mall.user.resp.RoleVO;
import com.suyan.mall.user.service.IRoleService;
import com.suyan.query.QueryResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 管理类>
 */
@Slf4j
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleBiz roleBiz;
    @Autowired
    private RoleMenuBiz roleMenuBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteRole(Long id) {
        return roleBiz.deleteRole(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void createRole(RoleDTO roleDTO) {
        Long id = roleBiz.createRole(RoleConvertor.toRole(roleDTO));
        // 添加角色菜单关系
        roleMenuBiz.createRoleMenu(id, roleDTO.getMenuIds());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void updateRole(RoleDTO roleDTO) {
        roleBiz.updateRole(RoleConvertor.toRole(roleDTO));
        // 更新角色菜单关系
        roleMenuBiz.updateRoleMenu(roleDTO.getId(), roleDTO.getMenuIds());
    }

    @Override
    @Transactional(readOnly = true)
    public RoleVO getRole(Long id) {
        RoleVO roleVO = RoleConvertor.toRoleVO(roleBiz.getRole(id));
        roleVO.setMenuIds(roleMenuBiz.getRoleMenu(id));
        return roleVO;
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<RoleVO> queryRole(RoleQueryDTO roleQueryDTO) {
        return RoleConvertor.toQueryResult(roleBiz.queryRole(roleQueryDTO));
    }

}
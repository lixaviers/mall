package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.service.IRoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.suyan.mall.user.biz.RoleMenuBiz;
import com.suyan.mall.user.convertor.RoleMenuConvertor;
import com.suyan.mall.user.model.RoleMenu;
import com.suyan.mall.user.req.RoleMenuDTO;
import com.suyan.mall.user.req.RoleMenuQueryDTO;
import com.suyan.mall.user.resp.RoleMenuVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 角色菜单管理类>
 */
@Slf4j
@Service("roleMenuService")
public class RoleMenuServiceImpl implements IRoleMenuService {

    @Autowired
    private RoleMenuBiz roleMenuBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteRoleMenu(Long id) {
        return roleMenuBiz.deleteRoleMenu(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createRoleMenu(RoleMenuDTO roleMenuDTO) {
        return roleMenuBiz.createRoleMenu(RoleMenuConvertor.toRoleMenu(roleMenuDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateRoleMenu(RoleMenuDTO roleMenuDTO) {
        return roleMenuBiz.updateRoleMenu(RoleMenuConvertor.toRoleMenu(roleMenuDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public RoleMenuVO getRoleMenu(Long id ) {
        return RoleMenuConvertor.toRoleMenuVO(roleMenuBiz.getRoleMenu(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<RoleMenuVO> queryRoleMenu(RoleMenuQueryDTO roleMenuQueryDTO) {
        return RoleMenuConvertor.toQueryResult(roleMenuBiz.queryRoleMenu(roleMenuQueryDTO));
    }

}
package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.suyan.mall.user.biz.RoleBiz;
import com.suyan.mall.user.convertor.RoleConvertor;
import com.suyan.mall.user.model.Role;
import com.suyan.mall.user.req.RoleDTO;
import com.suyan.mall.user.req.RoleQueryDTO;
import com.suyan.mall.user.resp.RoleVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 管理类>
 */
@Slf4j
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleBiz roleBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteRole(Long id) {
        return roleBiz.deleteRole(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createRole(RoleDTO roleDTO) {
        return roleBiz.createRole(RoleConvertor.toRole(roleDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateRole(RoleDTO roleDTO) {
        return roleBiz.updateRole(RoleConvertor.toRole(roleDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public RoleVO getRole(Long id ) {
        return RoleConvertor.toRoleVO(roleBiz.getRole(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<RoleVO> queryRole(RoleQueryDTO roleQueryDTO) {
        return RoleConvertor.toQueryResult(roleBiz.queryRole(roleQueryDTO));
    }

}
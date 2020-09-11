package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.exception.CommonException;
import com.suyan.mall.user.dao.RoleMapper;
import com.suyan.mall.user.model.Role;
import com.suyan.mall.user.req.RoleQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层管理类>
 */
@Slf4j
@Service
public class RoleBiz {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public Integer deleteRole(Long id) {
        getBaseRole(id);
        return roleMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建
     *
     * @param role
     * @return
     */
    public Long createRole(Role role) {
        roleMapper.insertSelective(role);
        return role.getId();
    }

    /**
     * 批量创建
     *
     * @param roleList
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateRole(List<Role> roleList) {
        return roleMapper.insertBatch(roleList);
    }

    /**
     * 更新
     *
     * @param role
     * @return
     */
    public Integer updateRole(Role role) {
        getBaseRole(role.getId());
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 根据ID获取信息
     *
     * @param id
     * @return
     */
    public Role getRole(Long id) {
        return getBaseRole(id);
    }

    public Role getBaseRole(Long id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if (role == null || role.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "");
        }
        return role;
    }

    /**
     * 分页查询信息
     *
     * @param roleQuery
     * @return
     */
    public QueryResultVO<Role> queryRole(RoleQueryDTO roleQuery) {
        QueryResultVO<Role> queryResult = new QueryResultVO<Role>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(roleQuery.getPageNo(), roleQuery.getPageSize());
        List<Role> roleList = roleMapper.queryRole(roleQuery);
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(roleList);
        return queryResult;
    }

}
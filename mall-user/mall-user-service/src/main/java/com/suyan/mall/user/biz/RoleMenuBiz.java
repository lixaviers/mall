package com.suyan.mall.user.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.user.dao.RoleMenuMapper;
import com.suyan.mall.user.model.RoleMenu;
import com.suyan.mall.user.req.RoleMenuQueryDTO;
import com.suyan.exception.CommonException;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <业务层角色菜单管理类>
 */
@Slf4j
@Service
public class RoleMenuBiz {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 删除角色菜单
     *
     * @param id
     * @return
     */
    public Integer deleteRoleMenu(Long id) {
        // TODO: Describe business logic and implement it
        getBaseRoleMenu(id);
        return roleMenuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建角色菜单
     * 
     * @param roleMenu
     * @return
     */
    public Long createRoleMenu(RoleMenu roleMenu) {
        // TODO: Describe business logic and implement it
        roleMenuMapper.insertSelective( roleMenu );
        return roleMenu.getId();
    }

    /**
    * 批量创建
    *
    * @param roleMenuList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateRoleMenu(List<RoleMenu> roleMenuList) {
        // TODO: Describe business logic and implement it
        return roleMenuMapper.insertBatch( roleMenuList );
    }

    /**
     * 更新角色菜单
     * 
     * @param roleMenu
     * @return
     */
    public Integer updateRoleMenu(RoleMenu roleMenu) {
        getBaseRoleMenu(roleMenu.getId());
        return roleMenuMapper.updateByPrimaryKeySelective(roleMenu);
    }
    
    /**
     * 根据ID获取角色菜单信息
     * 
     * @param id
     * @return
     */
    public RoleMenu getRoleMenu(Long id) {
        return getBaseRoleMenu(id);
    }

    @Transactional(readOnly = true)
    public RoleMenu getBaseRoleMenu(Long id) {
        RoleMenu roleMenu = roleMenuMapper.selectByPrimaryKey(id);
        if(roleMenu == null) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "角色菜单");
        }
        return roleMenu;
    }

    /**
     * 分页查询角色菜单信息
     * 
     * @param roleMenuQuery
     * @return
     */
    public QueryResultVO<RoleMenu> queryRoleMenu(RoleMenuQueryDTO roleMenuQuery) {
        QueryResultVO<RoleMenu> queryResult = new QueryResultVO<RoleMenu>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(roleMenuQuery.getPageNo(), roleMenuQuery.getPageSize());
        List<RoleMenu> roleMenuList = roleMenuMapper.queryRoleMenu(roleMenuQuery);
        PageInfo<RoleMenu> pageInfo = new PageInfo<RoleMenu>(roleMenuList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(roleMenuList);
        return queryResult;
    }

}
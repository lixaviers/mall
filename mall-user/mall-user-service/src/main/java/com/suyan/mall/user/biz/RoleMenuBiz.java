package com.suyan.mall.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.suyan.exception.CommonException;
import com.suyan.mall.user.dao.RoleMenuMapper;
import com.suyan.mall.user.model.RoleMenu;
import com.suyan.mall.user.model.RoleMenuExample;
import com.suyan.mall.user.req.RoleMenuQueryDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        getBaseRoleMenu(id);
        return roleMenuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建角色菜单
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    public void createRoleMenu(Long roleId, List<Long> menuIds) {
        if (!CollectionUtils.isEmpty(menuIds)) {
            // 分批插入
            List<List<Long>> partition = Lists.partition(menuIds, 100);
            for (List<Long> list : partition) {
                List<RoleMenu> roleMenuList = new ArrayList<>();
                for (Long menuId : list) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setMenuId(menuId);
                    roleMenu.setRoleId(roleId);
                    roleMenuList.add(roleMenu);
                }
                roleMenuMapper.insertBatch(roleMenuList);
            }
        }
    }

    /**
     * 更新角色菜单
     *
     * @return
     */
    public void updateRoleMenu(Long roleId, List<Long> newMenuIds) {
        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleMenu> oldRoleMenuList = roleMenuMapper.selectByExample(example);

        // 删除的id列表
        List<Long> deleteIdList = null;
        // 新增的菜单id列表
        List<Long> addMenuIdList = null;

        if (!CollectionUtils.isEmpty(oldRoleMenuList)) {
            List<Long> oldMenuIds = oldRoleMenuList.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(newMenuIds)) {
                // 删除
                deleteIdList = oldRoleMenuList.stream().filter(item -> !newMenuIds.contains(item.getMenuId())).map(RoleMenu::getMenuId).collect(Collectors.toList());
                // 新增
                addMenuIdList = newMenuIds.stream().filter(item -> !oldMenuIds.contains(item)).collect(Collectors.toList());
            } else {
                deleteIdList = oldRoleMenuList.stream().map(RoleMenu::getId).collect(Collectors.toList());
            }
        } else {
            addMenuIdList = newMenuIds;
        }

        // 删除
        if (!CollectionUtils.isEmpty(deleteIdList)) {
            RoleMenuExample deleteExample = new RoleMenuExample();
            deleteExample.createCriteria().andIdIn(deleteIdList);
            roleMenuMapper.deleteByExample(example);
        }

        // 新增
        createRoleMenu(roleId, addMenuIdList);

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
        if (roleMenu == null) {
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
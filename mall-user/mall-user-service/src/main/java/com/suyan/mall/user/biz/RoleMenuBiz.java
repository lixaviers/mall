package com.suyan.mall.user.biz;

import com.google.common.collect.Lists;
import com.suyan.mall.user.dao.RoleMenuMapper;
import com.suyan.mall.user.model.RoleMenu;
import com.suyan.mall.user.model.RoleMenuExample;
import com.suyan.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
     * 创建角色菜单
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    public void createRoleMenu(Long roleId, List<Long> menuIds) {
        if (CollectionsUtil.isNotEmpty(menuIds)) {
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

        if (CollectionsUtil.isNotEmpty(oldRoleMenuList)) {
            List<Long> oldMenuIds = oldRoleMenuList.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
            if (CollectionsUtil.isNotEmpty(newMenuIds)) {
                // 删除
                deleteIdList = oldRoleMenuList.stream().filter(item -> !newMenuIds.contains(item.getMenuId())).map(RoleMenu::getId).collect(Collectors.toList());
                // 新增
                addMenuIdList = newMenuIds.stream().filter(item -> !oldMenuIds.contains(item)).collect(Collectors.toList());
            } else {
                deleteIdList = oldRoleMenuList.stream().map(RoleMenu::getId).collect(Collectors.toList());
            }
        } else {
            addMenuIdList = newMenuIds;
        }

        // 删除
        if (CollectionsUtil.isNotEmpty(deleteIdList)) {
            RoleMenuExample deleteExample = new RoleMenuExample();
            deleteExample.createCriteria().andIdIn(deleteIdList);
            roleMenuMapper.deleteByExample(deleteExample);
        }

        // 新增
        createRoleMenu(roleId, addMenuIdList);

    }

    /**
     * 根据角色id获取菜单id列表
     *
     * @param roleId
     * @return
     */
    public List<Long> getRoleMenu(Long roleId) {
        RoleMenuExample example = new RoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(example);
        if (CollectionsUtil.isEmpty(roleMenus)) {
            return null;
        }
        return roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList());
    }

}
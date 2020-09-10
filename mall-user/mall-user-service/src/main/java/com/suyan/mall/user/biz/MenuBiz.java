package com.suyan.mall.user.biz;

import lombok.extern.slf4j.Slf4j;
import com.suyan.mall.user.dao.MenuMapper;
import com.suyan.mall.user.model.Menu;
import com.suyan.mall.user.req.MenuQueryDTO;
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
 * @Comments: <业务层菜单管理类>
 */
@Slf4j
@Service
public class MenuBiz {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 删除菜单
     *
     * @param id
     * @return
     */
    public Integer deleteMenu(Long id) {
        // TODO: Describe business logic and implement it
        getBaseMenu(id);
        return menuMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建菜单
     * 
     * @param menu
     * @return
     */
    public Long createMenu(Menu menu) {
        // TODO: Describe business logic and implement it
        menuMapper.insertSelective( menu );
        return menu.getId();
    }

    /**
    * 批量创建
    *
    * @param menuList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateMenu(List<Menu> menuList) {
        // TODO: Describe business logic and implement it
        return menuMapper.insertBatch( menuList );
    }

    /**
     * 更新菜单
     * 
     * @param menu
     * @return
     */
    public Integer updateMenu(Menu menu) {
        getBaseMenu(menu.getId());
        return menuMapper.updateByPrimaryKeySelective(menu);
    }
    
    /**
     * 根据ID获取菜单信息
     * 
     * @param id
     * @return
     */
    public Menu getMenu(Long id) {
        return getBaseMenu(id);
    }

    @Transactional(readOnly = true)
    public Menu getBaseMenu(Long id) {
        Menu menu = menuMapper.selectByPrimaryKey(id);
        if(menu == null || menu.getIsDeleted()) {
            throw new CommonException(ResultCode.DATA_NOT_EXIST, "菜单");
        }
        return menu;
    }

    /**
     * 分页查询菜单信息
     * 
     * @param menuQuery
     * @return
     */
    public QueryResultVO<Menu> queryMenu(MenuQueryDTO menuQuery) {
        QueryResultVO<Menu> queryResult = new QueryResultVO<Menu>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(menuQuery.getPageNo(), menuQuery.getPageSize());
        List<Menu> menuList = menuMapper.queryMenu(menuQuery);
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(menuList);
        return queryResult;
    }

}
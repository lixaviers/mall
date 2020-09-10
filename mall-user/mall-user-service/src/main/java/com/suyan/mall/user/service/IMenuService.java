package com.suyan.mall.user.service;

import com.suyan.mall.user.req.MenuDTO;
import com.suyan.mall.user.req.MenuQueryDTO;
import com.suyan.mall.user.resp.MenuVO;
import com.suyan.query.QueryResultVO;

import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IMenuService {

    /**
     * 删除菜单
     * 
     * @author 
    * @param id
     * @return
     */
    int deleteMenu(Long id);
    
    /**
     * 创建菜单
     * 
     * @param menuDTO
     * @return
     */
    Long createMenu(MenuDTO menuDTO);


    /**
     * 更新菜单
     * 
     * @param menuDTO
     * @return
     */
    int updateMenu(MenuDTO menuDTO);
    
    /**
     * 根据ID获取菜单信息
     * 
     * @param id
     * @return
     */
    MenuVO getMenu(Long id);

    /**
     * 分页查询菜单信息
     * 
     * @param menuQueryDTO
     * @return
     */
    QueryResultVO<MenuVO> queryMenu(MenuQueryDTO menuQueryDTO);



}
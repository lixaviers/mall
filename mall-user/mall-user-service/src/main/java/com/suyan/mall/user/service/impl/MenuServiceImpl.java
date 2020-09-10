package com.suyan.mall.user.service.impl;

import com.suyan.mall.user.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.suyan.mall.user.biz.MenuBiz;
import com.suyan.mall.user.convertor.MenuConvertor;
import com.suyan.mall.user.model.Menu;
import com.suyan.mall.user.req.MenuDTO;
import com.suyan.mall.user.req.MenuQueryDTO;
import com.suyan.mall.user.resp.MenuVO;
import com.suyan.query.QueryResultVO;

import java.util.List;


/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <Service 菜单管理类>
 */
@Slf4j
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuBiz menuBiz;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int deleteMenu(Long id) {
        return menuBiz.deleteMenu(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createMenu(MenuDTO menuDTO) {
        return menuBiz.createMenu(MenuConvertor.toMenu(menuDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int updateMenu(MenuDTO menuDTO) {
        return menuBiz.updateMenu(MenuConvertor.toMenu(menuDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public MenuVO getMenu(Long id ) {
        return MenuConvertor.toMenuVO(menuBiz.getMenu(id));
    }

    @Override
    @Transactional(readOnly = true)
    public QueryResultVO<MenuVO> queryMenu(MenuQueryDTO menuQueryDTO) {
        return MenuConvertor.toQueryResult(menuBiz.queryMenu(menuQueryDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuVO> getAdminMenu() {
        return MenuConvertor.toTree(menuBiz.getAdminMenu());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuVO> getAllMenu() {
        return MenuConvertor.toTree(menuBiz.getAllMenu(null));
    }

}
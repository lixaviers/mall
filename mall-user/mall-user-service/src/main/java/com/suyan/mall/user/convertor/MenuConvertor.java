package com.suyan.mall.user.convertor;

import com.google.common.collect.Lists;
import com.suyan.mall.user.model.Menu;
import com.suyan.mall.user.req.MenuDTO;
import com.suyan.mall.user.resp.MenuVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class MenuConvertor {

    private static final BeanCopier beanCopierForMenuVO = BeanCopier.create(Menu.class, MenuVO.class, false);
    private static final BeanCopier beanCopierForMenu = BeanCopier.create(MenuDTO.class, Menu.class, false);

    public static MenuVO toMenuVO(Menu menu) {
        if (menu == null) {
            return null;
        }
        MenuVO menuVO = new MenuVO();
        beanCopierForMenuVO.copy(menu, menuVO, null);
        return menuVO;
    }

    public static Menu toMenu(MenuDTO menuDTO) {
        Menu menu = new Menu();
        beanCopierForMenu.copy(menuDTO, menu, null);
        return menu;
    }

    public static List<MenuVO> toMenuVOList(List<Menu> menuList) {
        if (menuList == null || menuList.isEmpty()) {
            return null;
        }
        List<MenuVO> menuInfoList = new ArrayList<MenuVO>(menuList.size());
        for (Menu menu : menuList) {
            menuInfoList.add(toMenuVO(menu));
        }
        return menuInfoList;
    }

    public static List<Menu> toMenuList(List<MenuDTO> menuDTOList) {
        if (menuDTOList == null || menuDTOList.isEmpty()) {
            return null;
        }
        List<Menu> menuList = new ArrayList<Menu>(menuDTOList.size());
        for (MenuDTO menuDTO : menuDTOList) {
            menuList.add(toMenu(menuDTO));
        }
        return menuList;
    }

    public static QueryResultVO<MenuVO> toQueryResult(QueryResultVO<Menu> queryResult) {
        QueryResultVO<MenuVO> queryResultInfo = new QueryResultVO<MenuVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toMenuVOList(queryResult.getRecords()));
        return queryResultInfo;
    }

    public static List<MenuVO> toTree(List<Menu> adminMenuList) {
        if (!CollectionUtils.isEmpty(adminMenuList)) {
            // 顶级类目
            List<MenuVO> topCategoryList = toMenuVOList(adminMenuList.stream().filter(bean -> bean.getParentId().equals(0)).sorted(Comparator.comparing(Menu::getSortNumber)).collect(Collectors.toList()));
            List<MenuVO> childCategoryList = toMenuVOList(adminMenuList.stream().filter(bean -> !bean.getParentId().equals(0)).collect(Collectors.toList()));
            sort(topCategoryList, childCategoryList);

            return topCategoryList;
        }
        return null;
    }

    private static void sort(List<MenuVO> topCategoryList, List<MenuVO> childCategoryList) {
        List<MenuVO> copyVos = Lists.newCopyOnWriteArrayList(childCategoryList);
        for (MenuVO top : topCategoryList) {
            for (MenuVO child : childCategoryList) {
                if (Objects.equals(top.getId(), child.getParentId())) {
                    top.addChildCategoryList(child);
                    copyVos.remove(child);
                }
            }
        }
        for (MenuVO top : topCategoryList) {
            if (!CollectionUtils.isEmpty(top.getChildCategoryList())) {
                // 子菜单排序
                top.setChildCategoryList(top.getChildCategoryList().stream().sorted(Comparator.comparing(MenuVO::getSortNumber)).collect(Collectors.toList()));
                sort(top.getChildCategoryList(), copyVos);
            }
        }
    }
}
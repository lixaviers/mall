package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.RoleMenu;
import com.suyan.mall.user.req.RoleMenuDTO;
import com.suyan.mall.user.resp.RoleMenuVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class RoleMenuConvertor {

    private static final BeanCopier beanCopierForRoleMenuVO = BeanCopier.create(RoleMenu.class, RoleMenuVO.class, false);
    private static final BeanCopier beanCopierForRoleMenu = BeanCopier.create(RoleMenuDTO.class, RoleMenu.class, false);

    public static RoleMenuVO toRoleMenuVO(RoleMenu roleMenu) {
        if (roleMenu == null) {
            return null;
        }
        RoleMenuVO roleMenuVO = new RoleMenuVO();
        beanCopierForRoleMenuVO.copy(roleMenu, roleMenuVO, null);
        return roleMenuVO;
    }

    public static RoleMenu toRoleMenu(RoleMenuDTO roleMenuDTO) {
        RoleMenu roleMenu = new RoleMenu();
        beanCopierForRoleMenu.copy(roleMenuDTO, roleMenu, null);
        return roleMenu;
    }

    public static List<RoleMenuVO> toRoleMenuVOList(List<RoleMenu> roleMenuList) {
        if (roleMenuList == null || roleMenuList.isEmpty()) {
            return null;
        }
        List<RoleMenuVO> roleMenuInfoList = new ArrayList<RoleMenuVO>(roleMenuList.size());
        for (RoleMenu roleMenu : roleMenuList) {
            roleMenuInfoList.add(toRoleMenuVO(roleMenu));
        }
        return roleMenuInfoList;
    }

    public static List<RoleMenu> toRoleMenuList(List<RoleMenuDTO> roleMenuDTOList) {
        if (roleMenuDTOList == null || roleMenuDTOList.isEmpty()) {
            return null;
        }
        List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>(roleMenuDTOList.size());
        for (RoleMenuDTO roleMenuDTO : roleMenuDTOList) {
            roleMenuList.add(toRoleMenu(roleMenuDTO));
        }
        return roleMenuList;
    }

    public static QueryResultVO<RoleMenuVO> toQueryResult(QueryResultVO<RoleMenu> queryResult) {
        QueryResultVO<RoleMenuVO> queryResultInfo = new QueryResultVO<RoleMenuVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toRoleMenuVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
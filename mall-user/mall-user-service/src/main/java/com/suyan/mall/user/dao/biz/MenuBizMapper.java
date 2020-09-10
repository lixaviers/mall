package com.suyan.mall.user.dao.biz;

import com.suyan.mall.user.dao.MenuMapper;
import com.suyan.mall.user.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuBizMapper extends MenuMapper {

    List<Menu> getAdminMenu(@Param("adminId") Long adminId);

    List<Integer> getRoleMenuIds(@Param("roleId") Long roleId);

}
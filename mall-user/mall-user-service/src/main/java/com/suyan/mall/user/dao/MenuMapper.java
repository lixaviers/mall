package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.Menu;
import com.suyan.mall.user.model.MenuExample;
import com.suyan.mall.user.req.MenuQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MenuMapper {
    
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Menu selectByPrimaryKeyForUpdate(Long id);

    List<Menu> queryMenu(MenuQueryDTO menuQuery);

    int insertBatch(@Param("modelList") List<Menu> modelList);

    
    List<Menu> selectByParentId(@Param("parentId") Long parentId);


}
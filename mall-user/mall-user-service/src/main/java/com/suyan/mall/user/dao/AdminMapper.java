package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.Admin;
import com.suyan.mall.user.model.AdminExample;
import com.suyan.mall.user.req.AdminQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminMapper {
    
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    Admin selectByPrimaryKeyForUpdate(Long id);

    List<Admin> queryAdmin(AdminQueryDTO adminQuery);

    int insertBatch(@Param("modelList") List<Admin> modelList);


    Admin selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);    
    
    List<Admin> selectByUserName(@Param("userName") String userName);


}
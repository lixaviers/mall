package com.suyan.mall.user.dao;

import com.suyan.mall.user.model.User;
import com.suyan.mall.user.model.UserExample;
import com.suyan.mall.user.req.UserQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id
    );

    User selectByPrimaryKeyForUpdate(Long id);

    List<User> queryUser(UserQueryDTO userQuery);

    int insertBatch(@Param("modelList") List<User> modelList);


    User selectByUniqueUserId(@Param("uniqueUserId") String uniqueUserId);

    List<User> selectByUserName(@Param("userName") String userName);


}
/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.convertor;

import com.suyan.mall.user.model.User;
import com.suyan.mall.user.req.UserDTO;
import com.suyan.mall.user.resp.UserVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 * @jdk 1.8
 * @Version: <1.0>
 */
public abstract class UserConvertor {

    private static final BeanCopier beanCopierForUserVO = BeanCopier.create(User.class, UserVO.class, false);
    private static final BeanCopier beanCopierForUserInfoVO = BeanCopier.create(User.class, UserInfoVO.class, false);
    private static final BeanCopier beanCopierForUser = BeanCopier.create(UserDTO.class, User.class, false);

    public static UserVO toUserVO(User user) {
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        beanCopierForUserVO.copy(user, userVO, null);
        return userVO;
    }

    public static UserInfoVO toUserInfoVO(User user) {
        if (user == null) {
            return null;
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        beanCopierForUserInfoVO.copy(user, userInfoVO, null);
        return userInfoVO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        beanCopierForUser.copy(userDTO, user, null);
        return user;
    }

    public static List<UserVO> toUserVOList(List<User> userList) {
        if (userList == null || userList.isEmpty()) {
            return null;
        }
        List<UserVO> userInfoList = new ArrayList<UserVO>(userList.size());
        for (User user : userList) {
            userInfoList.add(toUserVO(user));
        }
        return userInfoList;
    }

    public static List<User> toUserList(List<UserDTO> userDTOList) {
        if (userDTOList == null || userDTOList.isEmpty()) {
            return null;
        }
        List<User> userList = new ArrayList<User>(userDTOList.size());
        for (UserDTO userDTO : userDTOList) {
            userList.add(toUser(userDTO));
        }
        return userList;
    }

    public static QueryResultVO<UserVO> toQueryResult(QueryResultVO<User> queryResult) {
        QueryResultVO<UserVO> queryResultInfo = new QueryResultVO<UserVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toUserVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}
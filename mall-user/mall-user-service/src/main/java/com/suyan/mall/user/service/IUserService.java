package com.suyan.mall.user.service;

import com.suyan.mall.user.req.UserDTO;
import com.suyan.mall.user.req.UserQueryDTO;
import com.suyan.mall.user.resp.UserVO;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.query.QueryResultVO;

public interface IUserService {

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(Long id);

    /**
     * 创建用户
     *
     * @param userDTO
     * @return
     */
    Long createUser(UserDTO userDTO);

    /**
     * 更新用户
     *
     * @param userDTO
     * @return
     */
    int updateUser(UserDTO userDTO);

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     */
    UserVO getUser(Long id);

    /**
     * 分页查询用户信息
     *
     * @param userQueryDTO
     * @return
     */
    QueryResultVO<UserVO> queryUser(UserQueryDTO userQueryDTO);


    /**
     * 用户登录
     *
     * @param userDTO
     * @return
     */
    UserInfoVO userLogin(UserDTO userDTO);

    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    UserInfoVO userRegister(UserDTO userDTO);

    /**
     * 店铺登录
     *
     * @param userDTO
     * @return
     */
    UserInfoVO shopLogin(UserDTO userDTO);

    /**
     * 店铺用户注册
     * @param userDTO
     * @return
     */
    UserInfoVO shopRegister(UserDTO userDTO);

}

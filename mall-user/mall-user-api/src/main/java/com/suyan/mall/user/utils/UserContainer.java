/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.utils;

import com.suyan.mall.user.resp.b.UserInfoVO;

/**
 * 用户容器
 */
public class UserContainer {

    /**
     * 用户信息线程
     */
    public static final ThreadLocal<UserInfoVO> USER_INFO_VO_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 设置用户信息
     *
     * @param userInfoVO
     */
    public static void putUserInfo(UserInfoVO userInfoVO) {
        USER_INFO_VO_THREAD_LOCAL.set(userInfoVO);
    }

    /**
     * 移除用户信息
     */
    public static void removeUserInfo() {
        USER_INFO_VO_THREAD_LOCAL.remove();
    }


}

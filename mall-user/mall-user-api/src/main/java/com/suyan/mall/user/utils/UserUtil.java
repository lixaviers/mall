/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.utils;

import com.suyan.mall.user.constants.RedisKey;
import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.utils.JsonUtil;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class UserUtil {

    /**
     * 获取用户信息
     *
     * @return
     */
    public static UserInfoVO getUser(String platform) {
        UserInfoVO userInfoVO = UserContainer.USER_INFO_VO_THREAD_LOCAL.get();
        if (Objects.isNull(userInfoVO)) {
            userInfoVO = UserSessionUtil.getUserInfo(platform, null);
            UserContainer.putUserInfo(userInfoVO);
        }
        return userInfoVO;
    }

    public static UserInfoVO getShopUser() {
        return getUser(SystemPlatformEnum.B.getCode());
    }

    public static UserInfoVO getUser() {
        return getUser(SystemPlatformEnum.C.getCode());
    }

    public static UserInfoVO getAdmin() {
        return getUser(SystemPlatformEnum.E.getCode());
    }

    /**
     * 设置用户信息
     *
     * @param userInfoVO
     * @param token
     */
    public static void setRedisUser(UserInfoVO userInfoVO, String token, String platform) {
        userInfoVO.setSessionId(token);
        String key = RedisKey.getTokenKey(token, platform);
        // token 用户信息
        String userInfoStr = JsonUtil.toJsonStringNullValue(userInfoVO);
        // 设置token的有效时间为4小时
        RedisUtil.set(key, userInfoStr, 4, TimeUnit.HOURS);
    }


}

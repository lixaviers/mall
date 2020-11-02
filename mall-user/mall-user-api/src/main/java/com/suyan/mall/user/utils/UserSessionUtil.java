/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.utils;

import com.alibaba.fastjson.JSON;
import com.suyan.mall.user.constants.ApiConstants;
import com.suyan.mall.user.constants.RedisKey;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.utils.JsonUtil;
import com.suyan.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserSessionUtil {

    private static final Logger logger = LoggerFactory.getLogger(UserSessionUtil.class);

    private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        UserSessionUtil.redisTemplate = redisTemplate;
    }

    public static UserInfoVO getUserInfo(String systemPlatform, String token) {
        Long startTime = System.currentTimeMillis();
        String sessionId = token;
        if (StringUtils.isEmpty(token)) {
            sessionId = getSessionId();
        }
        UserInfoVO userInfoVO = getUserInfoBySessionId(sessionId, systemPlatform);
        logger.info("get {} user info from redis end,user:{},timeUsed:{}ms", systemPlatform, JsonUtil.toJsonString(userInfoVO), System.currentTimeMillis() - startTime);
        return userInfoVO;
    }


    public static String getSessionId() {
        HttpServletRequest request = getCurrentRequest();
        String sessionId = request.getHeader(ApiConstants.HEADER_KEY);
        if (StringUtils.isNotEmpty(sessionId)) {
            logger.info("sessionId from header {}", ApiConstants.HEADER_KEY);
            return sessionId;
        }
        return null;
    }

    private static UserInfoVO getUserInfoBySessionId(String sessionId, String systemPlatform) {
        logger.info("sessionId={}", sessionId);
        if (StringUtils.isNotEmpty(sessionId)) {
            String value = String.valueOf(redisTemplate.opsForValue().get(RedisKey.getTokenKey(sessionId, systemPlatform)));
            if (StringUtils.isNotEmpty(value)) {
                return JSON.parseObject(value, UserInfoVO.class);
            }
            logger.error("根据token没有拿到用户信息的情况，请查明原因，token={}", sessionId);
        }
        return null;
    }


    public static HttpServletRequest getCurrentRequest() {
        return RequestContextHolder.currentRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }


}

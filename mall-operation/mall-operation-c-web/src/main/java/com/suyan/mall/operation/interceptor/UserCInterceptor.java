/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.interceptor;

import com.suyan.annotation.PassLogin;
import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserContainer;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户拦截器
 */
@Slf4j
@Component
public class UserCInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            // 打印日志
            log.info("requestUri：{},contextPath：{},parameterNames：{}", request.getRequestURI(), request.getContextPath(), JsonUtil.toJsonString(request.getParameterMap()));

            if (!supports((HandlerMethod) handler)) {
                return true;
            }

            UserInfoVO userInfo = UserUtil.getUser(SystemPlatformEnum.C.getCode());
            if (userInfo == null) {
                returnErrorJson(response, JsonUtil.toJsonStringNullValue(Result.newError(ResultCode.NO_LOGGED_IN)));
                return false;
            }
            if (!SystemPlatformEnum.C.equals(userInfo.getSystemPlatform())) {
                returnErrorJson(response, JsonUtil.toJsonStringNullValue(Result.newError(ResultCode.SESSION_INVALID_ERROR)));
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            returnErrorJson(response, JsonUtil.toJsonStringNullValue(Result.newError(ResultCode.SYS_ERROR)));
            return false;
        }

    }

    /**
     * 是否拦截
     *
     * @return {@code boolean} 拦截，不拦截
     */
    private boolean supports(HandlerMethod method)
            throws Exception {
        return method.getMethodAnnotation(PassLogin.class) == null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        UserContainer.removeUserInfo();
    }


    public void returnErrorJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            log.error("response error", e);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
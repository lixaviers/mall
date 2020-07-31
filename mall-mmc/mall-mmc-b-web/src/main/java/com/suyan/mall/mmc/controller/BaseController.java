package com.suyan.mall.mmc.controller;

import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class BaseController {

    public HttpServletRequest getRequest() {
        return RequestContextHolder.currentRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse() {
        return RequestContextHolder.getRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public HttpSession getSession() {
        HttpServletRequest request = getRequest();
        HttpSession session = request == null ? null : request.getSession();
        return session;
    }

    /**
     * 获取登录用户
     *
     * @return
     */
    protected UserInfoVO getUser() {
        return UserUtil.getUser(SystemPlatformEnum.B.getCode());
    }

}

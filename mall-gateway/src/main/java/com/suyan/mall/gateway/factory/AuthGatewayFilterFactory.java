/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.gateway.factory;

import com.suyan.mall.gateway.utils.IpUtil;
import com.suyan.mall.gateway.utils.ResponseUtil;
import com.suyan.mall.user.constants.ApiConstants;
import com.suyan.mall.user.enums.SystemPlatformEnum;
import com.suyan.mall.user.resp.b.UserInfoVO;
import com.suyan.mall.user.utils.UserSessionUtil;
import com.suyan.mall.user.utils.UserUtil;
import com.suyan.result.Result;
import com.suyan.result.ResultCode;
import com.suyan.utils.CollectionsUtil;
import com.suyan.utils.DateUtils;
import com.suyan.utils.JsonUtil;
import com.suyan.utils.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Date;
import java.util.List;


/**
 * 权限
 * 1.验证是否登录
 * <p>从header/cookie中获取token</p>
 * 2.验证是否有相应的api权限
 */
@Component
@Slf4j
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    private static final String REQUEST_TIME_BEGIN = "asgRequestTimeBegin";

    public AuthGatewayFilterFactory() {
        super(Config.class);
    }

    PathMatcher pathMatcher = new AntPathMatcher();

    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            // 当前时间
            Date nowDate = new Date();

            ServerHttpRequest request = exchange.getRequest();
            URI uri = request.getURI();
            // 请求路径
            String path = uri.getPath();

            // 忽略验证登录的接口
            String loginIgnorePath = config.loginIgnorePath;
            if (StringUtils.isNotBlank(loginIgnorePath)) {
                String[] pathArray = loginIgnorePath.split("\\|");
                for (int i = 0; i < pathArray.length; i++) {
                    if (this.pathMatcher.match(pathArray[i], path)) {
                        return chain.filter(exchange);
                    }
                }
            }

            String ip = IpUtil.getIp(request);
            HttpHeaders headers = request.getHeaders();

            // 从header中获取token
            List<String> authorizations = headers.get(ApiConstants.HEADER_KEY);
            // token
            String token = null;
            if (CollectionsUtil.isNotEmpty(authorizations)) {
                token = authorizations.get(0);
            }
            if (StringUtils.isBlank(token)) {
                // 未登录
                return ResponseUtil.returnAuthFail(exchange, Result.newError(ResultCode.NO_LOGGED_IN));
            }

            // 判断端
            SystemPlatformEnum systemPlatform;
            if (path.contains("/c/") || path.contains("/C/")) {
                // C端请求
                systemPlatform = SystemPlatformEnum.C;
            } else if (path.contains("/b/") || path.contains("/B/")) {
                // B端请求
                systemPlatform = SystemPlatformEnum.B;
            } else {
                // M端请求
                systemPlatform = SystemPlatformEnum.E;
            }

            UserInfoVO userInfoVO = UserSessionUtil.getUserInfo(systemPlatform.getCode(), token);
            // 根据token获取用户信息
            log.info("根据token获取用户信息token={},systemPlatform={},result={}", token, systemPlatform.getCode(), JsonUtil.toJsonStringNullValue(userInfoVO));
            if (userInfoVO == null) {
                return ResponseUtil.returnAuthFail(exchange, Result.newError(ResultCode.SESSION_INVALID_ERROR));
            }

            if (!userInfoVO.getSystemPlatform().equals(systemPlatform)) {
                // 登录失效
                return ResponseUtil.returnAuthFail(exchange, Result.newError(ResultCode.SESSION_INVALID_ERROR));
            }

            if (SystemPlatformEnum.B.equals(systemPlatform)) {

                // b端需要验证店铺id是否为空

                // 忽略验证权限的接口
                String authIgnorePath = config.authIgnorePath;
                if (StringUtils.isNotBlank(authIgnorePath)) {
                    String[] pathArray = authIgnorePath.split("\\|");
                    for (int i = 0; i < pathArray.length; i++) {
                        if (this.pathMatcher.match(pathArray[i], path)) {
                            // 有权限，在header添加access key，在header中添加token
                            return addHeaderInfo(exchange, chain, nowDate, request, path, ip, token, userInfoVO, "IgnoreAuthRecord");
                        }
                    }
                }

                if (userInfoVO.getShopId() == null) {
                    // 请选择店铺
                    return ResponseUtil.returnAuthFail(exchange, Result.newError(ResultCode.USER_SHOP_ERROR));
                }

            }

            // 设置用户信息
            UserUtil.setRedisUser(userInfoVO, token, systemPlatform.getCode());
            // 在header添加access key，在header中添加token
            return addHeaderInfo(exchange, chain, nowDate, request, path, ip, token, userInfoVO, "AuthRecord");

        };
    }


    private Mono<Void> addHeaderInfo(ServerWebExchange exchange, GatewayFilterChain chain, Date nowDate, ServerHttpRequest request,
                                     String path, String ip, String token, UserInfoVO userInfoVO, String info) {
        ServerHttpRequest serverHttpRequest = null;
        request.mutate().build();
        ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
        build.getAttributes().put(REQUEST_TIME_BEGIN, new Date());

        return chain.filter(build).then(
                Mono.fromRunnable(() -> {
                    Date time = build.getAttribute(REQUEST_TIME_BEGIN);
                    Opt opt = new Opt(userInfoVO.getId(), userInfoVO.getUserName(), userInfoVO.getNickName(), ip, path,
                            DateUtils.dateToString(nowDate, DateUtils.DATE_TO_STRING_DETAIAL_PATTERN));
                    if (time != null) {
                        opt.processingTime = (System.currentTimeMillis() - time.getTime()) + "ms";
                        opt.startTime = DateUtils.dateToString(time, DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);
                    }
                    // 记录请求日志
                    log.info("{}:{}", info, JsonUtil.toJsonStringNullValue(opt));
                })
        );
    }

    class Opt {
        public Long userId;
        public String userCode;
        public String userName;
        public String ip;
        public String path;
        // 请求时间
        public String requestTime;
        // 验证通过后时间
        public String startTime;
        // 处理时间
        public String processingTime;

        public Opt(Long userId, String userCode, String userName, String ip, String path, String requestTime) {
            this.userId = userId;
            this.userCode = userCode;
            this.userName = userName;
            this.ip = ip;
            this.path = path;
            this.requestTime = requestTime;
        }
    }


    @Data
    public static class Config {
        // 忽略验证登录的接口
        private String loginIgnorePath;
        // 忽略验证权限的接口
        private String authIgnorePath;

    }

}

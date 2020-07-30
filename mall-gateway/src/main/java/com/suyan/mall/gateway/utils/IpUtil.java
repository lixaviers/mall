package com.suyan.mall.gateway.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@Slf4j
public class IpUtil {

    public static String getIp(ServerHttpRequest request) {
        Map<String, String> headers = request.getHeaders().toSingleValueMap();

        String ip = (String) headers.get("x-forwarded-for");
        log.debug("get ip from x-forwarded-for {}", ip);

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = (String) headers.get("X-Forwarded-For");
            log.debug("get ip from X-Forwarded-For {}", ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = (String) headers.get("Proxy-Client-IP");
            log.debug("get ip from Proxy-Client-IP {}", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = (String) headers.get("WL-Proxy-Client-IP");
            log.debug("get ip from WL-Proxy-Client-IP {}", ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddress().getHostString();
            log.debug("get ip from request.getRemoteAddress().getHostString() {}", ip);
            if (ip.equals("127.0.0.1")) {

                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    log.debug("get ip from InetAddress.getLocalHost() {}", ip);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
                log.debug("get ip from inet.getHostAddress() {}", ip);
            }
        }

        if (ip != null && ip.length() > 15 &&
                ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }

        return ip;
    }
}


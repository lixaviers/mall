package com.suyan.mall.user.constants;

import com.suyan.utils.StringUtils;

public class RedisKey {

    public static final String TOKEN = "token:";
    public static final String MENU = "menu:";

    public static String getTokenKey(String token, String systemPlatform) {
        if (StringUtils.isEmpty(token)) {
            return "";
        }
        StringBuilder sbBuilder = new StringBuilder(80);
        sbBuilder.append(Constant.REDIS_PREFIX);
        sbBuilder.append(TOKEN);
        sbBuilder.append(systemPlatform);
        sbBuilder.append(":");
        sbBuilder.append(token);
        return sbBuilder.toString();
    }

    /**
     * 获取手机验证码key
     *
     * @param mobile 手机号
     * @param source 来源
     * @return
     * @see com.suyan.mall.user.enums.SmsSourceEnum
     */
    public static String getMobileCodeKey(String mobile, String source) {
        if (StringUtils.isEmpty(mobile)) {
            return "";
        }
        StringBuilder sbBuilder = new StringBuilder(80);
        sbBuilder.append(Constant.REDIS_PREFIX);
        sbBuilder.append("mobile:");
        sbBuilder.append(mobile);
        sbBuilder.append(":source:");
        sbBuilder.append(source);
        return sbBuilder.toString();
    }


}
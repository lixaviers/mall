package com.suyan.mall.user.enums;


import com.suyan.utils.StringUtils;

/**
 * @Comments: 短信来源
 */
public enum SmsSourceEnum {
    STORE_LOGIN            ("storeLogin"),// 商户登录
    STORE_REGISTER         ("storeRegister"),// 商户注册
    ;

    private String value;

    SmsSourceEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean exists(String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        for (SmsSourceEnum element : SmsSourceEnum.values()) {
            if (element.value.equals(s)) {
                return true;
            }
        }
        return false;
    }

}

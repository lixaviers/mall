package com.suyan.mall.message.constant;

/**
 * 短信发送供应商
 */
public enum SmsSendProviderEnum {

    TEST("test", "测试"),

    ;

    private String value;
    private String desc;

    SmsSendProviderEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static boolean exists(String s) {
        for (SmsSendProviderEnum element : SmsSendProviderEnum.values()) {
            if (element.value.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static String getDescByValue(String value) {
        if (value == null) {
            return "";
        }
        for (SmsSendProviderEnum element : SmsSendProviderEnum.values()) {
            if (element.value.equals(value)) {
                return element.desc;
            }
        }
        return "";
    }
}

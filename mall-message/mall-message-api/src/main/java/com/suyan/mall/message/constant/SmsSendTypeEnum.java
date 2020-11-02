/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.constant;

/**
 * 短信发送状态
 */
public enum SmsSendTypeEnum {
    VER_CODE              ((byte) 1, "验证码类"),
    MARKETING             ((byte) 2, "营销类"),
    ;

    private byte value;
    private String desc;

    SmsSendTypeEnum(byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static boolean exists(Byte status) {
        if (status == null) {
            return false;
        }
        byte s = status;
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (SmsSendTypeEnum element : SmsSendTypeEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val != null && val == this.value;
    }

    public static String getDescByValue(Byte value) {
        if (value == null) {
            return "";
        }
        for (SmsSendTypeEnum element : SmsSendTypeEnum.values()) {
            if (element.value == value) {
                return element.desc;
            }
        }
        return "";
    }
}

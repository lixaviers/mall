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
public enum SmsSendStatusEnum {
    FAILURE             ((byte) 0, "失败"),
    SUCCESS             ((byte) 1, "成功"),
    UNKNOWN             ((byte) 2, "未知"),
    ;

    private byte value;
    private String desc;

    SmsSendStatusEnum(byte value, String desc) {
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
        for (SmsSendStatusEnum element : SmsSendStatusEnum.values()) {
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
        for (SmsSendStatusEnum element : SmsSendStatusEnum.values()) {
            if (element.value == value) {
                return element.desc;
            }
        }
        return "";
    }
}

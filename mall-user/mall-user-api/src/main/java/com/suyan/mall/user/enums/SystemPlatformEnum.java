/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.enums;

/**
 * 系统平台枚举
 */
public enum SystemPlatformEnum {

    B        ("b", "B端系统"),
    C        ("c", "C端系统"),
    E        ("E", "E端系统"),
    ;

    private String code;
    private String desc;

    SystemPlatformEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SystemPlatformEnum getCode(String code) {
        for (SystemPlatformEnum value : SystemPlatformEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return SystemPlatformEnum.B;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

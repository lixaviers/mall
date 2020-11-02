/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user.enums;

/**
 * @Comments: 用户来源
 */
public enum UserSourceEnum {
	SHOP                 ((byte) 1, "商户"),
	USER                 ((byte) 2, "c端用户"),
	;

	private byte value;
	private String desc;

	UserSourceEnum(byte value, String desc){
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
        byte s = status.byteValue();
        return exists(s);
    }

    public static boolean exists(byte s) {
        for (UserSourceEnum element : UserSourceEnum.values()) {
            if (element.value == s) {
                return true;
            }
        }
        return false;
    }

    public boolean equal(Byte val) {
        return val == null ? false : val.byteValue() == this.value;
    }

	public static String getDescByValue(Byte value) {
		if (value == null) {
			return "";
		}
		for (UserSourceEnum element : UserSourceEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}

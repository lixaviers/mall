/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.enums;

/**
 * @Comments: 商品类目属性类型
 */
public enum GoodsCategoryAttributeTypeEnum {
	ENUM                     ((byte) 1, "枚举"),
	INPUT                    ((byte) 2, "输入"),
	;

	private byte value;
	private String desc;

	GoodsCategoryAttributeTypeEnum(byte value, String desc){
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
        for (GoodsCategoryAttributeTypeEnum element : GoodsCategoryAttributeTypeEnum.values()) {
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
		for (GoodsCategoryAttributeTypeEnum element : GoodsCategoryAttributeTypeEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}

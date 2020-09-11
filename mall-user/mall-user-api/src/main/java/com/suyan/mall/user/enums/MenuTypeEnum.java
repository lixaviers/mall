package com.suyan.mall.user.enums;

/**
 * @Comments: 菜单类型
 */
public enum MenuTypeEnum {
	PAGE                    ((byte) 1, "页面"),
	API                     ((byte) 2, "接口"),
	BUTTON                  ((byte) 3, "按钮"),
	;

	private byte value;
	private String desc;

	MenuTypeEnum(byte value, String desc){
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
        for (MenuTypeEnum element : MenuTypeEnum.values()) {
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
		for (MenuTypeEnum element : MenuTypeEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}

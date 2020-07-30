package com.suyan.mall.mmc.enums;

/**
 * @Comments: 状态
 */
public enum CommonStatusMmcEnum {
	SAVED                        ((byte) 1, "已保存"),
	ONGOING                      ((byte) 2, "进行中"),
	STOPED                       ((byte) 3, "已中止"),
	CANCELED                     ((byte) 4, "已取消"),
	ENDED                        ((byte) 5, "已结束"),
	;

	private byte value;
	private String desc;

	CommonStatusMmcEnum(byte value, String desc){
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
        for (CommonStatusMmcEnum element : CommonStatusMmcEnum.values()) {
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
		for (CommonStatusMmcEnum element : CommonStatusMmcEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}

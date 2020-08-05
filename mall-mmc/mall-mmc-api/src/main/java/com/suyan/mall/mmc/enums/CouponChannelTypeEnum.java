package com.suyan.mall.mmc.enums;

/**
 * @Comments: 促销类型
 */
public enum CouponChannelTypeEnum {
    MALL                        ((byte) 1, "商城"),
    APP                         ((byte) 2, "APP"),
    APPLET                      ((byte) 3, "小程序"),
    NEW_USER                    ((byte) 4, "新用户注册"),
    ;

    private byte value;
    private String desc;

    CouponChannelTypeEnum(byte value, String desc) {
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
        for (CouponChannelTypeEnum element : CouponChannelTypeEnum.values()) {
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
        for (CouponChannelTypeEnum element : CouponChannelTypeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}

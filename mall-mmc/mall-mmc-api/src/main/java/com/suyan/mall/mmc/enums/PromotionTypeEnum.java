package com.suyan.mall.mmc.enums;

/**
 * @Comments: 促销类型
 */
public enum PromotionTypeEnum {
    CASH_COUPON                 ((byte) 1, (byte) 1, "现金券"),
    FULL_CUT_COUPON             ((byte) 2, (byte) 1, "满减券"),
    EACH_FULL_CUT_COUPON        ((byte) 3, (byte) 1, "每满减券"),
    DISCOUNT_COUPON             ((byte) 4, (byte) 1, "满折券"),
    FULL_LADDER_COUPON          ((byte) 5, (byte) 1, "阶梯满减券"),
    ;

    private byte value;
    private byte type;
    private String desc;

    PromotionTypeEnum(byte value, byte type, String desc) {
        this.value = value;
        this.type = type;
        this.desc = desc;
    }

    public byte getValue() {
        return value;
    }

    public byte getType() {
        return type;
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
        for (PromotionTypeEnum element : PromotionTypeEnum.values()) {
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
        for (PromotionTypeEnum element : PromotionTypeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}

package com.suyan.mall.mmc.enums;

/**
 * @Comments: 促销使用类型
 */
public enum PromotionUseTypeEnum {
    CASH_COUPON                 ((byte) 1, PromotionTypeEnum.COUPON.getValue(), "现金券"),
    FULL_CUT_COUPON             ((byte) 2, PromotionTypeEnum.COUPON.getValue(), "满减券"),
    EACH_FULL_CUT_COUPON        ((byte) 3, PromotionTypeEnum.COUPON.getValue(), "每满减券"),
    DISCOUNT_COUPON             ((byte) 4, PromotionTypeEnum.COUPON.getValue(), "满折券"),
    FULL_LADDER_COUPON          ((byte) 5, PromotionTypeEnum.COUPON.getValue(), "阶梯满减券"),
    ;

    private byte value;
    private byte type;
    private String desc;

    PromotionUseTypeEnum(byte value, byte type, String desc) {
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
        for (PromotionUseTypeEnum element : PromotionUseTypeEnum.values()) {
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
        for (PromotionUseTypeEnum element : PromotionUseTypeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}

package com.suyan.mall.mmc.enums;

/**
 * @Comments: 促销类型
 */
public enum PromotionTypeEnum {
    COUPON                    ((byte) 1, "优惠券"),
    SUB_PROMOTION             ((byte) 2, "订单促销"),
    BARGAIN                   ((byte) 3, "砍价"),
    ;

    private byte value;
    private String desc;

    PromotionTypeEnum(byte value, String desc) {
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

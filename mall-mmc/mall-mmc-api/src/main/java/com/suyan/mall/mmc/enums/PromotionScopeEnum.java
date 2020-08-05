package com.suyan.mall.mmc.enums;

/**
 * @Comments: 促销使用范围
 */
public enum PromotionScopeEnum {
    SHOP                       ((byte) 1, "全店通用"),
    GOODS_CATEGORY             ((byte) 2, "按商品类目"),
    ;

    private byte value;
    private String desc;

    PromotionScopeEnum(byte value, String desc) {
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
        for (PromotionScopeEnum element : PromotionScopeEnum.values()) {
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
        for (PromotionScopeEnum element : PromotionScopeEnum.values()) {
            if (element.value == value.byteValue()) {
                return element.desc;
            }
        }
        return "";
    }
}

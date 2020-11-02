/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc.enums;

/**
 * @Comments: 促销使用类型
 */
public enum PromotionUseTypeEnum {
    // 优惠券
    CASH_COUPON                              ((byte) 1, "现金券", PromotionTypeEnum.COUPON.getValue()),
    FULL_CUT_COUPON                          ((byte) 2, "满减券", PromotionTypeEnum.COUPON.getValue()),
    EACH_FULL_CUT_COUPON                     ((byte) 3, "每满减券", PromotionTypeEnum.COUPON.getValue()),
    DISCOUNT_COUPON                          ((byte) 4, "满折券", PromotionTypeEnum.COUPON.getValue()),
    FULL_LADDER_COUPON                       ((byte) 5, "阶梯满减券", PromotionTypeEnum.COUPON.getValue()),

    // 订单促销
    FULL_CUT_SUB_PROMOTION                   ((byte) 21, "订单满减", PromotionTypeEnum.SUB_PROMOTION.getValue()),
    EACH_FULL_CUT_SUB_PROMOTION              ((byte) 22, "订单每满减", PromotionTypeEnum.SUB_PROMOTION.getValue()),
    DISCOUNT_SUB_PROMOTION                   ((byte) 23, "订单满折", PromotionTypeEnum.SUB_PROMOTION.getValue()),
    FULL_LADDER_SUB_PROMOTION                ((byte) 24, "订单阶梯满减", PromotionTypeEnum.SUB_PROMOTION.getValue()),
    ;

    private byte value;
    private byte type;
    private String desc;

    PromotionUseTypeEnum(byte value, String desc, byte type) {
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

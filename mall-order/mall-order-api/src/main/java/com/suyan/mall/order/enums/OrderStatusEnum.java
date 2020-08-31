package com.suyan.mall.order.enums;

/**
 * @Comments: 订单状态
 */
public enum OrderStatusEnum {
	PAYMENT                      ((byte) 1, "待付款"),
	DELIVERY                     ((byte) 2, "待发货"),
	TAKE_GOODS                   ((byte) 2, "待收货"),
	EVALUATE                     ((byte) 2, "待评价"),
	COMPLETED                    ((byte) 2, "已完成"),
	REFUND                       ((byte) 2, "退款中"),
	ENDED                        ((byte) 2, "已结束"),
	;

	private byte value;
	private String desc;

	OrderStatusEnum(byte value, String desc){
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
        for (OrderStatusEnum element : OrderStatusEnum.values()) {
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
		for (OrderStatusEnum element : OrderStatusEnum.values()) {
			if (element.value == value.byteValue()) {
				return element.desc;
			}
		}
		return "";
	}
}

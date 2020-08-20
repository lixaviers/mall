package com.suyan.mall.goods.listener;

public enum CanalEventEnum {
    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    ;

    private String value;

    CanalEventEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

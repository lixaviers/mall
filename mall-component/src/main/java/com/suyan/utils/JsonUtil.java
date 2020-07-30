package com.suyan.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtil {

    public static String toJsonString(Object object) {
        return JSON.toJSONString(object);
    }

    public static String toJsonStringNullValue(Object object) {
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }
}

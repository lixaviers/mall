/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
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

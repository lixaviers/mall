package com.suyan.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {

    static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<>();

    @SuppressWarnings("all")
    public static <T> T fastBeanCopy(Object source, TypeReference<T> type) {
        if (source == null) {
            throw new RuntimeException("source object is null!");
        }

        String jsonStr = JSON.toJSONString(source, SerializerFeature.DisableCircularReferenceDetect);
        return JSON.parseObject(jsonStr, type);
    }


    public static <S, T> List<T> fastBeanCopy(List<S> origLst, Class<T> destClz) {
        List<T> destLst = new ArrayList<>();
        if (CollectionsUtil.isEmpty(origLst)) {
            return destLst;
        }
        for (S orig : origLst) {
            T dest = fastBeanCopy(orig, destClz);
            destLst.add(dest);
        }
        return destLst;
    }

    public static void fastBeanCopy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        String key = genKey(source, target);
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(source, target, null);
    }

    public static <S, T> T fastBeanCopy(S source, Class<T> targetClazz) {
        if (source == null) {
            return null;
        }
        T target = null;
        try {
            target = targetClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        fastBeanCopy(source, target);
        return target;
    }

    private static String genKey(Object source, Object target) {
        return source.getClass().getName() + target.getClass().getName();
    }


}

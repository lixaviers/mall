/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ValidateUtil {

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    private final static String MSG = "数据校验出错";

    public ValidateUtil() {
    }

    public static <T> String validate(T t) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, new Class[0]);
        Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<T> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        return null;
    }

    public static <T> String validate(T object, String msg, Class... groups) {
        if (StringUtils.isEmpty(msg)) {
            msg = MSG;
        }
        if (object == null) {
            return msg;
        }
        Set<ConstraintViolation<T>> validator = factory.getValidator().validate(object, groups);
        return validator != null && validator.iterator().hasNext() ? validator.iterator().next().getMessage() : null;
    }

    public static <T> String validate(List<T> object, String msg, Class... groups) {
        if (CollectionsUtil.isEmpty(object)) {
            return msg;
        }
        Iterator<T> iterator = object.iterator();
        while (iterator.hasNext()) {
            T t = iterator.next();
            return validate(t, msg, groups);
        }
        return null;
    }

}

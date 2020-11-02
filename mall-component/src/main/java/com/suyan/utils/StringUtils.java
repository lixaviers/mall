/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.utils;

import com.google.common.base.Preconditions;

import java.util.Random;

/**
 * 字符工具栏
 */
public class StringUtils {

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    public static boolean hasLength(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean hasText(String str) {
        return hasLength(str) && containsText(str);
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>Checks if a CharSequence is empty (""), null or whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace only
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>Checks if a CharSequence is not empty (""), not null and not whitespace only.</p>
     *
     * <p>Whitespace is defined by {@link Character#isWhitespace(char)}.</p>
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is
     * not empty and not null and not whitespace only
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !isBlank(cs);
    }

    private final static String NUMBERS_LETTER = "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String NUMBERS = "0123456789";
    private static Random random = new Random();

    /**
     * 生成length长度的随机码
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        return randomString(length, NUMBERS_LETTER);
    }

    /**
     * 生成length长度的随机码
     *
     * @param length
     * @param source
     * @return
     */
    public static String getRandomString(int length, String source) {
        if (isBlank(source)) {
            return "";
        }
        return randomString(length, source);
    }

    private static String randomString(int length, String source) {
        if (length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(source.length());
            stringBuffer.append(source.charAt(number));
        }
        return stringBuffer.toString();
    }


    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder())
                    .append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).toString();
        }
    }

    /**
     * 从连续数字中生成随机数
     *
     * @param start 开始
     * @param end   结束
     * @return
     */
    public static int getRandomContinuousNumber(int start, int end) {
        if (start >= end) {
            return start;
        }
        return end - new Random().nextInt(end - start + 1);
    }

    private static final int REF_NO_MAX_LENGTH = 100;

    /**
     * 创建mq key
     *
     * @param topic
     * @param tag
     * @param refNo
     * @param body
     * @return
     */
    public static String createMqKey(String topic, String tag, String refNo, String body) {
        String temp = refNo;
        Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotEmpty(topic), "topic is null");
        Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotEmpty(tag), "tag is null");
        Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotEmpty(refNo), "refNo is null");
        Preconditions.checkArgument(org.apache.commons.lang3.StringUtils.isNotEmpty(body), "body is null");

        if (refNo.length() > REF_NO_MAX_LENGTH) {
            temp = org.apache.commons.lang3.StringUtils.substring(refNo, 0, REF_NO_MAX_LENGTH) + "...";
        }
        return topic + "_" + tag + "_" + temp + "-" + body.hashCode();
    }

}

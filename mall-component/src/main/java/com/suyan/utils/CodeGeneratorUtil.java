/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CodeGeneratorUtil {

    private static Random random = new Random();
    private final static String NUMBERS_LETTER = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String NUMBERS_REPEAT = "2345679ABCDEFGHJKMNPQRSTUVWXYZ";
    private final static String NUMBERS = "0123456789";


    /**
     * 生成length长度的随机码
     *
     * @param length
     * @return
     */
    private static String getRandomString(int length, String source) {
        if (length <= 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(source.length());
            sb.append(source.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成用户唯一标识
     *
     * @return
     */
    public static String generateUniqueUserId() {
        return getRandomString(16, NUMBERS_LETTER);
    }

    /**
     * 生成订单号
     *
     * @return
     */
    public static String generateOrderNumber(String uniqueUserId) {
        // 根据用户openId取模
        char[] chars = uniqueUserId.substring(0, 2).toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char aChar : chars) {
            stringBuffer.append((int) aChar);
        }
        String str = stringBuffer.toString();
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }

        LocalDateTime now = LocalDateTime.now();
        String time = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS").format(now);
        String randomString = getRandomString(5, NUMBERS);
        return time + randomString + str;
    }


    /*@Benchmark
    public static String generateOrderNumber(Blackhole blackhole) {
        LocalDateTime now = LocalDateTime.now();
        String time = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(now);
        String randomString = getRandomString(7, NUMBERS);
        String str = time + randomString;
        blackhole.consume(str);
        return str;
    }*/

    public static void main(String[] args) throws Exception {
        System.out.println(generateOrderNumber("TuvnJDAlHPoOG1xA"));
        System.out.println(generateOrderNumber("AuvnJDAlHPoOG1xA"));
        System.out.println(generateOrderNumber("SuvnJDAlHPoOG1xA"));
        System.out.println(generateOrderNumber("CuvnJDAlHPoOG1xA"));
    }

}

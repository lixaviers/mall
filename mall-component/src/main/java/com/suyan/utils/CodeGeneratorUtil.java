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
    public static String generateOrderNumber() {
        LocalDateTime now = LocalDateTime.now();
        String time = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(now);
        String randomString = getRandomString(7, NUMBERS);
        return time + randomString;
    }


    /*@Benchmark
    public static String generateOrderNumber(Blackhole blackhole) {
        LocalDateTime now = LocalDateTime.now();
        String time = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(now);
        String randomString = getRandomString(7, NUMBERS);
        String str = time + randomString;
        blackhole.consume(str);
        return str;
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder().include(CodeGeneratorUtil.class.getSimpleName())
                .warmupIterations(5).measurementIterations(10)
                .mode(Mode.Throughput).forks(3).build();
        new Runner(opt).run();
    }*/

}

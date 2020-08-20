package com.suyan.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {
    /**
     * 年-月-日 显示格式
     */
    public static final String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";
    /**
     * 年-月-日 时:分:秒 显示格式
     */
    // 备注:如果使用大写HH标识使用24小时显示格式,如果使用小写hh就表示使用12小时制格式。
    public static final String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    //2001-07-04 12:08:56:235
    public static final String LOCAL_TIMESTAMP_PATTERN_S = "yyyy-MM-dd HH:mm:ss:SSS";

    public static final String LOCAL_TIMESTAMP_PATTERN = "yyyy/MM/dd HH:mm:ss";
    public static final String LOCAL_DATE_PATTERN = "yyyy/MM/dd";
    public static final String DEFAULT_TIMESTAMP_PATTERN_NO_SYMBOL = "yyyyMMddHHmmss";
    public static final String DEFAULT_TIMESTAMP_PATTERN_NO_SEONCDS = "yyyy-MM-dd HH:mm";
    public static final String DEFAULT_TIMESTAMP_PATTERN_NO_SEONCDS2 = "yyyy-MM-dd HHmm";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
    public static final String DEFAULT_TIME_PATTERN_NO_SEONCDS = "HH:mm";

    //2001-07-04T12:08:56.235-07或2001-07-04T12:08:56.235Z
    public static final String PATTERN_ISO8601_ONELETTER = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
    //2001-07-04T12:08:56.235-0700或2001-07-04T12:08:56.235Z
    public static final String PATTERN_ISO8601_TWOLETTER = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";
    //2001-07-04T12:08:56.235-07:00或2001-07-04T12:08:56.235Z
    public static final String PATTERN_ISO8601_THREELETTER = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    //2001-07-04T12:08:56.235-0700或2001-07-04T12:08:56.235+0000
    public static final String PATTERN_RFC822 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * Date类型转为指定格式的String类型
     *
     * @param source
     * @param pattern
     * @return
     */
    public static String dateToString(Date source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(source);
    }

    /**
     * unix时间戳转为指定格式的String类型
     * System.currentTimeMillis()获得的是是从1970年1月1日开始所经过的毫秒数
     * unix时间戳:是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数,不考虑闰秒
     *
     * @param source
     * @param pattern
     * @return
     */
    public static String timeStampToString(long source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(source * 1000);
        return simpleDateFormat.format(date);
    }

    public static String formatterDateTime(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern(DATE_TO_STRING_DETAIAL_PATTERN).format(localDateTime);
    }

}

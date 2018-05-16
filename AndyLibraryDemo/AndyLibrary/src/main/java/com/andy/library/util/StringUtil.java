package com.andy.library.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by luofan on 2018/5/16.
 */

public final class StringUtil {

    public static final String YMD = "yyyy-MM-dd";
    public static final String YMD_HM = "yyyy-MM-dd hh:mm";
    public static final String YMD_HMS = "yyyy-MM-dd hh:mm:ss";

    /**
     * 获取格式化时间
     *
     * @param time 时间毫秒
     * @return
     */
    public static String getFormatTime(long time) {
        return getFormatTime(time, YMD);
    }

    /**
     * 获取格式化时间
     *
     * @param time    时间毫秒
     * @param pattern 时间格式
     * @return
     */
    public static String getFormatTime(long time, String pattern) {
        Date date = new Date();
        date.setTime(time);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.CHINA);
        return formatter.format(date);
    }

    /**
     * 转换时间格式
     *
     * @param oldTime        旧时间字符串
     * @param oldTimePattern 旧时间格式
     * @param newTimePattern 新时间格式
     * @return
     */
    public static String convertTime(String oldTime, String oldTimePattern, String newTimePattern) {
        DateFormat oldDate = new SimpleDateFormat(oldTimePattern, Locale.CHINA);
        DateFormat newDate = new SimpleDateFormat(newTimePattern, Locale.CHINA);
        try {
            Date date = oldDate.parse(oldTime);
            return newDate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return oldTimePattern;
    }

    /**
     * 获取时间(毫秒)
     *
     * @param timeString 时间字符串
     * @param pattern    时间格式
     * @return the number of milliseconds
     */
    public static long getTime(String timeString, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern, Locale.CHINA);
        try {
            Date date = dateFormat.parse(timeString);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

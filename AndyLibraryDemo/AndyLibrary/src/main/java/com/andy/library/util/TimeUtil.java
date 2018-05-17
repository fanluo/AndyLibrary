package com.andy.library.util;

import com.blankj.utilcode.constant.TimeConstants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by luofan on 2018/5/16.
 */

public class TimeUtil {

    public static final int MSEC = 1;
    public static final int SEC = 1000;
    public static final int MIN = 60000;
    public static final int HOUR = 3600000;
    public static final int DAY = 86400000;

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
    public static String convertTimeForm(String oldTime, String oldTimePattern, String newTimePattern) {
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

    /**
     * 是否为今天
     *
     * @param timeString 时间字符串
     * @param pattern    时间格式
     * @return
     */
    public static boolean isToday(String timeString, String pattern) {
        return isToday(getTime(timeString, pattern));
    }

    /**
     * 是否为今天
     *
     * @param millis 毫秒
     * @return
     */
    public static boolean isToday(final long millis) {
        long time = getTodayTime();
        return millis >= time && millis < time + TimeConstants.DAY;
    }

    private static long getTodayTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

}

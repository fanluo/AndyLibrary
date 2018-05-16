package com.andy.library.util;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by luofan on 2018/5/16.
 */

public final class StringUtil {

    public static final String MONEY_PATTERN_1 = "##0.00";
    public static final String MONEY_PATTERN_2 = ",##0.00";
    public static final String MONEY_PATTERN_3 = "##0.##";

    public static String getFormatMoney(String money, String pattern) {
        //构造方法的字符格式这里如果小数不足2位,会以0补足
        DecimalFormat format = new DecimalFormat(pattern);
        return format.format(money);
    }

    public static String getFormatMoney(String money) {
        //构造方法的字符格式这里如果小数不足2位,会以0补足
        DecimalFormat format = new DecimalFormat(MONEY_PATTERN_1);
        return format.format(money);
    }

    public static String getFormatMoney(double money) {
        //构造方法的字符格式这里如果小数不足2位,会以0补足
        DecimalFormat format = new DecimalFormat(MONEY_PATTERN_1);
        return format.format(money);
    }

    public static String getFormatMoney(double money, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        return format.format(money);
    }

    public static String getHidePhoneNum(String phoneNum) {
        //$1代表括号1里面的内容，$2代表括号2里面的内容，中间需要替换的没有括号
        return phoneNum.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2");
    }

    public static String getHideBankCardNum(String bankCardNum) {
        //$1代表括号1里面的内容，$2代表括号2里面的内容，中间需要替换的没有括号
        return bankCardNum.replaceAll("(\\d{4})\\d*(\\d{4})", "$1****$2");
    }

    public static String getHideString(String str, int start, int end) {
        //$1代表括号1里面的内容，$2代表括号2里面的内容，中间需要替换的没有括号
        String format = "(\\d{%1$d})\\d*(\\d{%2$d})";
        String regex = String.format(Locale.CHINA, format, start, end);
        return str.replaceAll(regex, "$1****$2");
    }

}

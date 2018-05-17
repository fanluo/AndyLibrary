package com.andy.library.util;

import android.text.TextUtils;

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
        if (TextUtils.isEmpty(money) || !TextUtils.isDigitsOnly(money)) {
            money = "0";
        }
        DecimalFormat format = new DecimalFormat(pattern);
        return format.format(Double.valueOf(money));
    }

    public static String getFormatMoney(String money) {
        return getFormatMoney(money, MONEY_PATTERN_1);
    }

    public static String getFormatMoney(double money) {
        return getFormatMoney(money, MONEY_PATTERN_1);
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

/*************************************************************
 * File: NumberUtil.java
 * Copyright (c) 2014 860613.com
 * Author: Huang Shaobin
 * Email: Shaobin.Software@gmail.com Shaobin_Software@163.com 
 * Date: 2018年7月12日
 * Description: 
 ************************************************************/

package com.learn.mengye.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 * @Description
 * @date 2018/11/12
 */
public class NumberUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtil.class);

    public static String format(byte value) {
        return NumberUtil.format(value, 2);
    }

    public static String format(byte... values) {
        final int length = values == null ? 0 : values.length;
        final StringBuilder builder = new StringBuilder(length * 2);
        for (int index = 0; index < length; index++) {
            builder.append(NumberUtil.format(values[index]));
        }
        return builder.toString();
    }

    public static String format(int value) {
        return NumberUtil.format(value, 8);
    }

    public static String format(int... values) {
        final int length = values == null ? 0 : values.length;
        final StringBuilder builder = new StringBuilder(length * 2);
        for (int index = 0; index < length; index++) {
            builder.append(NumberUtil.format(values[index]));
        }
        return builder.toString();
    }

    public static String format(long value) {
        return NumberUtil.format(value, 16);
    }

    public static String format(long... values) {
        final int length = values == null ? 0 : values.length;
        final StringBuilder builder = new StringBuilder(length * 2);
        for (int index = 0; index < length; index++) {
            builder.append(NumberUtil.format(values[index]));
        }
        return builder.toString();
    }

    private static String format(long value, int length) {
        final String hexString = Long.toHexString(value);
        final StringBuilder builder = new StringBuilder(length);
        for (int index = 0; index < hexString.length() && length - index > 0; index++) {
            builder.insert(0, hexString.charAt(hexString.length() - index - 1));
        }
        while (length - builder.length() > 0) {
            builder.insert(0, '0');
        }
        return builder.toString();
    }

    public static String format(short... values) {
        final int length = values == null ? 0 : values.length;
        final StringBuilder builder = new StringBuilder(length * 2);
        for (int index = 0; index < length; index++) {
            builder.append(NumberUtil.format(values[index]));
        }
        return builder.toString();
    }

    public static String format(short value) {
        return NumberUtil.format(value, 4);
    }

    public static int parse(String format) {
        try {
            return Integer.parseUnsignedInt(format, 16);
        } catch (Exception e) {
            NumberUtil.LOGGER.warn(e.getMessage(), e);
            return 0;
        }
    }

    /**
     * 排行榜用（最大9999999999999 - 时间戳 + 分数）
     */
    public static Double rankingTimeDifference(Double score) {
        Long timeDifference = 9999999999999L - System.currentTimeMillis();
        String str = score + timeDifference.toString();
        return Double.valueOf(str);
    }
    
    

    /**
     * 获取真实分数
     */
    public static Double rankingScore(Double score) {
        return Math.floor(score);
    }
}

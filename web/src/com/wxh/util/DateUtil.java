/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期工具类
 * @author wxh
 * @version $Id: DateUtil.java, v 0.1 2017年9月15日 下午5:24:10 wxh Exp $
 */
public class DateUtil {
    /** 年月日时分秒 */
    private static final String DATE_FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 强制私有化，防止被实例化
     */
    private DateUtil() {

    }

    /**
     * 将字符串转换成指定格式日期
     * @param dateStr 传入字符串参数
     * @param pattern 日期格式
     * @return Date 日期对象
     * @throws ParseException 解析异常
     */
    public static Date stringToDate(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        if (!StringUtils.isEmpty(dateStr)) {
            return format.parse(dateStr);
        }
        return null;
    }

    /**
     * 将字符串转换成指定格式日期
     * @param dateStr 传入字符串
     * @return Date  日期对象
     * @throws ParseException 解析异常
     */
    public static Date stringtoDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FULL_PATTERN);
        if (!StringUtils.isEmpty(dateStr)) {
            return format.parse(dateStr);
        }
        return null;
    }
}

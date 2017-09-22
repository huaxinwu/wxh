/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 避免创建重复对象
 * 比如 String s = new String("1234") 这样每次调用会创建无数个String对象
 * 浪费内存空间，正确做法保持该值不变String s = "1234";
 * @author wxh
 * @version $Id: Person.java, v 0.1 2017年9月5日 下午1:39:58 wxh Exp $
 */
public class Person {

    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 不推荐方法,创建Calendar、Date两个实例对象
     * @return boolean
     */
    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        // 设置年月日时分秒 1946-1-1 00：00：00
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    /**
     * 推荐方法，静态初始化对象，作为成员变量传入
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    /**
     * 静态初始化对象，提供性能
     * @return boolean
     */
    public boolean isBabyBoomerStatic() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}

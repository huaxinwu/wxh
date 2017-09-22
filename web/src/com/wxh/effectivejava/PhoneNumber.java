/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.HashMap;
import java.util.Map;

/**
 * 重写equals必须重写hashcode
 * 两个对象用equals比较相等，它们的hashcode值必须相等
 * @author wxh
 * @version $Id: PhoneNumber.java, v 0.1 2017年9月6日 上午10:36:06 wxh Exp $
 */
public class PhoneNumber {

    private final short     areaCode;
    private final short     exchange;
    private final short     extension;
    /** 迟缓初始化，缓存起来  用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值  */
    private volatile int    hashCode = 0;

    private static String[] ZEROS    = { "", "0", "00", "000", "0000", "00000", "000000",
            "0000000", "00000000", "000000000" };

    /**
     * 填充字符串0或者00或者""等等
     * 0014524512
     * @param i
     * @param length
     * @return
     */
    private static String toPaddedString(int i, int length) {
        String string = Integer.toString(i);
        return ZEROS[length - string.length()] + string;
    }

    /**
     * 范围校验
     * @param arg 区域编号
     * @param max 最大值
     * @param name 名称
     */
    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }

    /**
     * 初始化数据
     * 构造数据
     * 数据校验
     * @param areaCode
     * @param exchange
     * @param extension
     */
    public PhoneNumber(int areaCode, int exchange, int extension) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(exchange, 999, "exchange");
        rangeCheck(extension, 9999, "extension");

        this.areaCode = (short) areaCode;
        this.exchange = (short) exchange;
        this.extension = (short) extension;
    }

    /**
     * 先用==判断，再用instanceOf判断
     * @param o
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber phoneNumber = (PhoneNumber) o;
        return phoneNumber.extension == extension && phoneNumber.exchange == exchange
               && phoneNumber.areaCode == areaCode;
    }

    /**
     * 计算公式：result = 37 * result + code;
     * hashcode存储是类的引用，在缓存中创建一个table，检查不存在hashcode值就添加进来
     * 存在就更新
     * hashCode是用来在散列存储结构中确定对象的存储地址的
     * @return
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 37 * result + areaCode;
            result = 37 * result + exchange;
            result = 37 * result + extension;
            hashCode = result;
        }
        return hashCode;
    }

    /**
     * 提供一个信息丰富、易于阅读的表达式
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "(" + toPaddedString(areaCode, 3) + ")" + toPaddedString(exchange, 3) + "-"
               + toPaddedString(extension, 3);
    }

    /**
     * Object的clone受保护，提供公有方法
     * @return
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("Assertion failure");
        }
    }

    /**
     * 小于 等于 大于
     * -1  0   1
     * @param o
     * @return
     */
    public int CompareTo(Object o) {
        PhoneNumber pn = (PhoneNumber) o;
        //        if (areaCode < pn.areaCode) {
        //            return -1;
        //        }
        //        if (areaCode > pn.areaCode) {
        //            return 1;
        //        }
        //        if (exchange < pn.exchange) {
        //            return -1;
        //        }
        //        if (exchange > pn.exchange) {
        //            return 1;
        //        }
        //        if (extension < pn.extension) {
        //            return -1;
        //        }
        //        if (extension > pn.extension) {
        //            return 1;
        //        }

        // 代码改造,求取差值
        int areaCodeDiff = areaCode - pn.areaCode;
        if (areaCodeDiff != 0) {
            return areaCodeDiff;
        }
        int exchangeDiff = exchange - pn.exchange;
        if (exchangeDiff != 0) {
            return exchangeDiff;
        }
        int extensionDiff = extension - pn.extension;
        if (extensionDiff != 0) {
            return extensionDiff;
        }
        return 0;
    }

    /**
     * 通过new创建两个PhoneNumber实例，一个插入HashMap,一个用于检索HashMap的value
     * 木有重写hashcode方法，底层调用hashCode方法返回hash code 不一定相同
     * hashcode 对于List Array木有实际的意义；对于HashMap、HashSet、HashTable有意义，因为它们的key值计算设计到hashcode
     * @param args
     */
    public static void main(String[] args) {
        // no hashcode method
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put(new PhoneNumber(408, 867, 5539), "Jenny");
        System.out.println("hashcode1: " + new PhoneNumber(408, 867, 5539).hashCode());
        // expect -- true  actual--false 木有重写hashcode方法，导致它们的hashcode值不一致
        System.out.println("Jenny".equals(map.get(new PhoneNumber(408, 867, 5539))));
        System.out.println("hashcode2: " + new PhoneNumber(408, 867, 5539).hashCode());
        System.out.println(map.get(new PhoneNumber(408, 867, 5539)));
    }
}

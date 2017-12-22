/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 获取一个类加载器
 * 十进制转换为字符串
 * @author wxh
 * @version $Id: HexString.java, v 0.1 2017年12月19日 下午1:48:20 wxh Exp $
 */
public class HexString {

    /** 十进制字符 */
    private final String hexChar = "0123456789ABCDEF";

    private StringBuffer buf     = new StringBuffer();

    /**
     * 转换
     * @param val
     * @param maxNibblesToConvert 转变最大的蚕食
     */
    public void Convert(int val, int maxNibblesToConvert) {
        buf.setLength(0);
        int v = val;
        for (int i = 0; i < maxNibblesToConvert; ++i) {
            if (v == 0) {
                if (i == 0) {
                    buf.insert(0, '0');
                }
                break;
            }

            // 获取最低的蚕食 ，与15做位域运算
            int remainder = v & 0xf;

            // 将字节转换为字符并将其插入字符串的开头 
            buf.insert(0, hexChar.charAt(remainder));

            // 将int移到右四位 ,v=v>>>4;
            v >>>= 4;

        }
    }

    /**
     *  在构造方法里处理数据
     * @param val
     * @param minWidth
     */
    public HexString(int val, int minWidth) {
        Convert(val, minWidth);
        int charsNeeded = minWidth - buf.length();
        for (int i = 0; i < charsNeeded; ++i) {
            buf.insert(0, '0');
        }
    }

    /**
     * 获取一个字符串
     * @return
     */
    public String getString() {
        return buf.toString();
    }

}

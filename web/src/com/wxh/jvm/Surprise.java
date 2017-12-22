/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 不对称的调用和返回
 * @author wxh
 * @version $Id: Surprise.java, v 0.1 2017年12月21日 下午4:29:58 wxh Exp $
 */
public class Surprise {

    /**
     * 惊喜的程序
     * 无论传什么参数，都返回false，因为程序从finally子句中结束
     * @param bVal
     * @return
     */
    static boolean surpriseTheProgrammer(boolean bVal) {
        while (bVal) {
            try {
                return true;
            } finally {
                // 程序从这里结束，跳出循环
                break;
            }
        }
        return false;
    }

}

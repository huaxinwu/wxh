/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 一个模拟：saying tomato
 * 使用表的条件分支
 * @author wxh
 * @version $Id: Struggle.java, v 0.1 2017年12月21日 下午3:51:13 wxh Exp $
 */
public class Struggle {

    public static final int TOMYTO = 0;
    public static final int TOMHTO = 1;

    /**
     * 辩论
     */
    static void argue() {
        int say = TOMYTO;
        for (;;) {
            switch (say) {
                case TOMYTO:
                    say = TOMHTO;
                    break;
                case TOMHTO:
                    say = TOMYTO;
                    break;
                default:
                    break;
            }
        }
    }

}

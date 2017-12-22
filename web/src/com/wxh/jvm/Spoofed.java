/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 *
 * @author wxh
 * @version $Id: Spoofed.java, v 0.1 2017年12月15日 上午10:31:16 wxh Exp $
 */
public class Spoofed {

    private int secretValue = 42;

    static {
        System.out.println("linking/ext8/Spoofed initialized.");
    }

    public int giveMeFive() {
        return 5;
    }

    /**
     * 
     * 伪造方法，获取成员变量
     * @return
     */
    //    public int giveMeFive() {
    //        return secretValue;
    //    }

}

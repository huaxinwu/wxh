/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 委托对象
 * @author wxh
 * @version $Id: Delegated.java, v 0.1 2017年12月15日 上午10:43:18 wxh Exp $
 */
public class Delegated {

    public static Spoofed getSpoofed() {
        return new Spoofed();
    }

}

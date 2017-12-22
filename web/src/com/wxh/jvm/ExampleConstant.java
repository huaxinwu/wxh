/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 编译时常量解析
 * @author wxh
 * @version $Id: ExampleConstant.java, v 0.1 2017年12月13日 下午4:26:22 wxh Exp $
 */
public class ExampleConstant {

    public static void main(String[] args) {
        // Java支持条件编译
        if (AntEill.debug) {
            System.out.println("debug is true!");
        }
    }
}

class AntEill {
    static final boolean debug = true;
}

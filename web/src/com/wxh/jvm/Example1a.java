/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 类型生命周期：装载、连接(验证、准备、解析)、初始化
 * @author wxh
 * @version $Id: Example1a.java, v 0.1 2017年10月16日 下午3:51:39 wxh Exp $
 */
public class Example1a {

    static int size = 3 * (int) (Math.random() * 5.0);

    static int size1;
    static {
        size1 = 3 * (int) (Math.random() * 5.0);
    }

}

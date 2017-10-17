/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * Java编译器将类变量初始化语句和静态初始化语句代码都放在Java class文件中，
 * 按照它们在类或者接口中声明顺序执行
 * @author wxh
 * @version $Id: Example1c.java, v 0.1 2017年10月17日 下午2:01:16 wxh Exp $
 */
public class Example1c {

    static int width;
    static int height = (int) (Math.random() * 2.0);
    static {
        width = 3 * (int) (Math.random() * 5.0);
    }
}

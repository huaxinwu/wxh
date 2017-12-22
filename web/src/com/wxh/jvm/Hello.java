/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 用户自定义类装载器，扩展自身
 * @author wxh
 * @version $Id: Hello.java, v 0.1 2017年12月14日 下午3:10:38 wxh Exp $
 */
public class Hello implements Greeter {

    /** 
     * 
     * @see com.wxh.jvm.Greeter#greet()
     */
    @Override
    public void greet() {
        System.out.println("Hello,World!");
    }

}

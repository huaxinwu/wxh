/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Date;

/**
 *
 * @author wxh
 * @version $Id: Sub.java, v 0.1 2017年9月7日 下午3:03:47 wxh Exp $
 */
public class Sub extends Super {
    private Date date;

    Sub() {
        date = new Date();
    }

    @Override
    public void m() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        // 父类构造器初始化、子类构造器初始化，子类重写父类的方法，父类的方法会被隐藏，从而调用子类方法，属性也是一样
        Sub sub = new Sub();
        sub.m();
    }
}

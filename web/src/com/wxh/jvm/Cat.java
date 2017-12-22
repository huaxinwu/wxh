/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 接口实现
 * @author wxh
 * @version $Id: Cat.java, v 0.1 2017年12月14日 上午10:38:22 wxh Exp $
 */
public class Cat implements Friendly {

    public void eat() {
        System.out.println("Chomp,chomp,chomp.");
    }

    /** 
     * 
     * @see com.wxh.jvm.Friendly#sayHello()
     */
    @Override
    public void sayHello() {
        System.out.println("Ruby,ruby,ruby.");
    }

    /** 
     * 
     * @see com.wxh.jvm.Friendly#sayGoodbye()
     */
    @Override
    public void sayGoodbye() {
        System.out.println("Scamper.");
    }

    protected void finalize() {
        System.out.println("Meow!");
    }

}

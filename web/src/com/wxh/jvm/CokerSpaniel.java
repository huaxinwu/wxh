/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 三个类和一个接口的层次关系
 * @author wxh
 * @version $Id: CokerSpaniel.java, v 0.1 2017年12月13日 下午4:49:58 wxh Exp $
 */
public class CokerSpaniel extends Dog2 implements Friendly {

    private int woofCount   = ((int) (Math.random() * 4.0)) + 1;
    private int wimperCount = ((int) (Math.random() * 3.0)) + 1;

    /** 
     * 
     * @see com.wxh.jvm.Friendly#sayGoodbye()
     */
    @Override
    public void sayGoodbye() {
        System.out.print("Wimper");
        for (int i = 0; i < wimperCount; i++) {
            System.out.print(",wimper");
        }
        System.out.println(".");
    }

    public void sayHello() {
        super.sayHello();
        System.out.print("Woof");
        for (int i = 0; i < woofCount; i++) {
            System.out.print(",woof");
        }
        System.out.println("!");
    }

}

interface Friendly {

    void sayHello();

    void sayGoodbye();
}

class Dog2 {

    private int wagCount = ((int) (Math.random() * 5.0)) + 1;

    public void sayHello() {
        System.out.print("Wag");
        for (int i = 0; i < wagCount; i++) {
            System.out.print(",wag");
        }
        System.out.println(".");
    }

    public String toString() {
        return "Woof!";
    }

}

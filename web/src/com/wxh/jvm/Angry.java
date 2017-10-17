/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 愤怒的动物
 * @author wxh
 * @version $Id: Angry.java, v 0.1 2017年10月17日 下午4:11:33 wxh Exp $
 */
public interface Angry {
    String greeting   = "Grrr!";
    int    angryLevel = Dog.getAngryLevel();

}

class Dog {
    static final String greeting = "Woof,woof,world";
    static {
        System.out.println("Dog was initialized.");
    }

    static int getAngryLevel() {
        System.out.println("Angry was initialized.");
        return 1;
    }
}

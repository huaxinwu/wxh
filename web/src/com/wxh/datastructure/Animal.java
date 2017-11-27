/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 抽象类：有一个或多个抽象方法的基类，用abstract修饰类，体现出类的单继承
 * 抽象方法可能抽象类中，抽象类中不一定有抽象方法
 * @author wxh
 * @version $Id: Animal.java, v 0.1 2017年11月16日 下午3:08:25 wxh Exp $
 */
public abstract class Animal {

    public static final int AGE = 10;

    protected int           weight;

    int                     b   = 12;

    private String          name;

    void eat() {
        System.out.println("吃东西");
    }

    abstract void walk();

    abstract void sleep();

    public static void main(String[] args) {
        // 抽象类实例化
        Animal animal = new Dog();
        /**
         * 输出结果:
         * 走路
         * 睡觉
         */
        animal.walk();
        animal.sleep();
    }

}

/**
 * 实现父类的所有抽象方法
 */
class Dog extends Animal {

    /** 
     * 
     * @see com.wxh.datastructure.Animal#walk()
     */
    @Override
    void walk() {
        System.out.println("走路");
    }

    /** 
     * 
     * @see com.wxh.datastructure.Animal#sleep()
     */
    @Override
    void sleep() {
        System.out.println("睡觉");
    }

}

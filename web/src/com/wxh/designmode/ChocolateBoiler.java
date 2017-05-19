/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式六：单件模式(singletom patterm,确保一个类只有一个实例，并提供一个全局访问点。)
 * 巧克力工厂应用：制造巧克力，巧克力锅炉拿到原料开始制作巧克力
 * 单件模式构造器是私有的，提供一个获取实例对象的公共方法
 * 单件模式多线程问题：解决-懒汉式同步锁、饿汉式都会增加系统开销，怎么办？换一种方式比如饿汉式/双重检查加锁等等
 * jdk1.2,单件模式创建的对象在没有被引用的时候被垃圾回收器回收
 * 处理一般都是在应用程序中只加载一次的资源.
 * 应用场景:当程序中的需要确保某个类只有一个实例,使用单件模式。
 * @author wxh
 * @version $Id: ChocolateBoiler.java, v 0.1 2017年4月19日 上午10:29:53 wxh Exp $
 */
public class ChocolateBoiler {

    /** 空的 */
    private boolean                empty;
    /** 煮沸的 */
    private boolean                boiled;

    /**懒汉式，线程不安全,解决方案：加同步锁 ，线程安全 */
    private static ChocolateBoiler uniqueInstance;

    /**
     * 刚开始锅炉是空的，没有煮沸的
     * 
     */
    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    /**
     * 获取一个实例
     * @return
     */
    public static synchronized ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }

    /**
     * 向锅炉填充原料
     */
    public void fill() {
        // 锅炉有原料，empty和boiled状态改变
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // 在锅炉填充巧克力和牛奶的混合物
        }
    }

    /**
     * 锅炉排出，必须是满的，煮沸的,排出完毕，是空的
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // 排空
            empty = true;
        }
    }

    /**
     * 煮混合物，没有煮过的
     */
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // 将锅内物煮沸
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    public void setBoiled(boolean boiled) {
        this.boiled = boiled;
    }

}

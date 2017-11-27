/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 类与对象关系--类的封装
 * 同一个的事物，多数抽象成一个类，状态用属性来描述，行为用方法来描述
 * @author wxh
 * @version $Id: ClassAndObject.java, v 0.1 2017年11月16日 下午2:08:54 wxh Exp $
 */
public class ClassAndObject {
    // 成员变量
    private int    carLength;
    private int    engCC;
    private int    maxSpeed;
    private String modelName;

    /**
     * 构造方法
     */
    public ClassAndObject(String name) {
        this.carLength = 200;
        this.engCC = 300;
        this.maxSpeed = 400;
        this.modelName = name;
    }

    /**
     * 实例方法
     */
    public void ShowData() {
        System.out.println(modelName + "基本数据");
        System.out.println("车身长度：" + carLength);
        System.out.println("汽缸CC数：" + engCC);
        System.out.println("最高车速：" + maxSpeed);
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        // 类的实例化
        ClassAndObject object = new ClassAndObject("BMW 318i");
        // 调用实例方法
        object.ShowData();
    }

}

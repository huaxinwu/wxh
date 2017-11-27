/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 类与类关系
 * 所有类的都是会自动继承Object类
 * @author wxh
 * @version $Id: People.java, v 0.1 2017年11月17日 上午11:31:10 wxh Exp $
 */
public class People {

    /** 1.关联--一个类作为另一个类属性被定义  "has-a"   */
    private Car car;

    /**
     * 2.依赖--一个类当做方法参数传给另一个类的方法  "user-a"
     * @param dog
     */
    public void feed(Dog dog) {
        System.out.println("喂养动物");
    }

    /**
     * 3.继承--一个类完全复制另一个类的属性和方法，并且可以扩展额外的属性和方法。  "is-a" 
     */
    class Teacher extends People {

        private String address;
    }

}

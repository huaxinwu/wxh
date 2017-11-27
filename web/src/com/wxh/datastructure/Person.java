/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 类的继承
 * @author wxh
 * @version $Id: ClassExtend.java, v 0.1 2017年11月16日 下午2:28:32 wxh Exp $
 */
public class Person {

    private String  name;
    private Integer age;

    public Person() {
        System.out.println("我是父类");
    }

    public void eat() {
        System.out.println("吃饭了");
    }

    public void walk() {
        System.out.println("散步");
    }

    /**
     * overload  方法重载 ：只存在本类中，方法名相同，其余都不相同
     * @param name
     */
    public void walk(String name) {
        System.out.println(name + "在散步");
    }

    public static void main(String[] args) {
        Student student = new Student();
        /**
         * 输出结果：
         * 我是父类
         * 我是子类
         * 吃饭了
         */
        student.eat();
    }
}

class Student extends Person {

    public Student() {
        // super(); 通常这个方法可以隐藏，目的调用父类构造方法
        // 因为 创建子类的实例对象时候，先会创建父类实例对象之后，在创建子类实例对象
        System.out.println("我是子类");
    }

    /** 
     * 方法重写:只存在子类中，除了方法体的内容不同，其余都是相同的
     * @see com.wxh.datastructure.Person#eat()
     */
    @Override
    public void eat() {
        System.out.println("学生吃饭了");
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式一案例：策略模式(strategy，定义算法族，分别封装起来，让它们可以相互替换，此模式让算法的变化独立于使用算法的客户)
 * 
 * 模拟鸭子应用做起：鸭子一边游戏戏水，一边呱呱叫，鸭子会飞(需求变动,但是并不是所有的鸭子都会飞，比如橡皮鸭子，
 * 这样抽象设计就带来问题，如果是诱饵鸭子不会叫，也不会飞)。
 * 用OO技术：设计一个超类，让其他类继承---继承设计，显示不好用，故而使用接口+继承设计
 * 问题：在子类的中实例化接口，就不能动态地创建各种类型的子类实现，因此，可以用setter方法设置
 * 
 * 设计原则一：找出应用可能变化之处，把他们独立出来，不要和那些不需要变化的代码混在一起。
 * 设计原则二：针对接口编程，而不是针对实现编程。
 * 设计原则三：多用组合，少用继承。
 * 设计原则四：为了交互对象之间的松耦合设计而努力
 *
 * @author wxh
 * @version $Id: Duack.java, v 0.1 2017年1月19日 下午1:36:11 wxh Exp $
 */
public abstract class Duck {

    /**
     * 引入变化的部分用接口封装最为成员变量
     */
    FlyBehavior   flyBehavior;
    QuackBehavior quackBehavior;

    /**
     * 默认构造器
     */
    public Duck() {
        // TODO Auto-generated constructor stub
    }

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }

    /**
     * 表演飞行
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /** 
     * 表演呱呱叫
     */
    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * 呱呱叫
     */
    abstract void quack();

    /**
     * 飞行
     */
    abstract void fly();

    /**
     * 游泳
     */
    abstract void swim();

    /**
     * 外观
     */
    abstract void dispaly();

}

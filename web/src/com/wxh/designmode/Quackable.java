/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式十五：复合模式(结合两个或以上的模式，组成一个解决方案，解决一再发生的一般性问题。)
 * 鸭子模拟器应用:各种鸭子的叫声，加入鹅的叫声，统计鸭子叫声的次数
 * 案例解读：使用工厂模式创建鸭子，工厂模式分为两种一种是没有被QuackCouter装饰的鸭子，
 * 一种是被QuackCouter装饰的鸭子(能统计鸭子的叫声的次数),实现ObserverNew接口的类都可以
 * 观察Quackable,当quack方法被调用时候收到通知，每个Quackable都具备一个Observable实例
 * @author wxh
 * @version $Id: Quackable.java, v 0.1 2017年6月19日 上午9:57:58 wxh Exp $
 */
public interface Quackable extends QuackObservable {

    /**
     * 呱呱叫
     */
    public void quack();
}

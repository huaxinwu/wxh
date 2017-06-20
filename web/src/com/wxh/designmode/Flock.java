/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;

/**
 * 组合模式
 * 一大群鸭子
 * @author wxh
 * @version $Id: Flock.java, v 0.1 2017年6月19日 下午5:30:01 wxh Exp $
 */
public class Flock implements Quackable {

    ArrayList quackers = new ArrayList();

    /**
     * 添加鸭子
     * @param quacker
     */
    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    /** 
     * 迭代器模式
     * @see com.wxh.designmode.Quackable#quack()
     */
    @Override
    public void quack() {
        java.util.Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }

    /** 
     * 向flock注册时候，等于注册flock内的所有Quackable对象
     * 如何Quackable是另一个flock，做同样的事情
     * @param observer
     * @see com.wxh.designmode.QuackObservable#registerObserver(java.util.Observer)
     */
    @Override
    public void registerObserver(ObserverNew observer) {
        java.util.Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.registerObserver(observer);
        }
    }

    /** 
     * 每个Quackable都负责自己通知观察者，这样flock就不必关心
     * @see com.wxh.designmode.QuackObservable#notifyObservers()
     */
    @Override
    public void notifyObservers() {

    }

}

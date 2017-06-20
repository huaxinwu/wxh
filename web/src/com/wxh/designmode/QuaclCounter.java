/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 统计鸭子呱呱叫的次数
 * @author wxh
 * @version $Id: QuaclCounter.java, v 0.1 2017年6月19日 下午3:34:50 wxh Exp $
 */
public class QuaclCounter implements Quackable {
    Quackable  duck;
    static int numberOfQuacks;

    public QuaclCounter(Quackable duck) {
        this.duck = duck;
    }

    /** 
     * 
     * @see com.wxh.designmode.Quackable#quack()
     */
    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    /**
     * 所有Quackable中发生的叫声次数
     * @return
     */
    public static int getQuacks() {
        return numberOfQuacks;
    }

    /** 
     * @param observer
     * @see com.wxh.designmode.QuackObservable#registerObserver(java.util.Observer)
     */
    @Override
    public void registerObserver(ObserverNew observer) {
        duck.registerObserver(observer);
    }

    /** 
     * 
     * @see com.wxh.designmode.QuackObservable#notifyObservers()
     */
    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 猎人用的鸭鸣器
 * @author wxh
 * @version $Id: DuckCall.java, v 0.1 2017年6月19日 上午10:10:29 wxh Exp $
 */
public class DuckCall implements Quackable {

    Observable observable;

    public DuckCall() {
        observable = new Observable(this);
    }

    /** 
     * 
     * @see com.wxh.designmode.Quackable#quack()
     */
    @Override
    public void quack() {
        System.out.println("Kwak");
        observable.notifyObservers();
    }

    /** 
     * @param observer
     * @see com.wxh.designmode.QuackObservable#registerObserver(java.util.Observer)
     */
    @Override
    public void registerObserver(ObserverNew observer) {
        observable.registerObserver(observer);
    }

    /** 
     * 
     * @see com.wxh.designmode.QuackObservable#notifyObservers()
     */
    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    /** 
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Duck Call";
    }

}

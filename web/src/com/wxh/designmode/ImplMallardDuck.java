/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 绿头鸭
 * @author wxh
 * @version $Id: ImplMallardDuck.java, v 0.1 2017年6月19日 上午10:05:29 wxh Exp $
 */
public class ImplMallardDuck implements Quackable {

    Observable observable;

    public ImplMallardDuck() {
        observable = new Observable(this);
    }

    /** 
     * 委托观察者辅助类实现其行为
     * @see com.wxh.designmode.Quackable#quack()
     */
    @Override
    public void quack() {
        System.out.println("Quack");
        observable.notifyObservers();
    }

    /** 
     * 委托观察者辅助类实现其行为
     * @param observer
     * @see com.wxh.designmode.QuackObservable#registerObserver(java.util.Observer)
     */
    @Override
    public void registerObserver(ObserverNew observer) {
        observable.registerObserver(observer);
    }

    /** 
     * 委托观察者辅助类实现其行为
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
        return "Mallard Duck";
    }

}

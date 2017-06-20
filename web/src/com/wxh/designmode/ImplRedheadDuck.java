/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 红头鸭的变种体
 * @author wxh
 * @version $Id: RecheadDuck.java, v 0.1 2017年6月19日 上午10:08:36 wxh Exp $
 */
public class ImplRedheadDuck implements Quackable {

    Observable observable;

    public ImplRedheadDuck() {
        observable = new Observable(this);
    }

    /** 
     * 
     * @see com.wxh.designmode.Quackable#quack()
     */
    @Override
    public void quack() {
        System.out.println("Quack");
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
        return "Redhead Duck";
    }

}

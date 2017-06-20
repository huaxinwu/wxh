/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 观察者辅助类
 * @author wxh
 * @version $Id: Observable.java, v 0.1 2017年6月20日 上午9:59:47 wxh Exp $
 */
public class Observable implements QuackObservable {
    ArrayList       observers = new ArrayList();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    /** 
     * @param observer
     * @see com.wxh.designmode.QuackObservable#registerObserver(java.util.Observer)
     */
    @Override
    public void registerObserver(ObserverNew observer) {
        observers.add(observer);
    }

    /** 
     * 
     * @see com.wxh.designmode.QuackObservable#notifyObservers()
     */
    @Override
    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            ObserverNew observer = (ObserverNew) iterator.next();
            observer.update(duck);
        }
    }

}

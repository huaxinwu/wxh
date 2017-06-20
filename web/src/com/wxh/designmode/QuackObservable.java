/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 观察者模式
 * @author wxh
 * @version $Id: QuackObservable.java, v 0.1 2017年6月20日 上午9:54:00 wxh Exp $
 */
public interface QuackObservable {
    /**
     * 注册观察者
     * @param observer
     */
    public void registerObserver(ObserverNew observer);

    /**
     * 通知所有观察者
     */
    public void notifyObservers();

}

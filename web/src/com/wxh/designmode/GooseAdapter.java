/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;


/**
 * 鹅适配器
 * @author wxh
 * @version $Id: GooseAdapter.java, v 0.1 2017年6月19日 下午3:25:13 wxh Exp $
 */
public class GooseAdapter implements Quackable {
    Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    /** 
     *  委托对象来调用方法
     * @see com.wxh.designmode.Quackable#quack()
     */
    @Override
    public void quack() {
        goose.honk();
    }

    /** 
     * @param observer
     * @see com.wxh.designmode.QuackObservable#registerObserver(java.util.Observer)
     */
    @Override
    public void registerObserver(ObserverNew observer) {
    }

    /** 
     * 
     * @see com.wxh.designmode.QuackObservable#notifyObservers()
     */
    @Override
    public void notifyObservers() {
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 主题---多个观察者
 * @author wxh
 * @version $Id: Subject.java, v 0.1 2017年3月28日 下午2:34:58 wxh Exp $
 */
public interface Subject {

    /**
     * 注册观察者
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    public void removeObserver(Observer o);

    /**
     * 唤醒观察者
     * @param o
     */
    public void notifyObservers();
}

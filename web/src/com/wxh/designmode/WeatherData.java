/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;

/**
 * 
 * 设计模式二案例：观察者模式(observerable,定义对象之间的一对多的依赖，这样以来，当一个对象改变状态时，它的所有依赖对象都会收到通知并且自动更新。
 * 通俗点讲：就是比如一个拥有状态的主题，主题并控制这些状态，观察者使用这些状态)
 * 
 * 气象站应用：WeatherDate是“一”
 * 
 * 设计原则：为了交互对象之间的松耦合设计而努力
 * @author wxh
 * @version $Id: WeatherData.java, v 0.1 2017年2月6日 上午10:56:54 wxh Exp $
 */
public class WeatherData implements Subject {

    private ArrayList observers;
    private float     temp;
    private float     humidity;
    private float     pressure;

    /**
     * 
     */
    public WeatherData() {
        observers = new ArrayList();
    }

    /** 
     * @param o
     * @see com.wxh.designmode.Subject#registerObserver(com.wxh.designmode.Observer)
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /** 
     * @param o
     * @see com.wxh.designmode.Subject#removeObserver(com.wxh.designmode.Observer)
     */
    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i > 0) {
            observers.remove(o);
        }
    }

    /** 
     * @param o
     * @see com.wxh.designmode.Subject#notifyObserver(com.wxh.designmode.Observer)
     */
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temp, humidity, pressure);
        }
    }

    /**
     * 测量
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 设置测量
     *
     * @param temp
     * @param huhumidity
     * @param pressure
     */
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    //WeatherData 其他方法
}

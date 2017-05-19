/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Observable;
import java.util.Observer;

/**
 * 当前布告板
 * @author wxh
 * @version $Id: CurrentConditionsInnerDisplay.java, v 0.1 2017年4月10日 下午3:12:54 wxh Exp $
 */
public class CurrentConditionsInnerDisplay implements Observer, DisplayElement {

    Observable    observable;
    private float temp;
    private float humidity;

    /**
     * 初始化数据，添加观察者
     */
    public CurrentConditionsInnerDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /** 
     * @param o
     * @param arg
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherDataInner) {
            WeatherDataInner weatherDataInner = (WeatherDataInner) o;
            this.temp = weatherDataInner.getTemp();
            this.humidity = weatherDataInner.getHumidity();
            display();
        }
    }

    /** 
     * 
     * @see com.wxh.designmode.DisplayElement#display()
     */
    @Override
    public void display() {
        System.out.println("Current ConditionsInner:" + temp + "F degress and " + humidity
                           + "% humidity");
    }

}

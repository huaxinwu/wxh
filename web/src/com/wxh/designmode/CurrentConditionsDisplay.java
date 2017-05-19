/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 目前状况布告板
 * @author wxh
 * @version $Id: CurrentConditionsDisplay.java, v 0.1 2017年3月28日 下午3:06:34 wxh Exp $
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float   temp;
    private float   humidity;
    private Subject weatherData;

    /**
     * 构造器里面初始化主题并注册
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /** 
     * @param temp
     * @param huhumidity
     * @param pressure
     * @see com.wxh.designmode.Observer#update(float, float, float)
     */
    @Override
    public void update(float temp, float huhumidity, float pressure) {
        this.temp = temp;
        this.humidity = huhumidity;
        display();
    }

    /** 
     * 
     * @see com.wxh.designmode.DisplayElement#display()
     */
    @Override
    public void display() {
        System.out.println("Current Conditions:" + temp + "F degress and " + humidity
                           + "% humidity");

    }

}

/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Observable;

/**
 * 继承Java内置的观察者接口
 * 问题：1.使用Java内置Observable类，就不能支持多重继承
 * @author wxh
 * @version $Id: WeatherData2.java, v 0.1 2017年4月10日 下午3:04:10 wxh Exp $
 */
public class WeatherDataInner extends Observable {

    private float temp;
    private float humidity;
    private float pressure;

    /**
     * 默认构造器
     */
    public WeatherDataInner() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 主题状态改变
     */
    public void measurementsChanged() {
        //设置改变状态，才通知观察者
        setChanged();
        notifyObservers();
    }

    /**
     * 设置测量值
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

}

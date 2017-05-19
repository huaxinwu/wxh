/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 气象工作站
 * @author wxh
 * @version $Id: WeatherStation.java, v 0.1 2017年4月10日 下午2:21:05 wxh Exp $
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);

        System.out.println("------------------华丽分割线---------------------------");

        WeatherDataInner weatherDataInner = new WeatherDataInner();
        CurrentConditionsInnerDisplay conditionsInnerDisplay = new CurrentConditionsInnerDisplay(
            weatherDataInner);
        weatherDataInner.setMeasurements(80, 65, 30.4f);
    }
}

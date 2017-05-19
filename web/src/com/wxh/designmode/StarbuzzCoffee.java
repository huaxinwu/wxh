/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 星巴克咖啡
 * @author wxh
 * @version $Id: StarbuzzCoffee.java, v 0.1 2017年4月17日 下午2:22:48 wxh Exp $
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {

        // 需求一：定一杯Espresso,不需要调料，打印它的描述与价钱
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        // 需求二：定一杯DarkRoast，加双倍摩卡和奶泡，打印它的描述与价钱
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        // 需求三：定一杯HouseBlend,加豆浆、摩卡、奶泡，打印它的描述与价钱
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

    }
}

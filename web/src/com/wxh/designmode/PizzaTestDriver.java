/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 披萨开店测试
 * @author wxh
 * @version $Id: PizzaTestDriver.java, v 0.1 2017年4月18日 上午11:37:53 wxh Exp $
 */
public class PizzaTestDriver {

    public static void main(String[] args) {
        // 生产两个不同的店
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        // 获取Ethan订单
        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        // 获取joel订单
        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}

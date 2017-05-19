/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 产品类--具体产品类
 * @author wxh
 * @version $Id: NYStyleCheesePizza.java, v 0.1 2017年4月18日 上午10:49:40 wxh Exp $
 */
public class NYStyleCheesePizza extends Pizza {
    /**
     * 构造器实例化成员变量
     */
    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}

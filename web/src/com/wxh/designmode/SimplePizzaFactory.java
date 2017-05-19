/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 简单披萨工厂类
 * @author wxh
 * @version $Id: SimplePizzaFactory.java, v 0.1 2017年4月17日 下午4:25:42 wxh Exp $
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // 奶酪
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
            // 意大利辣香肠
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}

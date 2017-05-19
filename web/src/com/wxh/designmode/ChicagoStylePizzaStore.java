/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 芝加哥风味
 * @author wxh
 * @version $Id: ChicagoStylePi.java, v 0.1 2017年4月18日 上午10:42:08 wxh Exp $
 */
public class ChicagoStylePizzaStore extends PizzaStore {

    /** 
     * @param type
     * @return
     * @see com.wxh.designmode.PizzaStore#createPizza(java.lang.String)
     */
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        // 奶酪
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
            // 意大利辣香肠
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }

}

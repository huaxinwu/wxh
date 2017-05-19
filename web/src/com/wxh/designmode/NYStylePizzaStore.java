/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 纽约风味
 * 创建者类--具体创建者类
 * @author wxh
 * @version $Id: NYStylePizzaStore.java, v 0.1 2017年4月18日 上午10:41:06 wxh Exp $
 */
public class NYStylePizzaStore extends PizzaStore {

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
            pizza = new NYStyleCheesePizza();
            // 意大利辣香肠
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new NYStyleClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new NYStyleVeggiePizza();
        }
        return pizza;
    }

    /**
     * 工厂方法创建原料
     * @param type
     * @return
     */
    public PizzaCreate createPizzaTwo(String type) {
        PizzaCreate pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        // 奶酪
        if (type.equals("cheese")) {
            pizza = new CheesePizzaCreate(ingredientFactory);
            pizza.setName("New Yorl Style Cheese Pizza");
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizzaCreate(ingredientFactory);
            pizza.setName("New Yorl Style pepperoni Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizzaCreate(ingredientFactory);
            pizza.setName("New Yorl Style clam Pizza");
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizzaCreate(ingredientFactory);
            pizza.setName("New Yorl Style veggie Pizza");
        }
        return pizza;
    }

}

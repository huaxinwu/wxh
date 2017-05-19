/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 奶酪
 * @author wxh
 * @version $Id: CheesePizza.java, v 0.1 2017年4月17日 下午4:49:05 wxh Exp $
 */
public class CheesePizzaCreate extends PizzaCreate {
    PizzaIngredientFactory ingredientFactory;

    /**
     * 
     */
    public CheesePizzaCreate(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /** 
     * 
     * @see com.wxh.designmode.Pizza#prepare()
     */
    @Override
    void prepare() {
        System.out.println("Preparing " + name);
        // 工厂来制作原料
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }

}

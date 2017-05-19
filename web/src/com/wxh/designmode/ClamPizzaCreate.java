/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 *
 * @author wxh
 * @version $Id: ClamPizzaCreate.java, v 0.1 2017年4月18日 下午4:51:08 wxh Exp $
 */
public class ClamPizzaCreate extends PizzaCreate {

    PizzaIngredientFactory ingredientFactory;

    /**
     * 
     */
    public ClamPizzaCreate(PizzaIngredientFactory ingredientFactory) {
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

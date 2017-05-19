/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 纽约披萨原料工厂
 * @author wxh
 * @version $Id: NYPizzaIngredientFactory.java, v 0.1 2017年4月18日 下午3:53:06 wxh Exp $
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    /** 
     * @return
     * @see com.wxh.designmode.PizzaIngredientFactory#createDough()
     */
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    /** 
     * @return
     * @see com.wxh.designmode.PizzaIngredientFactory#createSauce()
     */
    @Override
    public Sauce createSauce() {
        return new MarnaraSauce();
    }

    /** 
     * @return
     * @see com.wxh.designmode.PizzaIngredientFactory#createCheese()
     */
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    /** 
     * @return
     * @see com.wxh.designmode.PizzaIngredientFactory#createViggies()
     */
    @Override
    public Viggies[] createViggies() {
        Viggies[] viggies = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return viggies;
    }

    /** 
     * @return
     * @see com.wxh.designmode.PizzaIngredientFactory#createPepperoni()
     */
    @Override
    public Pepperoni createPepperoni() {
        return new SilcedPepperoni();
    }

    /** 
     * @return
     * @see com.wxh.designmode.PizzaIngredientFactory#createClam()
     */
    @Override
    public Clams createClam() {
        return new FreshClams();
    }

}

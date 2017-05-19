/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 披萨原料工厂接口
 * 设计模式五：抽象工厂模式：提供一个接口，用于创建相关或者依赖对象的家族，而不需要明确指定的具体类。
 * 工厂制造原料应用：不同区域的工厂创建不同的原料。
 * @author wxh
 * @version $Id: PizzaIngredientFactory.java, v 0.1 2017年4月18日 下午3:44:32 wxh Exp $
 */
public interface PizzaIngredientFactory {

    /**
     * 每种原料都有一个对应方法来该原料
     * @return
     */
    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Viggies[] createViggies();

    public Pepperoni createPepperoni();

    public Clams createClam();
}

/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 披萨类
 * 披萨店开再多，没有披萨也不行，将其抽象化，让子类实现
 * 产品类--抽象产品类
 * 
 * @author wxh
 * @version $Id: Pizza.java, v 0.1 2017年4月17日 下午4:26:22 wxh Exp $
 */
public abstract class PizzaCreate {
    /** 名称 */
    String    name;
    /** 面团类型  */
    Dough     dough;
    /** 酱料类型 */
    Sauce     sauce;
    /** 一套作料 */
    Viggies[] viggies;
    Cheese    cheese;
    Pepperoni pepperoni;
    Clams     clam;

    /**
     * 准备
     * 抽象工厂模式
     */
    abstract void prepare();

    /**
     * 烘烤
     */
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    /**
     * 切片
     */
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    /**
     * 装盒
     */
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

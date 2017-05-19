/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;

/**
 * 披萨类
 * 披萨店开再多，没有披萨也不行，将其抽象化，让子类实现
 * 产品类--抽象产品类
 * @author wxh
 * @version $Id: Pizza.java, v 0.1 2017年4月17日 下午4:26:22 wxh Exp $
 */
public abstract class Pizza {
    /** 名称 */
    String    name;
    /** 面团类型  */
    String    dough;
    /** 酱料类型 */
    String    sauce;
    /** 一套作料 */
    ArrayList toppings = new ArrayList();

    /**
     * 准备
     */
    void prepare() {
        System.out.println("Preparing " + name);
        // 抖动面团
        System.out.println("Tossing dough...");
        // 增加酱料
        System.out.println("Adding sauce...");
        // 增加作料,作料有一连串的步骤
        System.out.println("Adding toppings:");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println(" " + toppings.get(i));
        }
    }

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

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public ArrayList getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList toppings) {
        this.toppings = toppings;
    }

}

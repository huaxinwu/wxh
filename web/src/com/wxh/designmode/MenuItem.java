/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式十一：迭代器模式(提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。)
 * 对象村餐厅与对象村煎饼屋合并应用：用煎饼屋菜单当早餐，餐厅的菜单当午餐
 * 设计原则：一个类应该只有一个引起变化的原因(该原则告诉我们，尽量让每个类保持单一责任。)
 * 内聚：用来度量一个类或模板紧密地达到单一目的或责任。
 * 组合菜单项
 * @author wxh
 * @version $Id: MenuItem.java, v 0.1 2017年5月31日 上午9:58:38 wxh Exp $
 */
public class MenuItem extends MenuComponent {

    /** 名称 */
    String  name;
    /** 描述 */
    String  description;
    /** 是否为素食状态 */
    boolean vegetarian;
    /** 价格  */
    double  price;

    /**
     * @param name
     * @param description
     * @param vegetarian
     * @param price
     */
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        super();
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    /**
     * 创建一个空的迭代器
     * @return
     */
    public java.util.Iterator createIterator() {
        return new NullIterator();
    }

    /** 
     * 
     * @see com.wxh.designmode.MenuComponent#print()
     */
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println("," + getPrice());
        System.out.println(" --" + getDescription());
    }

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     * 
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property <tt>vegetarian</tt>.
     * 
     * @return property value of vegetarian
     */
    public boolean isVegetarian() {
        return vegetarian;
    }

    /**
     * Setter method for property <tt>vegetarian</tt>.
     * 
     * @param vegetarian value to be assigned to property vegetarian
     */
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    /**
     * Getter method for property <tt>price</tt>.
     * 
     * @return property value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for property <tt>price</tt>.
     * 
     * @param price value to be assigned to property price
     */
    public void setPrice(double price) {
        this.price = price;
    }

}

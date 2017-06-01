/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;

/**
 * 煎饼屋菜单
 * @author wxh
 * @version $Id: PancakeHouseMenu.java, v 0.1 2017年5月31日 上午10:21:12 wxh Exp $
 */
public class PancakeHouseMenu implements Menu {
    ArrayList menuItems;

    /**
     * 
     */
    public PancakeHouseMenu() {
        super();
        menuItems = new ArrayList();
        addItem("K&B'S Pancake Breakfast", "Pancakes with scrambled eggs,and toast", true, 2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs,and sausage", false, 2.99);
        addItem("Buleberry Pancake Breakfast", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles,with your choice of blueberries or strawberries", true, 3.59);
    }

    /**
     * 添加菜单项
     * @param name
     * @param description
     * @param vegetarian
     * @param price
     */
    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);

    }

    /**
     * Getter method for property <tt>menuItems</tt>.
     * 这样会暴露内部实现
     * @return property value of menuItems
     */
    //    public ArrayList getMenuItems() {
    //        return menuItems;
    //    }

    /**
     * 创建迭代器
     * @return
     */
    //    public Iterator createIterator() {
    //        return new PancakeHouseMenuIterator(menuItems);
    //    }

    /**
     * 利用jdk自带的迭代器
     * @return
     */
    public java.util.Iterator createIteratorNative() {
        return menuItems.iterator();
    }

    // 菜单的其他方法

}

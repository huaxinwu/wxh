/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Arrays;

/**
 * 餐厅菜单
 * @author wxh
 * @version $Id: DinerMenu.java, v 0.1 2017年5月31日 上午10:34:01 wxh Exp $
 */
public class DinerMenu implements Menu {
    static final int MAX_ITEMS     = 6;
    int              numberOfItems = 0;
    MenuItem[]       menuItems;

    /**
     * 
     */
    public DinerMenu() {
        super();
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "(Fakin)Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of day", "Soup of day,with a side of potato salad", false, 3.29);
        addItem("Hotdog", "a hot dog,with saurkraut,relish,onions,topped with cheese", true, 3.05);
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
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("Sorry,menu is full! Can not add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    /**
     * Getter method for property <tt>menuItems</tt>.
     * 这样会暴露内部实现
     * @return property value of menuItems
     */
    //    public MenuItem[] getMenuItems() {
    //        return menuItems;
    //    }

    /**
     * 创建一个迭代器
     * @return
     */
    //    public Iterator createIterator() {
    //        return new DinerMenuIterator(menuItems);
    //    }

    /** 
     * @return
     * @see com.wxh.designmode.Menu#createIteratorNative()
     */
    @Override
    public java.util.Iterator createIteratorNative() {
        return Arrays.asList(menuItems).iterator();
    }

    // 菜单的其他方法 

}

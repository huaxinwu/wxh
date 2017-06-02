/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * 咖啡菜单项
 * 需求变动：对象村将咖啡厅菜单作为晚餐
 * @author wxh
 * @version $Id: CafeMenu.java, v 0.1 2017年6月2日 上午9:59:45 wxh Exp $
 */
public class CafeMenu implements Menu {
    // 散列表 --任何非null的对象可以作为键或值
    Hashtable menuItems = new Hashtable();

    /**
     * 
     */
    public CafeMenu() {
        super();
        addItem("Veggie Burgar and Air pries",
            "Veggie burgar on a whole wheat bun,letture,tomato,and fries", true, 3.99);
        addItem("Soup of the day", "A cup of the soup of the day,with a side salad", false, 3.69);
        addItem("Burrito", "A large burrito,with whole pinto beans,salsa,quacamole", true, 4.29);
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
        menuItems.put(menuItem.getName(), menuItem);

    }

    /**
     * 获取一个hashtable
     * @return
     */
    public Hashtable getItems() {
        return menuItems;
    }

    /** 
     * @return
     * @see com.wxh.designmode.Menu#createIteratorNative()
     */
    @Override
    public Iterator createIteratorNative() {
        return menuItems.values().iterator();
    }

    // 菜单的其他方法
}

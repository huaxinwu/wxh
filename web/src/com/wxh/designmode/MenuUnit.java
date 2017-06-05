/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 组合菜单
 * @author wxh
 * @version $Id: MenuUnit.java, v 0.1 2017年6月2日 下午2:51:39 wxh Exp $
 */
public class MenuUnit extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    String    name;
    String    description;

    public MenuUnit(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    /**
     * 创建一个复合迭代器
     * @return
     */
    public Iterator createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }

    /** 
     * 添加组件
     * @param menuComponent
     * @see com.wxh.designmode.MenuComponent#add(com.wxh.designmode.MenuComponent)
     */
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent) menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("-------------------------");
        // 打印各个菜单组件
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}

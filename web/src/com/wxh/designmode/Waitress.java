/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 女招待员(煎饼屋、餐厅、咖啡厅)
 * @author wxh
 * @version $Id: Waitress.java, v 0.1 2017年6月1日 下午1:45:53 wxh Exp $
 */
public class Waitress {

    //    PancakeHouseMenu pancakeHouseMenu;
    //    DinerMenu        dinerMenu;
    Menu          pancakeHouseMenu;
    Menu          dinerMenu;
    Menu          cafeMenu;
    /** 因为新增一个菜单就要新增打印代码用集合存储遍历  */
    ArrayList     menus;

    /** 组合菜单 */
    MenuComponent allMenus;

    /**
     * @param allMenus
     */
    public Waitress(MenuComponent allMenus) {
        super();
        this.allMenus = allMenus;
    }

    /**
     * @param menus
     */
    public Waitress(ArrayList menus) {
        super();
        this.menus = menus;
    }

    /**
     * 
     */
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        super();
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    /**
     * 组件方式打印菜单
     */
    public void printMenuComponent() {
        allMenus.print();
    }

    /**
     * 打印菜单项
     */
    public void printMenu() {
        //        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        //        Iterator dinerIterator = dinerMenu.createIterator();
        java.util.Iterator pancakeIterator = pancakeHouseMenu.createIteratorNative();
        java.util.Iterator dinerIterator = dinerMenu.createIteratorNative();
        java.util.Iterator cafeIterator = cafeMenu.createIteratorNative();
        System.out.println("MENU\n------\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    /**
     * 将多次打印放在循环中处理
     */
    public void printMenuList() {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printMenu(menu.createIteratorNative());
        }
    }

    /**
     * 遍历打印菜单项
     * @param iterator
     */
    private void printMenu(java.util.Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ", ");
            System.out.println(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());

        }
    }

    // 其他方法
}

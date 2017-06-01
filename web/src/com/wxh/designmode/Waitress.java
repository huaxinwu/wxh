/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 女招待员
 * @author wxh
 * @version $Id: Waitress.java, v 0.1 2017年6月1日 下午1:45:53 wxh Exp $
 */
public class Waitress {

    //    PancakeHouseMenu pancakeHouseMenu;
    //    DinerMenu        dinerMenu;
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    /**
     * 
     */
    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        super();
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    /**
     * 打印菜单项
     */
    public void printMenu() {
        //        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        //        Iterator dinerIterator = dinerMenu.createIterator();
        java.util.Iterator pancakeIterator = pancakeHouseMenu.createIteratorNative();
        java.util.Iterator dinerIterator = dinerMenu.createIteratorNative();
        System.out.println("MENU\n------\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
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

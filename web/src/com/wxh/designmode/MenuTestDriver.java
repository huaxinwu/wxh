/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 打印菜单项测试
 * @author wxh
 * @version $Id: MenuTestDriver.java, v 0.1 2017年6月1日 下午2:00:02 wxh Exp $
 */
public class MenuTestDriver {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}

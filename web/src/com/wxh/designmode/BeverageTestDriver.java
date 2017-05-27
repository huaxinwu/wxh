/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 测试咖啡根据顾客是否想要调料而加入调料
 * @author wxh
 * @version $Id: BeverageTestDriver.java, v 0.1 2017年5月27日 上午11:26:36 wxh Exp $
 */
public class BeverageTestDriver {

    public static void main(String[] args) {
        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        System.out.println("\nMaking the Coffee...");
        coffeeHook.prepareRecipe();
    }

}

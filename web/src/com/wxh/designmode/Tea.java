/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 茶
 * @author wxh
 * @version $Id: Tea.java, v 0.1 2017年5月27日 上午9:56:45 wxh Exp $
 */
public class Tea extends CoffeeBeverage {

    /**
     * 浸泡茶
     */
    @Override
    public void brew() {
        System.out.println("Steep the Tea");
    }

    /**
     * 加柠檬
     */
    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 实现接口的所有抽象方法
 * @author wxh
 * @version $Id: Fruit.java, v 0.1 2017年11月16日 下午3:37:13 wxh Exp $
 */
public class Fruit implements Food {

    /** 
     * 
     * @see com.wxh.datastructure.Food#Healthcare()
     */
    @Override
    public void Healthcare() {
        System.out.println("保健功能");
    }

    /** 
     * 
     * @see com.wxh.datastructure.Food#Nutrition()
     */
    @Override
    public void Nutrition() {
        System.out.println("营养功能");
    }

    public static void main(String[] args) {
        // 接口实例化
        Food food = new Fruit();
        /**
         * 输出结果：
         * 保健功能
         * 营养功能
         */
        food.Healthcare();
        food.Nutrition();
    }

}

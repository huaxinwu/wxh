/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式八：适配器模式(将一个类的接口，转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以合作无间。)
 * 适配器分类：对象适配器和类适配器
 * 对象适配器采用是组合方式，类适配器采用是继承方式
 * 火鸡应用：缺鸭子对象，想用火鸡来冒充
 * 真实世界场景：Java旧世界的枚举器(Enumeration)和Java新世界的迭代器(Iterator)
 * @author wxh
 * @version $Id: Turkey.java, v 0.1 2017年5月22日 上午10:14:26 wxh Exp $
 */
public interface Turkey {
    /**
     * 不像鸭子呱呱叫，而是咯咯叫
     */
    public void gobble();

    /**
     * 会飞，飞不远
     */
    public void fly();
}

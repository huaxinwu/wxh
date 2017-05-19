/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式案例四：工厂方法模式(factory method pattern,定义了一个创建对象的接口，但由子类决定实例化的类是哪一个，工厂方法让类把实例化推迟到子类。)
 * 
 * 披萨店应用：根据用户选择不同风味的披萨，展示不同的订单信息。
 * 工厂方法是通过让子类决定该创建的对象是什么，来达到将对象创建的过程封装的目的。
 * 工厂方法用来处理对象的创建，并将这些行为封装在子类中，这样，客户程序中关于超类代码和子类的创建代码就解耦了。
 * 工厂方法是抽象的，该方法必须返回一个超类中定义的方法，该方法需要参数，也可能不需要参数。
 * 
 * 依赖倒置原则：要依赖抽象，不要依赖具体类。
 * 1.变量不可以持有具体类的引用
 * 2.不要让类派生自具体类
 * 3.不要覆盖基类中已实现的方法
 * 
 * 创建者类--抽象创建者类
 * @author wxh
 * @version $Id: PizzaStore.java, v 0.1 2017年4月17日 下午4:22:43 wxh Exp $
 */
public abstract class PizzaStore {
    //    SimplePizzaFactory factory;

    /**
     * 把传进来参数实例化到本类成员变量中
     */
    //    public PizzaStore(SimplePizzaFactory factory) {
    //        this.factory = factory;
    //    }

    /**
     * 按类型预定披萨
     * @param type
     * @return
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = null;
        //        pizza = factory.createPizza(type);
        pizza = createPizza(type);
        // 准备
        pizza.prepare();
        // 烘烤
        pizza.bake();
        // 切片
        pizza.cut();
        // 装盒
        pizza.box();

        return pizza;
    }

    /**
     * 制作披萨
     * 工厂对象的方法移到这里
     * 工厂方法
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);
}

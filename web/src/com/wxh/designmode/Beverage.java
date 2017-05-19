/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 设计模式案例三：装饰者模式(decorate,动态地将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的替代方案。)
 * 
 * 星巴兹咖啡店应用：客人点咖啡，饮料订单计算即时更新，达到饮料供应要求。
 * 装饰者模式针对的基础来是抽象类。
 * 装饰者该做的事情，就是增加行为到被装饰的对象上
 * @author wxh
 * @version $Id: Beverage.java, v 0.1 2017年4月17日 上午11:00:06 wxh Exp $
 */
public abstract class Beverage {
    /** 描述 */
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 计算饮料+配料的价格
     * @return double
     */
    public abstract double cost();

}

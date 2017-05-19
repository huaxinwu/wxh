/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 调料类取代饮料类
 * 调料装饰者都必须重现getDescription方法？
 * @author wxh
 * @version $Id: Condiment.java, v 0.1 2017年4月17日 上午11:15:49 wxh Exp $
 */
public abstract class CondimentDecorator extends Beverage {

    /** 
     * 获取饮料描述
     * @return
     * @see com.wxh.designmode.Beverage#getDescription()
     */
    public abstract String getDescription();
}

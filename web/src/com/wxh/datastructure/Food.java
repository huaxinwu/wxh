/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 接口：只能是常量和抽象方法,对于方法会自动隐藏public abstract关键字，对于变量都会自动加上public static fianl
 * @author wxh
 * @version $Id: Food.java, v 0.1 2017年11月16日 下午3:23:51 wxh Exp $
 */
public interface Food {
    /** 常量 */
    public static final String NAME = "张三";
    /** 都会自动加上public static final  */
    Integer                    AGE  = 18;

    /**
     * 保健功能
     */
    void Healthcare();

    /**
     * 营养功能
     */
    public abstract void Nutrition();

}

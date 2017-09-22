/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.io.ObjectStreamException;

/**
 * 实现singleton两种方法：1.提供一个静态最终类实例对象，2.提供一个静态工厂方法获取类的实例对象
 * 
 * @author wxh
 * @version $Id: Elvis.java, v 0.1 2017年9月5日 上午11:33:17 wxh Exp $
 */
public class Elvis {
    // 静态成员变量,确信该类永远是单利，使用它
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        System.out.println("private construtor");
    }

    /**
     * 静态工厂方法
     * @return Elvis
     */
    public static Elvis getInstance() {
        return INSTANCE;
    }

    /**
     * 为了维护singleton性，你必须提供一个readResolve方法，否则，
     * 一个序列化实例在每次被反序列化时候都会创建一个新的实例对象。
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}

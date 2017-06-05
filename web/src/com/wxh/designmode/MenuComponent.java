/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.util.Iterator;

/**
 * 设计模式十二：组合模式(允许你将对象组合成树形结构来表现整体部分层次结构，组合能让客户以一致的方式处理个别对象以及对象组合。)
 * @author wxh
 * @version $Id: MenuComponent.java, v 0.1 2017年6月2日 下午2:18:55 wxh Exp $
 */
public abstract class MenuComponent {
    /**
     * 添加菜单组件
     * @param menuComponent
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除菜单组件
     * @param menuComponent
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取子菜单
     * @param i
     * @return
     */
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取名称
     * @return
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取描述
     * @return
     */
    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取价格
     * @return
     */
    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    /**
     * 是否是素食
     * @return
     */
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    /**
     * 打印
     */
    public void print() {
        throw new UnsupportedOperationException();
    }

    /**
     * 创建一个迭代器
     * @return
     */
    public Iterator createIterator() {
        throw new UnsupportedOperationException();
    }
}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 查找表接口定义
 * 在查找表中除了可以完成查找操作，还可以动态的改变查找表中的数据元素，即可以进行插入和删除的操作
 * @author wxh
 * @version $Id: SearchTable.java, v 0.1 2017年12月6日 下午4:23:43 wxh Exp $
 */
public interface SearchTable {

    /**
     * 获取查找表的当前规模
     * @return
     */
    int getSize();

    /**
     * 判断查找表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 找到返回查找表中与元素ele关键字相同的元素位置，没有找到，返回null
     * @param ele
     * @return
     */
    Node search(Object ele);

    /**
     * 返回查找表中所有关键字与元素ele相同的元素位置
     * @param ele
     * @return
     */
    Iterator searchAll(Object ele);

    /**
     * 将元素ele插入到查找表中
     * @param ele
     */
    void insert(Object ele);

    /**
     * 若查找表中存在与元素ele关键字相同的元素，则删除一个并返回，否则返回null
     * @param ele
     * @return
     */
    Object remove(Object ele);
}

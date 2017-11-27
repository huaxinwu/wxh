/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 单链表实现线性表
 * @author wxh
 * @version $Id: ListSLinked.java, v 0.1 2017年11月21日 上午11:35:32 wxh Exp $
 */
public class ListSLinked implements List {

    private Strategy strategy;
    /** 单链表首结点引用 */
    private SLNode   head;
    /** 线性表的数据元素个数  */
    private int      size;

    /**
     * 辅助方法：获取数据元素的前驱结点
     * @param e
     * @return SLNode
     */
    private SLNode getPrevNode(Object e) {
        // 单链表查找都是从头结点开始
        SLNode p = head;
        while (p.getNext() != null) {
            // 如果头结点的下一个结点数据域内容和传入参数内容相同，则头结点就是传入参数的前驱结点
            if (strategy.equals(p.getNext().getData(), e)) {
                return p;
            } else {
                return p.getNext();
            }
        }
        return null;
    }

    /**
     * 辅助方法：获取指定位置的数据元素的前驱结点
     * @param i
     * @return SLNode
     */
    private SLNode getPrevNode(int i) {
        SLNode p = head;
        // 0<=i<=size
        for (; i > 0; i--) {
            // 遍历，头结点下一个结点，如此循环找到
            p = p.getNext();
        }
        return p;
    }

    /**
     * 辅助方法：获取指定位置的数据元素结点
     * @param i
     * @return
     */
    private SLNode getNode(int i) {
        SLNode p = head.getNext();
        // 0<=i<=size
        for (; i > 0; i--) {
            // 遍历，该结点下一个结点，如此循环找到
            p = p.getNext();
        }
        return p;
    }

    /**
     * 初始化数据
     */
    public ListSLinked(Strategy strategy) {
        this.strategy = strategy;
        this.head = new SLNode();
        this.size = 0;
    }

    /** 
     * 获取线性表的数据元素个数
     * @return
     * @see com.wxh.datastructure.List#getSize()
     */
    @Override
    public int getSize() {
        return size;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.List#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** 
     * @param o
     * @return
     * @see com.wxh.datastructure.List#contains(java.lang.Object)
     */
    @Override
    public boolean contains(Object o) {
        SLNode p = head.getNext();
        // 单链表尾结点的next引用为Null
        while (p != null) {
            if (strategy.equals(p.getData(), o)) {
                return true;
            } else {
                // 赋值给下一个结点，在去比较
                p = p.getNext();
            }
        }
        return false;
    }

    /** 
     * @param o
     * @return
     * @see com.wxh.datastructure.List#indexOf(java.lang.Object)
     */
    @Override
    public int indexOf(Object o) {
        SLNode p = head.getNext();
        int index = 0;
        // 单链表尾结点next引用为null是临界条件
        while (p != null) {
            if (strategy.equals(p.getData(), o)) {
                return index;
            } else {
                index++;
                p = p.getNext();
            }
        }
        // 没有找到，返回-1
        return -1;
    }

    /** 
     * @param i
     * @param o
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#insert(int, java.lang.Object)
     */
    @Override
    public void insert(int i, Object o) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        // 获取指定位置的数据元素的前驱结点
        SLNode p = getPrevNode(i);
        // 创建一个新结点
        SLNode q = new SLNode(o, p.getNext());
        // 把p指针域指向q结点
        p.setNext(q);
        size++;
    }

    /** 
     * 因为不能在头结点插入一个结点，头结点没有数据域
     * @param obj
     * @param o
     * @return
     * @see com.wxh.datastructure.List#insertBefore(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean insertBefore(Object obj, Object o) {
        // 获取数据域为obj的前驱结点
        SLNode p = getPrevNode(obj);
        if (p != null) {
            // 创建一个新结点
            SLNode q = new SLNode(o, p.getNext());
            p.setNext(q);
            size++;
            return true;
        }
        return false;
    }

    /** 
     * @param obj
     * @param o
     * @return
     * @see com.wxh.datastructure.List#insertAfter(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean insertAfter(Object obj, Object o) {
        SLNode p = head.getNext();
        while (p != null) {
            if (strategy.equals(p.getData(), obj)) {
                SLNode q = new SLNode(o, p.getNext());
                p.setNext(q);
                size++;
                return true;
            } else {
                p = p.getNext();
            }
        }
        return false;
    }

    /** 
     * @param i
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#remove(int)
     */
    @Override
    public Object remove(int i) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        SLNode p = getPrevNode(i);
        Object obj = p.getNext().getData();
        // 把p指针域指向p的下一个结点的下一个结点
        p.setNext(p.getNext().getNext());
        size--;
        return obj;
    }

    /** 
     * @param o
     * @return
     * @see com.wxh.datastructure.List#remove(java.lang.Object)
     */
    @Override
    public boolean remove(Object o) {
        SLNode p = getPrevNode(o);
        if (p != null) {
            p.setNext(p.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    /** 
     * @param i
     * @param o
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#replace(int, java.lang.Object)
     */
    @Override
    public Object replace(int i, Object o) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        // 获取指定位置的数据元素结点
        SLNode p = getNode(i);
        // 更新数据域
        p.setData(o);
        return p.getData();
    }

    /** 
     * @param i
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.List#get(int)
     */
    @Override
    public Object get(int i) throws OutOfBoundsException {
        if (i < 0 || i > size) {
            throw new OutOfBoundsException("插入序号越界");
        }
        SLNode p = getNode(i);
        return p.getData();
    }

}

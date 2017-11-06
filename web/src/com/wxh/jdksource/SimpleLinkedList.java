/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jdksource;

/**
 * 模仿LinkedList自定义集合
 * 双向链表：数据结构： 0x14212             htone             0x14551121
 *                  上一个节点引用地址               当前节点的数据                    下一个节点引用地址
 * @author wxh
 * @version $Id: SimpleLinkedList.java, v 0.1 2017年10月30日 下午4:09:46 wxh Exp $
 */
public class SimpleLinkedList<T> {
    /** 集合容量大小  */
    private int     size     = 0;

    /** 用来记录集合中修改元素时候次数  */
    private int     modCount = 0;

    /** 第一个节点 */
    private Node<T> firstNode;
    /** 最后一个节点  */
    private Node<T> lastNode;

    /**
     * 静态内部类
     */
    private static class Node<T> {
        T       dataItem;
        Node<T> prevNode;
        Node<T> nextNode;

        Node(Node<T> prevNode, T dataItem, Node<T> nextNode) {
            this.prevNode = prevNode;
            this.dataItem = dataItem;
            this.nextNode = nextNode;
        }
    }

    /**
     * 根据索引获取一个节点
     * @param index
     * @return
     */
    private Node<T> node(int index) {
        // 是否小于中间节点
        if (index < (size >> 1)) {
            Node<T> xNode = firstNode;
            for (int i = 0; i < index; i++) {
                xNode = xNode.nextNode;
            }
            return xNode;
        } else {
            Node<T> xNode = lastNode;
            for (int i = size - 1; i > index; i--) {
                xNode = xNode.prevNode;
            }
            return xNode;
        }
    }

    /**
     * 检查index是否在规定范围里
     * @param index
     */
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 在集合的最后一个元素后面添加新元素
     * @param t
     */
    private void linkLast(T t) {
        // 将最后一个节点赋值给l
        final Node<T> l = lastNode;
        // 创建一个新节点,将最后一个节点充当新节点上一个节点，添加内容为新节点的数据，没有下一个节点设置为Null
        final Node<T> newNode = new Node(l, t, null);
        // 将这个新节点设置为最后一个节点
        lastNode = newNode;
        if (l == null) {
            // 如果最后一个节点没有数据，将其设置为第一个节点
            firstNode = newNode;
        } else {
            // 将最后一个节点引用指向新节点
            l.nextNode = newNode;
        }
        // 容量和记录数都加1
        size++;
        modCount++;

    }

    /**
     * 切断它与相邻节点
     * @param node
     * @return
     */
    private T unlink(Node<T> node) {
        final T dataItem = node.dataItem;
        final Node<T> prev = node.prevNode;
        final Node<T> next = node.nextNode;
        /*
         * 如果传入参数的上一个节点为空，就将下一个节点设置为第一个节点,
         * 否则上一个节点的下一个节点引用指向next,并设置传入参数上一个节点为空断开关联
         */
        if (prev == null) {
            firstNode = next;
        } else {
            prev.nextNode = next;
            node.prevNode = null;
        }

        /*
         * 如果传入参数下一个节点为空，就将上一个节点设置为最后一个节点,
         * 否则下一个节点的上一个节点引用指向prev,并设置传入参数下一个节点为空断开关联
         */
        if (next == null) {
            lastNode = prev;
        } else {
            next.prevNode = prev;
            node.nextNode = null;
        }
        // 数据清空,让GC回收
        node.dataItem = null;
        size--;
        modCount++;
        return dataItem;
    }

    /**
     * 获取集合元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断集合是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * 添加元素
     * @param t
     * @return
     */
    public boolean add(T t) {
        linkLast(t);
        return true;
    }

    /**
     * 移除元素
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            // 从第一个节点开始遍历，依次获取下一个节点循环{
            for (Node<T> xNode = firstNode; xNode != null; xNode = xNode.nextNode) {
                if (xNode.dataItem == null) {
                    // 没有数据,切断它与相邻节点
                    unlink(xNode);
                    return true;
                }
            }
        } else {
            for (Node<T> xNode = firstNode; xNode != null; xNode = xNode.nextNode) {
                if (o.equals(xNode.dataItem)) {
                    // 没有数据,切断它与相邻节点
                    unlink(xNode);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 根据索引获取元素
     * @param index
     * @return
     */
    public T get(int index) {
        checkElementIndex(index);
        // 节点的数据域
        return node(index).dataItem;
    }

}

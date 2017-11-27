/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 基于双向链表实现链接表
 * @author wxh
 * @version $Id: LinkedListDLNode.java, v 0.1 2017年11月22日 下午1:47:57 wxh Exp $
 */
public class LinkedListDLNode implements LinkedList {

    /** 链接表的数据元素个数  */
    private int    size;
    /** 头结点  */
    private DLNode head;
    /** 尾结点  */
    private DLNode tail;

    /**
     * 辅助方法：判断结点p是否合法，如果合法转换为DLNode
     * @param p
     * @return
     * @throws InvalidNodeException
     */
    protected DLNode checkPosition(Node p) throws InvalidNodeException {
        if (p == null) {
            throw new InvalidNodeException("传入的结点为空");
        }
        if (p == head) {
            throw new InvalidNodeException("传入的结点指向头结点，非法");
        }
        if (p == tail) {
            throw new InvalidNodeException("传入的结点指向尾结点，非法");
        }
        DLNode node = (DLNode) p;
        return node;
    }

    /**
     * 初始化参数
     */
    public LinkedListDLNode() {
        size = 0;
        // 构建只有头结点和尾结点的双向链表
        head = new DLNode();
        tail = new DLNode();
        head.setNext(tail);
        tail.setPrev(head);
    }

    /** 
     * @return
     * @see com.wxh.datastructure.LinkedList#getSize()
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.LinkedList#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** 
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.LinkedList#first()
     */
    @Override
    public Node first() throws OutOfBoundsException {
        if (this.isEmpty()) {
            throw new OutOfBoundsException("链接表为空");
        }
        return head.getNext();
    }

    /** 
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.LinkedList#last()
     */
    @Override
    public Node last() throws OutOfBoundsException {
        if (this.isEmpty()) {
            throw new OutOfBoundsException("链接表为空");
        }
        return tail.getPrev();
    }

    /** 
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.LinkedList#getNext(com.wxh.datastructure.Node)
     */
    @Override
    public Node getNext(Node p) throws InvalidNodeException, OutOfBoundsException {
        // 检验结点p是否合法
        DLNode node = checkPosition(p);
        // 获取下一个结点
        node = node.getNext();
        if (node == tail) {
            throw new OutOfBoundsException("已经是链接表的尾端了");
        }
        return node;
    }

    /** 
     * @param p
     * @return
     * @throws InvalidNodeException
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.LinkedList#getPrev(com.wxh.datastructure.Node)
     */
    @Override
    public Node getPrev(Node p) throws InvalidNodeException, OutOfBoundsException {
        // 检验结点p是否合法
        DLNode node = checkPosition(p);
        // 获取上一个结点
        node = node.getPrev();
        if (node == head) {
            throw new OutOfBoundsException("已经是链接表的首端了");
        }
        return node;
    }

    /** 
     * @param o
     * @return
     * @see com.wxh.datastructure.LinkedList#insertFirst(java.lang.Object)
     */
    @Override
    public Node insertFirst(Object o) {
        // 创建一个新结点
        DLNode node = new DLNode(head, o, head.getNext());
        // 设置头结点的下一个结点的前驱结点为新建结点
        head.getNext().setPrev(node);
        // 设置头结点的下一个结点为新建结点
        head.setNext(node);
        size++;
        return node;
    }

    /** 
     * @param o
     * @return
     * @see com.wxh.datastructure.LinkedList#insertLast(java.lang.Object)
     */
    @Override
    public Node insertLast(Object o) {
        // 创建一个新结点
        DLNode node = new DLNode(tail.getPrev(), o, tail);
        // 设置尾结点的上一个结点的后继结点为新建结点
        tail.getPrev().setNext(node);
        // 设置尾结点的上一个结点为新建结点
        tail.setPrev(node);
        size++;
        return node;
    }

    /** 
     * @param p
     * @param o
     * @return
     * @throws InvalidNodeException
     * @see com.wxh.datastructure.LinkedList#insertAfter(com.wxh.datastructure.Node, java.lang.Object)
     */
    @Override
    public Node insertAfter(Node p, Object o) throws InvalidNodeException {
        // 检验结点p是否合法
        DLNode node = checkPosition(p);
        // 创建一个新结点
        DLNode newNode = new DLNode(node, o, node.getNext());
        // 被插入的结点的下一个结点的前驱结点为新建结点
        node.getNext().setPrev(newNode);
        // 被插入的结点的下一个结点为新建结点
        node.setNext(newNode);
        size++;
        return newNode;
    }

    /** 
     * @param p
     * @param o
     * @return
     * @throws InvalidNodeException
     * @see com.wxh.datastructure.LinkedList#insertBefore(com.wxh.datastructure.Node, java.lang.Object)
     */
    @Override
    public Node insertBefore(Node p, Object o) throws InvalidNodeException {
        // 检验结点p是否合法
        DLNode node = checkPosition(p);
        // 创建一个新结点
        DLNode newNode = new DLNode(node.getPrev(), o, node);
        // 被插入的结点上一个结点的后继结点为新建结点
        node.getPrev().setNext(newNode);
        // 被插入的结点上一个结点为新建结点
        node.setPrev(newNode);
        size++;
        return newNode;
    }

    /** 
     * @param p
     * @return
     * @throws InvalidNodeException
     * @see com.wxh.datastructure.LinkedList#remove(com.wxh.datastructure.Node)
     */
    @Override
    public Object remove(Node p) throws InvalidNodeException {
        // 判断结点不能是头结点。也不能是尾结点
        DLNode node = checkPosition(p);
        // 获取数据域
        Object obj = node.getData();
        // 设置被删除的结点上一个结点的后继结点为被删除结点的下一个结点
        node.getPrev().setNext(node.getNext());
        // 设置被删除的结点下一个结点的前驱结点为被删除结点的上一个结点
        node.getNext().setPrev(node.getPrev());
        size--;
        return obj;
    }

    /** 
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.LinkedList#removeFirst()
     */
    @Override
    public Object removeFirst() throws OutOfBoundsException {
        // 删除头结点的下一个结点为第一个结点
        return remove(head.getNext());
    }

    /** 
     * @return
     * @throws OutOfBoundsException
     * @see com.wxh.datastructure.LinkedList#removeLast()
     */
    @Override
    public Object removeLast() throws OutOfBoundsException {
        // 删除尾结点的上一个结点为最后一个结点
        return remove(tail.getPrev());
    }

    /** 
     * @param p
     * @param o
     * @return
     * @throws InvalidNodeException
     * @see com.wxh.datastructure.LinkedList#replace(com.wxh.datastructure.Node, java.lang.Object)
     */
    @Override
    public Object replace(Node p, Object o) throws InvalidNodeException {
        DLNode node = checkPosition(p);
        Object obj = node.getData();
        // 更新数据域
        node.setData(o);
        return obj;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.LinkedList#elements()
     */
    @Override
    public Iterator elements() {
        return new LinkedListIterator(this);
    }

}

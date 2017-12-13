/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 双向链表实现的链接表应用二叉树基本操作：遍历、查找
 * @author wxh
 * @version $Id: BinaryTreeLinked.java, v 0.1 2017年11月29日 下午2:49:33 wxh Exp $
 */
public class BinaryTreeLinked {
    /** 二叉树根节点 */
    private BinaryTreeNode root;
    /** 比较策略  */
    private Strategy       strategy;

    /**
     * 先序遍历的递归算法实现--先访问根结点，再遍历左子树，再遍历右子树
     * @param node 二叉树的根结点
     * @param list 链接表来存放遍历出来树的结点
     */
    private void preOrderRecursion(BinaryTreeNode root, LinkedList list) {
        if (root == null) {
            // 如果根结点为空，程序直接结束
            return;
        }
        // 插入到链接表的尾部--先插入根结点、再左子树结点，再右子树结点
        list.insertLast(root);
        // 遍历左子树
        preOrderRecursion(root.getLChild(), list);
        // 遍历右子树
        preOrderRecursion(root.getRChild(), list);
    }

    /**
     * 先序遍历二叉树的非递归算法实现--先访问根结点，再遍历左子树，再遍历右子树
     * @param root 二叉树的根结点
     * @param list 链接表来存放遍历出来树的结点
     */
    private void preOrderTraverse(BinaryTreeNode root, LinkedList list) {
        if (root == null) {
            // 如果根结点为空，程序直接结束
            return;
        }
        // 重新声明一个二叉树结点，指向这个结点
        BinaryTreeNode p = root;
        // 创建一个单链表实现的栈
        Stack stack = new StackSLinked();
        // 遍历
        while (p != null) {
            // 遍历左子树，向左走到尽头，将沿途根结点插入到链接表中
            while (p != null) {
                // 插入到链接表尾部--先根结点，再左子树结点，再右子树结点出栈后插入链接表
                list.insertLast(p);
                if (p.hasRChild()) {
                    // 右子树的结点入栈
                    stack.push(p.getRChild());
                }
                // 指向左子树结点
                p = p.getLChild();
            }
            // 遍历右子树栈顶元素出栈
            if (!stack.isEmpty()) {
                // 右子树结点出栈
                p = (BinaryTreeNode) stack.pop();
            }
        }
    }

    /**
     * 中序遍历二叉树的非递归算法实现--先遍历左子树，再访问根结点，再遍历右子树
     * @param node 二叉树的根结点
     * @param list 链接表来存放遍历出来树的结点
     */
    private void inOrderTraverse(BinaryTreeNode root, LinkedList list) {
        if (root == null) {
            // 如果根结点为空，程序直接结束
            return;
        }
        // 重新声明一个二叉树结点，指向这个结点
        BinaryTreeNode p = root;
        // 创建一个单链表实现的栈
        Stack stack = new StackSLinked();
        // 遍历
        while (p != null || !stack.isEmpty()) {
            // 遍历左子树，一直向左走，将沿途的根结点入栈
            while (p != null) {
                // 将结点入栈--先根结点，再左子树结点
                stack.push(p);
                // 指向左子树结点
                p = p.getLChild();
            }
            // 栈顶根结点出栈，插入到链接表中，指向右子树结点
            if (!stack.isEmpty()) {
                // 栈顶元素出栈，栈底存放的是根结点，其余是左子树的结点
                p = (BinaryTreeNode) stack.pop();
                // 插入到链接表尾部--先左子树结点，再根结点，再
                list.insertLast(p);
                // 指向右子树结点
                p = p.getRChild();
            }
        }
    }

    /**
     * 后序遍历二叉树的非递归算法实现--先遍历左子树，再遍历右子树，再访问根结点
     * @param node 二叉树的根结点
     * @param list 链接表来存放遍历出来树的结点
     */
    private void postOrderTraverse(BinaryTreeNode node, LinkedList list) {
        if (node == null) {
            // 如果根结点为空，程序直接结束
            return;
        }
        // 重新声明一个二叉树结点,指向这个结点
        BinaryTreeNode p = node;
        // 创建一个单链表实现的栈
        Stack stack = new StackSLinked();
        // 遍历
        while (p != null || !stack.isEmpty()) {
            // 先左后右不断深入,将沿途根结点入栈
            while (p != null) {
                // 将沿途的根结点入栈
                stack.push(p);
                if (p.hasLChild()) {
                    // 指向左子树结点，遍历左子树
                    p = p.getLChild();
                } else {
                    // 指向右子树结点，遍历右子树
                    p = p.getRChild();
                }
            }
            // 获取栈顶的根结点，插入到链接表中
            if (!stack.isEmpty()) {
                // 根结点出栈
                p = (BinaryTreeNode) stack.pop();
                // 插入到链接表
                list.insertLast(p);
            }
            // 栈顶元素和当前结点指向同一个引用地址，栈顶元素出栈
            while (!stack.isEmpty() && ((BinaryTreeNode) stack.peek()).getRChild() == p) {
                p = (BinaryTreeNode) stack.pop();
                list.insertLast(p);
            }
            // 转向栈顶元素的右子树继续后序遍历
            if (!stack.isEmpty()) {
                // 指向右子树结点
                p = ((BinaryTreeNode) stack.peek()).getRChild();
            } else {
                // 设置引用为空
                p = null;
            }
        }
    }

    /**
     * 层次遍历二叉树的队列实现
     * @param root 二叉树根结点
     * @param list 链接表来存放遍历出来树的结点
     */
    private void leverOrderTraverse(BinaryTreeNode root, LinkedList list) {
        if (root == null) {
            // 如果根结点为空，程序直接结束
            return;
        }// 创建一个对象数组实现的队列
        Queue queue = new QueueArray();
        // 根结点入队
        queue.enqueue(root);
        // 遍历
        while (!queue.isEmpty()) {
            // 队首出队并指向一个二叉树结点
            BinaryTreeNode p = (BinaryTreeNode) queue.dequeue();
            // 插入到链接表尾部
            list.insertLast(p);
            if (p.hasLChild()) {
                // 左子树结点队尾入队
                queue.enqueue(p.getLChild());
            }
            if (p.hasRChild()) {
                // 右子树结点队尾入队
                queue.enqueue(p.getRChild());
            }
        }
    }

    /**
     * 递归查找二叉树的某个结点
     * @param root
     * @param o
     * @return BinaryTreeNode
     */
    private BinaryTreeNode searchElement(BinaryTreeNode root, Object o) {
        if (root == null) {
            // 如果根节点为空，直接返回空
            return null;
        }
        // 如果根结点的数据域和传入参数内容一样，则返回对应结点
        if (strategy.equals(root.getData(), o)) {
            return root;
        }
        // 否则，递归在左子树中查找数据元素o
        BinaryTreeNode p = searchElement(root.getLChild(), o);
        // 如果在左子树结点中没有找到数据元素为o的结点，去右子树中查找
        if (p == null) {
            p = searchElement(root.getRChild(), o);
        }
        return p;
    }

    /**
     * 算法：preOrder--先序遍历二叉树
     * 输入：无
     * 输出：迭代器对象，先序遍历二叉树的结果
     * @param root
     * @return Iterator
     */
    public Iterator preOrder() {
        // 使用双向链表实现的链接表
        LinkedList list = new LinkedListDLNode();
        // 1.递归遍历二叉树
        preOrderRecursion(this.root, list);
        // 2.非递归遍历二叉树
        preOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 算法：inOrder--中序遍历二叉树
     * 输入：无
     * 输出：迭代器对象，中序遍历二叉树的结果
     * @param root
     * @return Iterator
     */
    public Iterator inOrder() {
        // 使用双向链表实现的链接表
        LinkedList list = new LinkedListDLNode();
        // 非递归遍历二叉树
        inOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 算法：postOrder--后序遍历二叉树
     * 输入：无
     * 输出：迭代器对象，后序遍历二叉树的结果
     * @param root
     * @return Iterator
     */
    public Iterator postOrder() {
        // 使用双向链表实现的链接表
        LinkedList list = new LinkedListDLNode();
        // 非递归遍历二叉树
        postOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 算法：leverOrder--层次遍历二叉树
     * 输入：无
     * 输出：迭代器对象，层次遍历二叉树的结果
     * @param root
     * @return Iterator
     */
    public Iterator leverOrder() {
        // 使用链接表
        LinkedList list = new LinkedListDLNode();
        // 层次遍历二叉树
        leverOrderTraverse(this.root, list);
        return list.elements();
    }

    /**
     * 算法：find--查找二叉树某个结点
     * 输入：一个数据元素
     * 输出：一个二叉树结点
     * @param root
     * @param o
     * @return BinaryTreeNode
     */
    public BinaryTreeNode find(Object o) {
        // 递归查找二叉树某个结点
        return searchElement(this.root, o);
    }

}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 二叉树链式存储结构的结点定义
 * 链式存储：二叉链表：数据域、左孩子域、右孩子域
 * 三叉链表：数据域、左孩子域、父亲域、右孩子域
 * @author wxh
 * @version $Id: BinaryTreeNode.java, v 0.1 2017年11月28日 上午10:26:44 wxh Exp $
 */
public class BinaryTreeNode implements Node {

    /** 数据域  */
    private Object         data;
    /** 父亲域  */
    private BinaryTreeNode parent;
    /** 左孩子域  */
    private BinaryTreeNode lChild;
    /** 右孩子域  */
    private BinaryTreeNode rChild;

    /** 以该结点为根的子树的高度 (树的最大层次数)   */
    private int            height;
    /** 该结点的子孙数，包括自己(结点拥有子树的数目) */
    private int            size;

    /**
     * @param o
     */
    public BinaryTreeNode(Object o) {
        this.data = o;
    }

    /** 
     * @return
     * @see com.wxh.datastructure.Node#getData()
     */
    @Override
    public Object getData() {
        return data;
    }

    /** 
     * @param obj
     * @see com.wxh.datastructure.Node#setData(java.lang.Object)
     */
    @Override
    public void setData(Object obj) {
        data = obj;
    }

    /**
     * 辅助方法：判断是否有父亲结点
     * @return boolean
     */
    public boolean hasParent() {
        return parent != null;
    }

    /**
     * 辅助方法：判断是否有左孩子结点
     * @return boolean
     */
    public boolean hasLChild() {
        return lChild != null;
    }

    /**
     * 辅助方法：判断是否有右孩子结点
     * @return boolean
     */
    public boolean hasRChild() {
        return rChild != null;
    }

    /**
     * 辅助方法：判断是否为叶子结点(没有左孩子和右孩子的结点)
     * @return boolean
     */
    public boolean isLeaf() {
        return !hasLChild() && !hasRChild();
    }

    /**
     * 辅助方法：判断是否为某个结点的左孩子结点
     * 先判断有父亲结点，在判断当前结点与父亲结点的左孩子结点指向同一个引用地址
     * @return boolean
     */
    public boolean isLChild() {
        return (hasParent() && this == parent.lChild);
    }

    /**
     * 辅助方法：判断是否为某个结点的右孩子结点
     * 先判断有父亲结点，在判断当前结点与父亲结点的右孩子结点指向同一个引用地址
     * @return
     */
    public boolean isRChild() {
        return (hasParent() && this == parent.rChild);
    }

    /**
     * height方法：获取结点的高度(以该结点为根的树的高度)
     * @return int
     */
    public int getHeight() {
        return height;
    }

    /**
     * height方法：更新当前结点及其祖先的高度
     */
    public void updateHeight() {
        // 新高度初始化为0
        int newHeight = 0;
        if (hasLChild()) {
            // 如果有左孩子，新高度与左孩子高度加上1比较，取最大值赋值给变量newHeight
            newHeight = Math.max(newHeight, getLChild().getHeight() + 1);
        }
        if (hasRChild()) {
            // 如果有右孩子，新高度与右孩子高度加上1比较，取最大值赋值给变量newHeight
            newHeight = Math.max(newHeight, getRChild().getHeight() + 1);
        }
        if (newHeight == height) {
            // 高度没有发生变化则直接返回
            return;
        }
        // 否则更新高度
        height = newHeight;
        if (hasParent()) {
            // 如果有祖先，递归更新祖先的高度
            getParent().updateHeight();
        }
    }

    /**
     * size方法：获取以该结点为根的树的结点数
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * size方法：更新当前结点及其祖先的子孙数
     */
    public void updateSize() {
        // 树的结点数的初始化
        size = 1;
        if (hasLChild()) {
            // 如果有左孩子，加上左孩子树的结点数
            size += getLChild().getSize();
        }
        if (hasRChild()) {
            // 如果有右孩子，加上右孩子树的结点数
            size += getRChild().getSize();
        }
        if (hasParent()) {
            // 如果有祖先，递归更新祖先的结点数
            getParent().updateSize();
        }
    }

    /**
     * parent方法：获取父亲结点
     * @return BinaryTreeNode
     */
    public BinaryTreeNode getParent() {
        return parent;
    }

    /**
     * parent方法：断开与父亲结点的关系
     */
    public void sever() {
        if (!hasParent()) {
            // 如果没有父亲结点，程序直接结束
            return;
        }
        // 如果是左孩子结点，设置为空，否则右孩子结点设置为空
        if (isLChild()) {
            // 底层调用System.gc()
            parent.lChild = null;
        } else {
            parent.rChild = null;
        }
        // 更新父结点及其祖先高度
        parent.updateHeight();
        // 更新父结点及其祖先结点数
        parent.updateSize();
        // 没有孩子结点
        parent = null;
    }

    /**
     * lChild方法：获取左孩子结点
     * @return BinaryTreeNode
     */
    public BinaryTreeNode getLChild() {
        return lChild;
    }

    /**
     * lChild方法：设置当前结点的左孩子结点,返回原左孩子结点
     * @param lc
     * @return BinaryTreeNode
     */
    public BinaryTreeNode setLChild(BinaryTreeNode lc) {
        BinaryTreeNode oldLC = this.lChild;
        if (hasLChild()) {
            // 断开当前左孩子结点与当前结点的关系
            lChild.sever();
        }
        if (lc != null) {
            // 断开lc与其父亲结点的关系
            lc.sever();
            // 建立父子关系
            lc.parent = this;
            this.lChild = lc;
            // 更新当前结点及其祖先高度
            this.updateHeight();
            // 更新当前结点及其祖先结点数
            this.updateSize();
        }
        // 返回原左孩子结点，其实已经变成了lc,oldLC/lChild/lc三者指向了同一个引用地址
        return oldLC;
    }

    /**
     * rChild方法：获取右孩子结点
     * @return BinaryTreeNode
     */
    public BinaryTreeNode getRChild() {
        return rChild;
    }

    /**
     * rChild方法：设置当前结点的右孩子结点,返回原右孩子结点
     * @param rc
     * @return BinaryTreeNode
     */
    public BinaryTreeNode setRChild(BinaryTreeNode rc) {
        BinaryTreeNode oldRC = this.rChild;
        if (hasRChild()) {
            // 断开当前右孩子结点与当前结点的关系
            rChild.sever();
        }
        if (rc != null) {
            // 断开lc与其父亲结点的关系
            rc.sever();
            // 建立父子关系
            rc.parent = this;
            this.rChild = rc;
            // 更新当前结点及其祖先高度
            this.updateHeight();
            // 更新当前结点及其祖先结点数
            this.updateSize();
        }
        // 返回原右孩子结点，其实已经变成了rc,oldRC/rChild/rc三者指向了同一个引用地址
        return oldRC;
    }
}

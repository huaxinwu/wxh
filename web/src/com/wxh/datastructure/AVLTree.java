/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * AVL树：自平衡二叉查找树
 * AVL树操作：右旋(顺时针旋转)、左旋(逆时针旋转),调整失去平衡的二叉查找树,采用旋转(单旋或双旋)实现
 * @author wxh
 * @version $Id: AVLTree.java, v 0.1 2017年12月8日 上午11:04:52 wxh Exp $
 */
public class AVLTree extends BinarySearchTree {

    /**
     * 获取结点v的较高的子树(指高度最高的)
     * @param v
     * @return
     */
    private BinaryTreeNode higherSubTree(BinaryTreeNode v) {
        if (v == null) {
            // 如果结点v为空，返回空
            return null;
        }
        // 获取左子树高度,如果有左孩子，返回左孩子的高度，否则返回-1
        int lHigh = (v.hasLChild()) ? v.getLChild().getHeight() : -1;
        // 获取右子树高度，如果有右孩子，返回右孩子高度，否则返回-1
        int rHigh = (v.hasRChild()) ? v.getRChild().getHeight() : -1;
        // 左子树高度大于右子树高度，左子树是结点v较高的子树
        if (lHigh > rHigh) {
            return v.getLChild();
        }
        // 左子树高度小于右子树高度，右子树是结点v较高的子树
        if (lHigh < rHigh) {
            return v.getRChild();
        }
        if (v.isLChild()) {
            // 如果结点v是左孩子，另一个结点是右孩子，所以返回结点v的左孩子(高度最高)
            return v.getLChild();
        } else {
            // 如果结点v是右孩子，另一个结点是左孩子，所以返回结点v的右孩子(高度最高)
            return v.getRChild();
        }
    }

    /**
     * 判断一个结点是否失去平衡
     * 结点平衡的条件：结点为空或它的左右子树高度差不超过1
     * @param v
     * @return
     */
    private boolean isBalance(BinaryTreeNode v) {
        if (v == null) {
            // 如果结点v为空，表示失去平衡，返回true
            return true;
        }
        // 结点v左子树的高度
        int lHigh = (v.hasLChild()) ? v.getLChild().getHeight() : -1;
        // 结点v右子树的高度
        int rHigh = (v.hasRChild()) ? v.getRChild().getHeight() : -1;
        // 如果结点v左子树高度减去结点v右子树的高度的差值小于等于1
        return (Math.abs(lHigh - rHigh) <= 1);
    }

    /**
     * 从结点v开始重新平衡AVL树，返回平衡后结点
     * 一般是结点v的祖先失去平衡，逆流而上检查，最后调整
     * @param v
     * @return
     */
    private BinaryTreeNode reBalance(BinaryTreeNode v) {
        if (v == null) {
            // 如果结点v为空，返回根节点
            return root;
        }
        // 创建一个新的二叉树结点c指向结点v
        BinaryTreeNode c = v;
        // 从结点v开始，向上逐一检查结点v的祖先
        while (v != null) {
            // 如果结点v失去平衡，则旋转使之重新平衡
            if (!isBalance(v)) {
                // 平衡后的结点
                v = rotate(v);
            }
            // 结点c重新指向结点v
            c = v;
            // 继续检查结点v的父结点,并指向结点v
            v = v.getParent();
        }
        // 返回平衡后结点c
        return c;
    }

    /**
     * 算法：rotate--旋转算法
     * 输入：失去平衡的结点z
     * 输出：平衡后子树的根结点
     *      c
     *     /  \
     *    b     t3
     *   / \
     *   a  t2
     *  / \
     * t0 t1
     *  图一 
     *  
     *    c
     *   / \
     *   a  t3
     *  / \
     * t0  b
     *    / \
     *   t1  t2
     *   图二
     *   
     *    a
     *   / \
     *  t0  b
     *     / \
     *    t1  c
     *       / \
     *      t2 t3
     *   图三
     *   
     *    a
     *   / \
     *  t0  c
     *     / \
     *    b  t3
     *   / \
     *  t1  t2
     *   图四  
     *      
     *      p
     *     /
     *     b
     *   /   \
     *   a    c
     *  / \   / \
     * t0 t1 t2 t3
     *    图五
     * @param z
     * @return
     */
    public BinaryTreeNode rotate(BinaryTreeNode z) {
        // 取y为z高度更高的孩子
        BinaryTreeNode y = higherSubTree(z);
        // 取x为y高度更高的孩子
        BinaryTreeNode x = higherSubTree(y);
        // 标志位：记录结点z是否有左孩子
        boolean isLeft = z.isLChild();
        // 设置p为z的父结点
        BinaryTreeNode p = z.getParent();
        // 自左向右，三个节点
        BinaryTreeNode a, b, c;
        // 自左向右，四棵子树
        BinaryTreeNode t0, t1, t2, t3;
        // 失去平衡分四种情况重新命名
        if (y.isLChild()) {
            // 如果y是左孩子,则c就是z，t3是z的右孩子
            c = z;
            t3 = z.getRChild();
            if (x.isLChild()) {
                // 如图一情况
                // 若x是左孩子(左左失去平衡)
                b = y;
                // t2是y的右孩子
                t2 = y.getRChild();
                a = x;
                // t1是x的右孩子
                t1 = x.getRChild();
                t0 = x.getLChild();
            } else {
                // 如图二情况
                // 如果x是右孩子(左右失去平衡)
                a = y;
                // t0是y的左孩子
                t0 = y.getLChild();
                b = x;
                // t1是x的左孩子
                t1 = x.getLChild();
                t2 = x.getRChild();
            }
        } else {
            // 如果y是右孩子,则a就是z，t0是z的左孩子
            a = z;
            t0 = z.getLChild();
            if (x.isRChild()) {
                // 如图三情况
                // 如果x是右孩子(右右失去平衡)
                b = y;
                // t1是y的左孩子
                t1 = y.getLChild();
                c = x;
                // t2是x的左孩子
                t2 = x.getLChild();
                t3 = x.getRChild();
            } else {
                // 如果x是左孩子(左右失去平衡)
                c = y;
                // t3是y的右孩子
                t3 = y.getRChild();
                b = x;
                // t2是x的右孩子
                t2 = x.getRChild();
                t1 = x.getLChild();
            }
        }
        // 摘下三个结点,断开与父结点关系
        z.sever();
        y.sever();
        x.sever();
        // 摘下四棵树,断开与父结点关系
        if (t0 != null) {
            t0.sever();
        }
        if (t1 != null) {
            t1.sever();
        }
        if (t2 != null) {
            t2.sever();
        }
        if (t3 != null) {
            t3.sever();
        }
        // 重新将三个结点、四棵树连接起来
        // a的左右孩子为t0和t1
        a.setLChild(t0);
        a.setRChild(t1);
        // c的左右孩子为t2和t3
        c.setLChild(t2);
        c.setRChild(t3);
        // b的左右孩子为a和c
        b.setLChild(a);
        b.setRChild(c);
        // 子树重新接入原树
        if (p != null) {
            // 如图五情况
            // 如果结点p有左孩子，设置左孩子
            if (isLeft) {
                p.setLChild(b);
            } else {
                p.setRChild(b);
            }
        }
        // 返回新的子树根
        return b;
    }

    /**
     * 算法：insert--插入算法
     * 输入：待插入元素ele
     * 输出：在AVL树中插入元素ele
     * @param ele
     */
    public void insert(Object ele) {
        // 调用二叉查找树插入方法
        super.insert(ele);
        // 重新平衡AVL树，返回平衡后结点
        root = reBalance(startBN);
    }

    /** 
     * 算法：remove--删除算法
     * 输入：待删除元素ele
     * 输出：在AVL树中删除元素ele
     * @param ele
     * @return
     */
    public Object remove(Object ele) {
        // 调用二叉查找树的删除方法
        Object obj = super.remove(ele);
        // 重新平衡AVL树，返回平衡后结点
        root = reBalance(startBN);
        // 返回删除元素
        return obj;
    }

}

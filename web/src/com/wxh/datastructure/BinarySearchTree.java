/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 二叉查找树操作：查找、插入、删除
 * 查找功能：顺序查找和折半查找(二分查找)
 * @author wxh
 * @version $Id: BinarySearchTree.java, v 0.1 2017年12月7日 上午10:19:18 wxh Exp $
 */
public class BinarySearchTree {

    /** 二叉树根节点 */
    protected BinaryTreeNode root;
    /** 比较策略  */
    protected Strategy       strategy;
    /** 二叉树结点，用于平衡二叉树中实现平衡化操作而设 */
    protected BinaryTreeNode startBN;

    /**
     * 二叉查找树采用递归算法实现
     * 二叉查找树：是一颗空树，或者如果存在左子树不为空，左子树的结点值小于根结点的值，
     *      如果存在右子树不为空，右子树的结点值大于根结点的值，左子树和右子树都是二叉查找树
     * @param root
     * @param ele
     * @return
     */
    private Node binaryTreeSearchRecursion(BinaryTreeNode root, Object ele) {
        if (root == null) {
            // 如果根结点为空，直接返回空
            return null;
        }
        // 比较待查找元素和根结点的元素
        switch (strategy.compare(ele, root.getData())) {
            case 0:
                // 如果待查找元素和根结点的元素相等，返回根结点,根结点的位置就是带查找元素的位置
                return root;
            case -1:
                // 如果待查找元素小于根结点的元素,去根结点的左子树递归查找
                return binaryTreeSearchRecursion(root.getLChild(), ele);
            default:
                // 如果待查找元素大于根结点的元素，去根结点的右子树递归查找
                return binaryTreeSearchRecursion(root.getRChild(), ele);
        }
    }

    /**
     * 二叉查找树采用非递归算法实现
     * 二叉查找树：是一颗空树，或者如果存在左子树不为空，左子树的结点值小于根结点的值，
     *      如果存在右子树不为空，右子树的结点值大于根结点的值，左子树和右子树都是二叉查找树
     * @param root
     * @param ele
     * @return
     */
    private Node binaryTreeSearch(BinaryTreeNode root, Object ele) {
        // 临界条件，根结点不为空值
        while (root != null) {
            switch (strategy.compare(ele, root.getData())) {
                case 0:
                    // 如果待查找元素和根结点的元素相等，返回根结点,根结点的位置就是带查找元素的位置
                    return root;
                case -1:
                    // 如果待查找元素小于根结点的元素,,根结点指向左子树，去左子树查找
                    root = root.getLChild();
                    break;
                default:
                    // 如果待查找元素大于根结点的元素，根结点指向右子树，去右子树查找
                    root = root.getRChild();
                    break;
            }

        }
        // 根结点为空指，返回空值
        return null;
    }

    /**
     * 算法：binarySearch--二分查找(非递归算法实现)
     * 输入：整型数组array,待查找关键字key
     * 输出：查找关键字key在s中的位置
     * @param array
     * @param key
     * @return
     */
    public int binarySearch(int[] array, int key) {
        // 数组下界low,
        int low = 0;
        // 数组上界high
        int high = array.length - 1;
        // 遍历，如果数组下界小于等于数组上界
        while (low <= high) {
            // 获取数组的中间位置
            int middle = (low + high) / 2;
            if (array[middle] == key) {
                // 如果数组中间位置的元素的值等于key，说明查找成功，返回中间位置
                return middle;
            } else if (array[middle] > key) {
                // 如果中间位置的元素的值大于key，数组上界移动到中间位置减去1的位置
                high = middle - 1;
            } else {
                // 如果中间位置的元素的值小于key，数组下界移动到中间位置加上1的位置
                low = middle + 1;
            }
        }
        // 如果下界大于上界，数组不成立，返回-1，表示查找失败
        return -1;
    }

    /**
     * 算法：binarySearch--二分查找(递归算法实现)
     * 输入：整型数组array，查找范围数组下界low,数组上界high，待查找关键字key
     * 输出：查找关键字key在s中的位置
     * @param array
     * @param low
     * @param high
     * @param key
     * @return
     */
    public int binarySearch(int[] array, int low, int high, int key) {
        // 如果数组下界小于等于数组上界
        if (low <= high) {
            // 获取数组的中间位置
            int middle = low + (high - low) / 2;
            if (array[middle] == key) {
                // 如果数组中间位置的元素的值等于key，说明查找成功，返回中间位置
                return middle;
            } else if (array[middle] > key) {
                // 如果中间位置的元素的值大于key，数组上界移动到中间位置减去1的位置
                return binarySearch(array, low, middle - 1, key);
            } else if (array[middle] < key) {
                // 如果中间位置的元素的值小于key，数组下界移动到中间位置加上1的位置
                return binarySearch(array, middle + 1, high, key);
            }
        }
        // 如果下界大于上界，数组不成立，返回-1，表示查找失败
        return -1;
    }

    /**
     * 算法：search--查找算法
     * 输入：待查找元素ele
     * 输出：对应在二叉查找树中的结点位置
     * @param ele
     * @return
     */
    public Node search(Object ele) {
        // 1.递归算法实现查找
        Node node = binaryTreeSearchRecursion(root, ele);
        // 2.非递归算法实现查找
        node = binaryTreeSearch(root, ele);
        return node;
    }

    /**
     * 算法：min--最小值
     * 输入：根结点v
     * 输出：在根结点v的二叉查找树中最小元素的位置
     * @param v
     * @return
     */
    public Node min(BinaryTreeNode v) {
        if (v != null) {
            // 遍历，在二叉查找树的左子树中才能找到最小元素
            while (v.hasLChild()) {
                // 在左子树找到最小值的叶子结点
                v = v.getLChild();
            }
        }
        return v;
    }

    /**
     * 算法：max--最大值
     * 输入：根结点v
     * 输出：在根结点v的二叉查找树中最大元素的位置
     * @param v
     * @return
     */
    public Node max(BinaryTreeNode v) {
        if (v != null) {
            // 遍历，在二叉查找树的右子树中才能找到最大元素
            while (v.hasRChild()) {
                v = v.getRChild();
            }
        }
        return v;
    }

    /**
     * 算法：getSuccessor--获取后续结点
     * 输入：根结点v
     * 输出：获取根结点v在中序遍历的序列中的后续结点
     * @param v
     * @return
     */
    public BinaryTreeNode getSuccessor(BinaryTreeNode v) {
        if (v == null) {
            // 如果根结点v为空值，返回空值
            return null;
        }
        // 根结点v的后续结点是右子树中找出比根结点v的值(关键字)小的结点
        if (v.hasRChild()) {
            // 实例方法互调，其实是this被隐藏了
            return (BinaryTreeNode) min(v.getRChild());
        }
        // 如果根结点v的右子树为空，找到根结点v的父结点
        while (v.isRChild()) {
            v = v.getParent();
        }
        // 从结点v到顶层根结点的路径上第一个作为左孩子结点的父结点
        return v.getParent();
    }

    /**
     * 算法：getPredecessor--获取前驱结点
     * 输入：根结点v
     * 输出：获取根结点v在中序遍历的序列中的前驱结点
     * @param v
     * @return
     */
    public BinaryTreeNode getPredecessor(BinaryTreeNode v) {
        if (v == null) {
            // 如果根结点v为空值，返回空值
            return null;
        }
        // 根结点v的前驱结点是左子树中找出比根结点v的值大的结点
        if (v.hasLChild()) {
            return (BinaryTreeNode) max(v.getLChild());
        }
        // 如果根结点v的左子树为空，找出根结点v的父结点
        while (v.isLChild()) {
            v = v.getParent();
        }
        // 从结点v到顶层根结点的路径上第一个作为左孩子结点的父结点
        return v.getParent();
    }

    /**
     * 算法：insert--插入算法
     * 输入：待插入元素ele
     * 输出：在二叉查找树中插入元素ele
     * @param ele
     */
    public void insert(Object ele) {
        // 创建一个二叉树结点
        BinaryTreeNode p = null;
        // 将根结点指向一个新的二叉树结点
        BinaryTreeNode cuurent = root;
        // 遍历，找到待插入元素的待插入的位置
        while (cuurent != null) {
            // 结点current不为空，p指向current
            p = cuurent;
            // 待插入元素与当前结点数据域比较值小于零
            if (strategy.compare(ele, cuurent.getData()) < 0) {
                // 深入到左子树，找到待插入的位置
                cuurent = cuurent.getLChild();
            } else {
                // 深入到右子树，找到待插入的位置
                cuurent = cuurent.getRChild();
            }
        }
        // 待平衡的出发点,为了平衡二叉树，防止二叉树失去平衡，说白了破坏二叉树排序结构
        startBN = p;
        if (p == null) {
            // 根结点为空，构造一个数据域为ele的根结点
            root = new BinaryTreeNode(ele);
        } else if (strategy.compare(ele, p.getData()) < 0) {
            // 待插入元素与结点p的数据域值小于零,深入左子树找到待插入位置，并设置为左孩子
            p.setLChild(new BinaryTreeNode(ele));
        } else {
            // 待插入元素与结点p的数据域值大于零，深入右子树找到待插入位置，并设置为右孩子
            p.setRChild(new BinaryTreeNode(ele));
        }
    }

    /**
     * 算法：remove--删除算法
     * 输入：待删除元素ele
     * 输出：在二叉查找树中删除元素ele,并返回
     * @param ele
     * @return
     */
    public Object remove(Object ele) {
        // 根据二分查找，查找元素ele的结点
        BinaryTreeNode v = (BinaryTreeNode) binaryTreeSearch(root, ele);
        if (v == null) {
            // 如果结点为空，表示查找失败
            return null;
        }
        // 定义一个待删除的结点
        BinaryTreeNode delNode = null;
        // 定义一个待删除的子树
        BinaryTreeNode subTree = null;
        // 结点v没有孩子结点，即为叶子结点，直接删除
        if (!v.hasLChild() || !v.hasRChild()) {
            delNode = v;
        } else {
            // 既有左子树，也有右子树，用结点v前驱结点替代结点v
            delNode = getPredecessor(v);
            // 获取结点v的数据域
            Object old = v.getData();
            // 设置结点v的数据域
            v.setData(delNode.getData());
            // 设置待删除结点的数据域
            delNode.setData(old);
        }
        // 待平衡的出发点,为了平衡二叉树，防止二叉树失去平衡，说白了破坏二叉树排序结构
        startBN = delNode.getParent();
        // 如果待删除结点只有左子树或者右子树
        if (delNode.hasLChild()) {
            // 获取左子树
            subTree = delNode.getLChild();
        } else {
            // 获取右子树
            subTree = delNode.getRChild();
        }
        // 如果待删除结点是根结点
        if (delNode == root) {
            // 并且待删除的子树不为空
            if (subTree != null) {
                // 断开子树与父结点的关系
                subTree.sever();
            }
            // 如果子树为空，赋值给根结点
            root = subTree;
        } else {
            if (subTree != null) {
                // 待删除结点是左孩子
                if (delNode.isLChild()) {
                    // 将待删除子树设置为其父结点的左孩子
                    delNode.getParent().setLChild(subTree);
                } else {
                    // 待删除结点是右孩子，设置待删除子树为其父结点的右孩子
                    delNode.getParent().setRChild(subTree);
                }
            } else {
                // delNode为叶子结点,断开待删除结点与父结点关系
                delNode.sever();
            }
        }
        // 返回待删除结点的数据域
        return delNode.getData();
    }
}

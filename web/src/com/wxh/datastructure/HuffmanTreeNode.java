/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 哈夫曼树结点定义
 * 哈夫曼树：是由n个带权叶子结点构成的所有二叉树中带权路径长度最小的二叉树，也称最优二叉树
 * @author wxh
 * @version $Id: HuffmanTreeNode.java, v 0.1 2017年11月30日 上午10:26:32 wxh Exp $
 */
public class HuffmanTreeNode extends BinaryTreeNode {

    /** 权值：树结点具有某种意义的正数  */
    private int    weight;
    /**编码：根结点到左子树结点用0表示，根结点到右子树结点用1表示 */
    private String coding = "";

    /**
     * 将哈夫曼树结点按照weight从大到小的顺序插入线性表
     * @param node
     * @param list
     */
    private static void insertToList(HuffmanTreeNode node, List list) {
        // 获取线性表长度
        int n = list.getSize();
        for (int i = 0; i < n; i++) {
            // 如果传入参数的结点权值大于线性表中每个元素的值,插入到线性表中
            if (node.getWeight() > ((HuffmanTreeNode) list.get(i)).getWeight()) {
                list.insert(i, node);
                return;
            }
        }
        // 如果线性表长度为0，直接插入作为第一个元素
        list.insert(n, node);
    }

    /**
     * 算法：buildHuffmanTree--构造哈夫曼树
     * 输入：哈夫曼树结点数组nodes
     * 输出：哈夫曼树的根结点
     * @param nodes
     * @return HuffmanTreeNode
     */
    private static HuffmanTreeNode buildHuffmanTree(HuffmanTreeNode[] nodes) {
        // 获取哈夫曼树结点数组长度
        int n = nodes.length;
        if (n < 2) {
            // 获取数组第一个元素作为根结点返回
            return nodes[0];
        }
        // 创建一个由对象数组实现的线性表
        List list = new ListArray();
        // 遍历数组，按weight从大到小有序,将结点逐一插入线性表
        for (int i = 0; i < n; i++) {
            insertToList(nodes[i], list);
        }
        // 遍历数组,选择weight最小的两棵树合并,循环n-1次,排除根结点从1开始循环
        for (int i = 1; i < n; i++) {
            // 获取线性表最后一个元素,也是数组最小元素
            HuffmanTreeNode min1 = (HuffmanTreeNode) list.remove(list.getSize() - 1);
            // 获取线性表倒数第二个元素,也是数组第二个最小元素
            HuffmanTreeNode min2 = (HuffmanTreeNode) list.remove(list.getSize() - 1);
            // 创建一个新的哈夫曼树结点,作为根结点,其权值为两个哈夫曼树结点权值之和
            HuffmanTreeNode newRoot = new HuffmanTreeNode(min1.getWeight() + min2.getWeight());
            // 设置新结点的左孩子
            newRoot.setLChild(min1);
            // 设置新结点的右孩子
            newRoot.setRChild(min2);
            // 此时，根结点、左孩子、右孩子形成一颗新树,将其插入线性表中
            insertToList(newRoot, list);
        }
        // 返回Huffman树的根结点,线性表中第一个元素是最大值，也是哈夫曼树结点中权值最大的
        return (HuffmanTreeNode) list.get(0);
    }

    /**
     * 算法：generateHuffmanCode--生成哈夫曼编码
     * 输入：哈夫曼树的根结点
     * 输出：生成哈夫曼编码--最优二叉编码
     * @param root
     */
    private static void generateHuffmanCode(HuffmanTreeNode root) {
        if (root == null) {
            // 如果根结点为空，程序直接结束
            return;
        }
        // 传入参数树结点有父结点，说明它不是最顶层的根结点
        if (root.hasParent()) {
            // 如果该树结点是左孩子,设置编码为其父结点编码拼接"0"
            if (root.isLChild()) {
                root.setCoding(root.getParent().getCoding() + "0");
            }
            // 如果该树结点是右孩子,设置编码为其父结点编码拼接"1"
            if (root.isRChild()) {
                root.setCoding(root.getParent().getCoding() + "1");
            }
        }
        // 递归传入参数树结点的左子树结点
        generateHuffmanCode(root.getLChild());
        // 递归传入参数树结点的右子树结点
        generateHuffmanCode(root.getRChild());
    }

    /**
     * 初始化参数
     */
    public HuffmanTreeNode(int weight) {
        this(weight, null);
    }

    public HuffmanTreeNode(int weight, Object o) {
        super(o);
        this.weight = weight;
    }

    /** 
     * 获取父结点
     * @return HuffmanTreeNode
     * @see com.wxh.datastructure.BinaryTreeNode#getParent()
     */
    public HuffmanTreeNode getParent() {
        return (HuffmanTreeNode) super.getParent();
    }

    /** 
     * 获取左孩子结点
     * @return HuffmanTreeNode
     * @see com.wxh.datastructure.BinaryTreeNode#getLChild()
     */
    public HuffmanTreeNode getLChild() {
        return (HuffmanTreeNode) super.getLChild();
    }

    /** 
     * 获取右孩子结点
     * @return HuffmanTreeNode
     * @see com.wxh.datastructure.BinaryTreeNode#getRChild()
     */
    public HuffmanTreeNode getRChild() {
        return (HuffmanTreeNode) super.getRChild();
    }

    /** **********getter和setter*************** */
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

}

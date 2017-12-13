/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 图接口定义
 * 图分为无向图和有向图，内容包含顶点V(vertex)和边E(edge)
 * 图存储结构：邻接矩阵(二维数组，模拟顺序存储实现)、邻接表、双链式存储，图没有顺序存储结构
 * @author wxh
 * @version $Id: Graph.java, v 0.1 2017年12月1日 上午11:31:55 wxh Exp $
 */
public interface Graph {

    /** 无向图标识符  */
    public static final int UNDIRECTED_GRAPH = 0;
    /** 有向图标识符  */
    public static final int DIRECTED_GRAPH   = 1;

    /**
     * 获取图的类型:无向图还是有向图
     * @return
     */
    int getType();

    /**
     * 获取图的顶点数
     * @return
     */
    int getVexNum();

    /**
     * 获取图的边数
     * @return
     */
    int getEdgeNum();

    /**
     * 获取图的所有顶点，用迭代器接口接收
     * @return
     */
    Iterator getVertex();

    /**
     * 删除图中的一个顶点
     * @param v
     */
    void remove(Vertex v);

    /**
     * 删除图中的一条边
     * @param e
     */
    void remove(Edge e);

    /**
     * 在图中添加一个顶点
     * @param v
     * @return
     */
    Node insert(Vertex v);

    /**
     * 在图中添加一条边
     * @param e
     * @return
     */
    Node insert(Edge e);

    /**
     * 判断顶点u、v是否邻接，即是否有边从u到v
     * 边(u,v)∈E,顶点u和顶点v互为邻接点
     * @param u
     * @param v
     * @return
     */
    boolean areAdjacent(Vertex u, Vertex v);

    /**
     * 返回从u指向v的边，不存在则返回null
     * @param u
     * @param v
     * @return
     */
    Edge edgeFromTo(Vertex u, Vertex v);

    /**
     * 返回从u出发可以直接到达的邻接顶点
     * @param u
     * @return
     */
    Iterator adjVertex(Vertex u);

    /**
     * 从顶点v对图进行深度优先遍历
     * DFS--depth first search,采用递归算法实现
     * @param v
     * @return
     */
    Iterator DFSTraverse(Vertex v);

    /**
     * 从顶点v对图进行广度优先遍历
     * BFS--breadth first search,采用层次遍历算法实现
     * @param v
     * @return
     */
    Iterator BFSTraverse(Vertex v);

    /**
     * 求顶点v到其他顶点的最短路径
     * @param v
     * @return
     */
    Iterator shortestPath(Vertex v);

    /**
     * 求无向图的最小生成树,有向图不支持此操作
     * MST--min spanning tree，最小生成树
     * @throws UnsupportedOperation
     */
    void generateMST() throws UnsupportedOperation;

    /**
     * 求有向图的拓扑序列,无向图不支持此操作
     * @return
     * @throws UnsupportedOperation
     */
    Iterator toplogicalSort() throws UnsupportedOperation;

    /**
     * 求有向无环图的关键路径,无向图不支持此操作
     * @throws UnsupportedOperation
     */
    void criticalPath() throws UnsupportedOperation;
}

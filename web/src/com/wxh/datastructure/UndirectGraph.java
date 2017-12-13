/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 无向图定义
 * 横切边：一个顶点在割(S,V-S)的集合S中,一个顶点在割(S,V-S)的集合V-S中，组成的边
 * 割(S,V-S)：对顶点集合的一种划分，也是另一种叫法
 * 轻边：在所有横切边中，权值最小的边
 * @author wxh
 * @version $Id: UndirectGraph.java, v 0.1 2017年12月4日 上午11:28:02 wxh Exp $
 */
public class UndirectGraph extends AbstractGraph {

    /**
     * 获取到达顶点v的最小横切边
     * @param v
     * @return
     */
    protected Edge getCrossEdge(Vertex v) {
        return (Edge) v.getApplication();
    }

    /**
     * 获取到达顶点v的最小横切边的权值
     * @param v
     * @return
     */
    protected int getCrossWeight(Vertex v) {
        if (getCrossEdge(v) != null) {
            // 如果由顶点v构成的边不为空，获取其权值,否则Integer的最大值
            return getCrossEdge(v).getWeight();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * 设置到达顶点v的最小横切边
     * @param v
     * @param e
     */
    protected void setCrossEdge(Vertex v, Edge e) {
        v.setApplication(e);
    }

    /**
     * 查找轻边在集合V-S中的顶点
     * @param it
     * @return
     */
    protected Vertex selectMinVertex(Iterator it) {
        // 创建一个空的轻边对象
        Vertex min = null;
        // 遍历
        for (it.first(); !it.isDone(); it.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) it.currentItem();
            // 如果没有被访问过，表示该顶点属于集合V-S
            if (!v.isVisited()) {
                min = v;
                // 结束整个循环
                break;
            }
        }
        // 不设置初始值，开始遍历
        for (; !it.isDone(); it.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) it.currentItem();
            // 如果顶点v没有被访问过，并且权值小于min的权值，表示v的权值最小
            if (!v.isVisited() && getCrossWeight(v) < getCrossWeight(min)) {
                min = v;
            }
        }
        return min;
    }

    /** 
     * @param v
     */
    @Override
    public void remove(Vertex v) {
    }

    /** 
     * @param e
     */
    @Override
    public void remove(Edge e) {
    }

    /** 
     * @param u
     * @param v
     * @return
     */
    @Override
    public Edge edgeFromTo(Vertex u, Vertex v) {
        return null;
    }

    /** 
     * @param u
     * @return
     */
    @Override
    public Iterator adjVertex(Vertex u) {
        return null;
    }

    /** 
     * 算法：generateMST--构造最小生成树(prim算法实现)
     * 输入：无向连通带权图
     * 输出：最小生成树
     * 最小生成树：用kruskal(克鲁斯卡尔)算法或prim(普里姆)算法求出。
     * @throws UnsupportedOperation
     */
    @Override
    public void generateMST() throws UnsupportedOperation {
        // 重置图中各顶点的状态信息
        resetStatus();
        // 重置图中各边的类型信息
        resetEdgeType();
        // 获取所有的顶点
        Iterator iterator = getVertex();
        // 选取第一个顶点作为起点
        Vertex v = (Vertex) iterator.currentItem();
        // 设置顶点v为访问过，顶点v加入集合S
        v.setToVisited();
        // 遍历，初始化顶点集合S到集合V-S各顶点的最短横切边
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取其中一个顶点
            Vertex u = (Vertex) iterator.currentItem();
            // 返回从v指向u的边，不存在则返回null
            Edge e = edgeFromTo(v, u);
            // 设置到达集合V-S中顶点u的最短横切边
            setCrossEdge(u, e);
        }

        // 进行|V|-1次循环找到|V|-1条边，除去第一个顶点(源点，表示已经求出最短路径)，遍历
        for (int t = 1; t < getVexNum(); t++) {
            // 选取轻边在集合V-S中的顶点k
            Vertex k = selectMinVertex(iterator);
            // 设置顶点k为访问过，加入集合S中
            k.setToVisited();
            // 获取割(S,V-S)的轻边
            Edge minEdge = getCrossEdge(k);
            // 如果轻边不为空,将边加入MST(最小生成树)
            if (minEdge != null) {
                minEdge.setToMST();
            }
            // 获取顶点k的所有邻接点
            Iterator adjIt = adjVertex(k);
            // 遍历,以k为中间顶点修改集合S到集合V-S中顶点的最短横切边
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                // 获取顶点k其中一个邻接点
                Vertex adjV = (Vertex) adjIt.currentItem();
                // 返回从k指向adjV的边，不存在则返回null
                Edge e = edgeFromTo(k, adjV);
                // 边e的权值小于邻接点的对应边的权值
                if (e.getWeight() < getCrossWeight(adjV)) {
                    // 设置到达顶点adjV更短的横切边
                    setCrossEdge(adjV, e);
                }
            }
        }
    }

    /** 
     * 有向图实现
     * @return
     * @throws UnsupportedOperation
     */
    @Override
    public Iterator toplogicalSort() throws UnsupportedOperation {
        return null;
    }

    /** 
     * 有向图实现
     * @throws UnsupportedOperation
     */
    @Override
    public void criticalPath() throws UnsupportedOperation {
    }

}

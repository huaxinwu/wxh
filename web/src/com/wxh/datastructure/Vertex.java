/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 双链式存储结构的顶点定义
 * @author wxh
 * @version $Id: Vertex.java, v 0.1 2017年12月1日 上午11:55:43 wxh Exp $
 */
public class Vertex {

    /** 顶点信息：数据信息  */
    private Object     info;
    /** 顶点的邻接边表 :该顶点的出度边集合   */
    private LinkedList adjacentEdges;
    /** 顶点的逆邻接边表,无向图时为空:该顶点的入度边集合  */
    private LinkedList reAdjacentEdges;
    /** 顶点的访问状态： 访问过还是没有被访问过  */
    private boolean    visited;
    /** 顶点在顶点表(链接表)中的位置  */
    private Node       vexPositio;
    /** 顶点所在图的类型：无向图还是有向图  */
    private int        graphType;
    /** 顶点的应用(比如求最短路径时为Path，求关键路径时为Vtime等等) */
    private Object     application;

    /**
     * 判断图的类型，是无向图还是有向图
     * @return
     */
    private boolean isUnDiGraphType() {
        return this.graphType == Graph.UNDIRECTED_GRAPH;
    }

    /**
     * 初始化参数，在图中引入一个新顶点
     */
    public Vertex(Graph g, Object info) {
        this.info = info;
        // 创建一个双向链表实现的链接表
        adjacentEdges = new LinkedListDLNode();
        // 创建一个双向链表实现的链接表
        reAdjacentEdges = new LinkedListDLNode();
        // 默认该顶点没有被访问过
        visited = false;
        // 图类型
        graphType = g.getType();
        // 在图中添加一个顶点
        vexPositio = g.insert(this);
        // 默认不做任何应用
        application = null;
    }

    /**
     * 获取顶点信息
     * @return
     */
    public Object getInfo() {
        return info;
    }

    /**
     * 设置顶点信息
     * @param obj
     */
    public void setInfo(Object obj) {
        this.info = obj;
    }

    /**
     * 获取顶点的度(出度+入度)
     * @return
     */
    public int getDegree() {
        if (isUnDiGraphType()) {
            // 如果是无向图，无向图顶点的(出/入)度为邻接边表规模
            return adjacentEdges.getSize();
        } else {
            // 有向图顶点的度为出度与入度之和
            return getOutDegree() + getInDegree();
        }
    }

    /**
     * 获取顶点的出度(该顶点指向其他顶点)
     * @return
     */
    public int getOutDegree() {
        // 有(无)向图顶点的出度为邻接表规模
        return adjacentEdges.getSize();
    }

    /**
     * 获取顶点的入度(其他顶点指向该顶点)
     * @return
     */
    public int getInDegree() {
        if (isUnDiGraphType()) {
            // 无向图顶点的入度就是它的度
            return adjacentEdges.getSize();
        } else {
            // 有向图顶点入度为逆邻接表的规模
            return reAdjacentEdges.getSize();
        }
    }

    /**
     * 获取顶点的邻接边表
     * @return
     */
    public LinkedList getAdjacentEdges() {
        return adjacentEdges;
    }

    /**
     * 获取顶点的逆邻接边表
     * @return
     */
    public LinkedList getReAdjacentEdges() {
        if (isUnDiGraphType()) {
            // 无向图顶点的逆邻接边表就是其邻接边表
            return adjacentEdges;
        } else {
            // 有向图顶点的逆邻接边表
            return reAdjacentEdges;
        }
    }

    /**
     * 获取顶点在所属的图的顶点表中位置
     * @return
     */
    public Node getVexPosition() {
        return vexPositio;
    }

    /**
     * 获取顶点的访问状态
     * @return
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * 设置顶点的访问状态为访问过
     */
    public void setToVisited() {
        visited = true;
    }

    /**
     * 设置顶点的访问状态为没有被访问过
     */
    public void setToUnvisited() {
        visited = false;
    }

    /**
     * 获取顶点的应用信息
     * @return
     */
    public Object getApplication() {
        return application;
    }

    /**
     * 设置顶点的应用信息
     * @param app
     */
    public void setApplication(Object app) {
        this.application = app;
    }

    /**
     * 重置顶点的状态和应用信息
     */
    public void resetStatus() {
        this.visited = false;
        this.application = null;
    }

}

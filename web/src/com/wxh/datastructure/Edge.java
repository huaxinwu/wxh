/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 双链式存储结构的边定义
 * 边由两个顶点构成
 * @author wxh
 * @version $Id: Edge.java, v 0.1 2017年12月1日 上午11:56:01 wxh Exp $
 */
public class Edge {

    /** 普通的边  */
    public static final int NORMAL   = 0;
    /** 最小生成树的边  */
    public static final int MST      = 1;
    /** 关键路径中的边  */
    public static final int CRITICAL = 2;
    /** 边的权值(边上的数字) */
    private int             weight;
    /** 边的信息  */
    private Object          info;
    /** 边在边表中的位置  */
    private Node            edgePosition;
    /** 边的第一顶点在顶点表中的位置  */
    private Node            firstVexPosition;
    /** 边的第二顶点在顶点表中的位置  */
    private Node            secondVexPosition;
    /** 边在第一顶点的邻接表中的位置,在无向图中就是在两个顶点的邻接边表中的位置   */
    private Node            edgeFirstPosition;
    /** 边在第二顶点的逆邻接表中的位置 ,在无向图中就是在两个顶点的邻接边表中的位置  */
    private Node            edgeSecondPosition;
    /**边的类型 */
    private int             edgeType;
    /** 边所在图的类型  */
    private int             graphType;

    /**
     * 初始化参数，在图中引入一条新边,其顶点为u、v
     */
    public Edge(Graph g, Vertex u, Vertex v, Object info) {
        // 设置权值为1,此时图只有两个顶点，一条边，边的权值为1
        this(g, u, v, info, 1);
    }

    public Edge(Graph g, Vertex u, Vertex v, Object info, int weight) {
        this.info = info;
        this.weight = weight;
        // 在图中添加一条边
        edgePosition = g.insert(this);
        // 边的第一顶点(起始点)在顶点表中的位置
        firstVexPosition = u.getVexPosition();
        // 边的第二顶点(终止点)在顶点表中的位置
        secondVexPosition = v.getVexPosition();
        // 边的类型
        edgeType = Edge.NORMAL;
        // 图类型
        graphType = g.getType();
        if (graphType == Graph.UNDIRECTED_GRAPH) {
            // 如果是无向图,边应当加入其两个顶点的邻接边表
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            edgeSecondPosition = v.getAdjacentEdges().insertLast(this);
        } else {
            // 如果是有向图,边加入起始点的邻接边表,终止点的逆邻接边表
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            edgeSecondPosition = v.getReAdjacentEdges().insertLast(this);
        }
    }

    /**
     * 获取边的信息
     * @return
     */
    public Object getInfo() {
        return info;
    }

    /**
     * 设置边的信息
     * @param obj
     */
    public void setInfo(Object obj) {
        this.info = obj;
    }

    /**
     * 获取边的权值
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 设置边的权值
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * 获取边的第一顶点(起始点)
     * @return
     */
    public Vertex getFirstVex() {
        return (Vertex) firstVexPosition.getData();
    }

    /**
     * 获取边的第二顶点(终止点)
     * @return
     */
    public Vertex getSecondVex() {
        return (Vertex) secondVexPosition.getData();
    }

    /**
     * 获取边的第一顶点在顶点表中的位置 
     * @return
     */
    public Node getFirstVexPosition() {
        return firstVexPosition;
    }

    /**
     * 获取边的第二顶点在顶点表中的位置 
     * @return
     */
    public Node getSecondVexPosition() {
        return secondVexPosition;
    }

    /**
     * 获取边在第一顶点的邻接表中的位置
     * @return
     */
    public Node getEdgeFirstPosition() {
        return edgeFirstPosition;
    }

    /**
     * 获取边在第二顶点的逆邻接表中的位置
     * @return
     */
    public Node getEdgeSecondPosition() {
        return edgeSecondPosition;
    }

    /**
     * 获取边在边表中的位置 
     * @return
     */
    public Node getEdgePosition() {
        return edgePosition;
    }

    /**
     * 获取边的类型
     * @return
     */
    public int getEdgeType() {
        return edgeType;
    }

    /**
     * 设置边的类型为最小生成树类型的边
     */
    public void setToMST() {
        this.edgeType = Edge.MST;
    }

    /**
     * 设置边的类型为关键路径上的边
     */
    public void setToCritical() {
        this.edgeType = Edge.CRITICAL;
    }

    /**
     * 重置边的类型为普通边
     */
    public void resetEdgeType() {
        this.edgeType = Edge.NORMAL;
    }

    /**
     * 判断边的类型是否是最小生成树的边
     * @return
     */
    public boolean isMSTEdge() {
        return edgeType == Edge.MST;
    }

    /**
     * 判断边的类型是否是关键路径上的边
     * @return
     */
    public boolean isCriticalEdge() {
        return edgeType == Edge.CRITICAL;
    }

}

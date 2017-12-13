/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 图的路径定义
 * 路径：一个顶点到另一个顶点之间的距离
 * @author wxh
 * @version $Id: Path.java, v 0.1 2017年12月5日 上午11:37:31 wxh Exp $
 */
public class Path {

    /** 起点到终点的距离  */
    private int        distance;
    /** 起点信息(顶点)  */
    private Vertex     start;
    /** 终点信息(顶点)  */
    private Vertex     end;
    /** 起点到终点途径的顶点集合  */
    private LinkedList pathInfo;

    /**
     * 初始化参数
     */
    public Path() {
        // 设置起点到终点的距离为Integer的最大值
        this(Integer.MAX_VALUE, null, null);
    }

    public Path(int disance, Vertex start, Vertex end) {
        this.distance = disance;
        this.start = start;
        this.end = end;
        // 创建一个双向链表实现的链接表
        pathInfo = new LinkedListDLNode();
    }

    /**
     * 判断起点与终点之间是否存在路径
     * @return
     */
    public boolean hasPath() {
        return distance != Integer.MAX_VALUE && start != null && end != null;
    }

    /**
     * 求路径的长度
     * @return
     */
    public int pathLength() {
        if (!hasPath()) {
            // 如果不存在路径，返回-1
            return -1;
        } else if (start == end) {
            // 如果起点和终点相等，返回0
            return 0;
        } else {
            // 否则，存在路径
            return pathInfo.getSize() + 1;
        }
    }

    /**
     * 设置起点到终点的距离
     * @param distance
     */
    public void setDistance(int dis) {
        this.distance = dis;
    }

    /**
     * 设置起点的信息
     * @param v
     */
    public void setStart(Vertex v) {
        this.start = v;
    }

    /**
     * 设置终点的信息
     * @param v
     */
    public void setEnd(Vertex v) {
        this.end = v;
    }

    /**
     * 获取起点到终点的距离
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /**
     * 获取起点的信息
     * @return
     */
    public Vertex getStart() {
        return start;
    }

    /**
     * 获取终点的信息
     * @return
     */
    public Vertex getEnd() {
        return end;
    }

    /**
     * 获取起点到终点途径的顶点集合
     * @return
     */
    public Iterator getPathInfo() {
        return pathInfo.elements();
    }

    /**
     * 清空起点到终点途径的顶点集合
     */
    public void clearPathInfo() {
        pathInfo = new LinkedListDLNode();
    }

    /**
     * 添加路径信息到起点到终点途径的顶点集合
     * @param obj
     */
    public void addPathInfo(Object obj) {
        pathInfo.insertLast(obj);
    }

}

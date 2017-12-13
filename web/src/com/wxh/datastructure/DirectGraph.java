/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 有向图定义
 * 
 * 如果在一个有向图G = <V , E>中用顶点表示活动，
 * 用有向边<vi , vj>表示活动vi必须先于活动vj进行。
 * 这种有向图叫做顶点表示活动的AOV网络（activity on vertices networks）。
 * 
 * 用有向边表示一个工程中的各项活动(activity)；
 * 用边上的权值表示活动的持续时间(duration)；用顶点表示事件(event)；
 * 则这样的有向图叫做用边表示活动的网络，简称AOE网络 (activity on edges)
 * @author wxh
 * @version $Id: DirectGraph.java, v 0.1 2017年12月4日 上午11:25:57 wxh Exp $
 */
public class DirectGraph extends AbstractGraph {

    /**
     * 获取顶点v的入度
     * @param v
     * @return
     */
    private int getTopInDegree(Vertex v) {
        return ((Integer) v.getApplication()).intValue();
    }

    /**
     * 设置顶点v的入度
     * @param v
     * @param indegree
     */
    private void setTopInDegree(Vertex v, int indegree) {
        // Integer.valueOf(indegree)相当于Object的实例
        v.setApplication(Integer.valueOf(indegree));
    }

    /**
     * 获取顶点v的最早开始时间 --Earliest start time
     * @param v
     * @return
     */
    private int getVE(Vertex v) {
        return ((Vtime) v.getApplication()).getVE();
    }

    /**
     * 获取顶点v的最迟开始时间--Latest start time
     * @param v
     * @return
     */
    private int getVL(Vertex v) {
        return ((Vtime) v.getApplication()).getVL();
    }

    /**
     * 设置顶点v的最早开始时间
     * @param v
     * @param ve
     */
    private void setVE(Vertex v, int ve) {
        ((Vtime) v.getApplication()).setVE(ve);
    }

    /**
     * 设置顶点v的最迟开始时间
     * @param v
     * @param vl
     */
    private void setVL(Vertex v, int vl) {
        ((Vtime) v.getApplication()).setVL(vl);
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
     * 无向图实现
     * @throws UnsupportedOperation
     */
    @Override
    public void generateMST() throws UnsupportedOperation {
    }

    /** 
     * 算法：toplogicalSort--拓扑排序
     * 输入：AOV网络(活动的顶点网络，vi始终优先于vj)
     * 输出：拓扑序列
     * @return
     * @throws UnsupportedOperation
     */
    @Override
    public Iterator toplogicalSort() throws UnsupportedOperation {
        // 创建一个双向链表实现的链接表，存放遍历结果
        LinkedList topSequence = new LinkedListDLNode();
        // 创建一个单链表实现的栈,存放入度为零的顶点，表示没有前驱顶点
        Stack stack = new StackSLinked();
        // 获取所有顶点
        Iterator iterator = getVertex();
        // 遍历
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) iterator.currentItem();
            // 初始化顶点应用信息
            v.setApplication(Integer.valueOf(v.getInDegree()));
            // 如果顶点v入度为零，入栈
            if (v.getInDegree() == 0) {
                stack.push(v);
            }
        }
        // 栈不为空，遍历
        while (!stack.isEmpty()) {
            // 获取栈顶元素
            Vertex v = (Vertex) stack.pop();
            // 将栈顶元素插入到链接表中
            topSequence.insertLast(v);
            // 获取顶点v的所有邻接点
            Iterator adjIt = adjVertex(v);
            // 遍历
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                // 获取其中一个顶点
                Vertex adjV = (Vertex) adjIt.currentItem();
                // 邻接点的入度减去1
                int indegree = getTopInDegree(adjV) - 1;
                // 设置邻接点的入度
                setTopInDegree(adjV, indegree);
                // 如果邻接点的入度为零，入栈
                if (indegree == 0) {
                    stack.push(adjV);
                }
            }
        }
        // 有向无环图
        if (topSequence.getSize() < getVexNum()) {
            // 如果输出顶点个数少于AOV网络的顶点个数，说明网络中存在有向环
            return null;
        } else {
            // 入度为零的顶点集合，迭代器
            return topSequence.elements();
        }
    }

    /** 
     * 算法：toplogicalSort--拓扑排序
     * 输入：AOE网络(活动的边网络，)
     * 输出：标记的关键路径
     * @throws UnsupportedOperation
     */
    @Override
    public void criticalPath() throws UnsupportedOperation {
        // 获取有向图的拓扑序列
        Iterator iterator = toplogicalSort();
        // 重置图的所有边类型信息
        resetEdgeType();
        // 如果拓扑序列为空，程序结束
        if (iterator == null) {
            return;
        }
        // 创建一个双向链表实现的链接表，逆拓扑序列，存放各顶点的最早开始时间
        LinkedList reTopSequence = new LinkedListDLNode();
        // 遍历,初始化各点ve与vl，并生成逆拓扑序列
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) iterator.currentItem();
            // 创建一个关键路径，最早开始时间为零，最迟开始时间为无穷大--ve=0,vl=∞
            Vtime vtime = new Vtime(0, Integer.MAX_VALUE);
            // 初始化顶点的应用信息
            v.setApplication(vtime);
            // 将顶点插入到链接表中
            reTopSequence.insertLast(v);
        }

        // 遍历,正向拓扑序列求各点ve
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) iterator.currentItem();
            // 获取顶点v的所有邻接点
            Iterator adjIt = adjVertex(v);
            // 遍历
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                // 获取其中一个邻接点
                Vertex adjV = (Vertex) adjIt.currentItem();
                // 返回从v指向adjV的边，不存在则返回null
                Edge e = edgeFromTo(v, adjV);
                // 顶点v最早开始时间加上顶点v到邻接点adjV的边权值，大于邻接点的最早开始时间
                if ((getVE(v) + e.getWeight()) > getVE(adjV)) {
                    // 更新最早开始时间
                    setVE(v, getVE(v) + e.getWeight());
                }
            }
        }
        // 获取逆拓扑序列第一个元素信息,作为顶点
        Vertex destV = (Vertex) reTopSequence.first().getData();
        // 设置汇点vl=ve
        setVL(destV, getVE(destV));
        // 获取逆拓扑序列,汇点到源点关键路径的集合
        Iterator reIt = reTopSequence.elements();

        // 遍历，逆向拓扑序列求各点vl
        for (reIt.first(); !reIt.isDone(); reIt.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) reIt.currentItem();
            // 获取顶点的邻接点
            Iterator adjIt = adjVertex(v);
            // 遍历
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                // 获取其中一个邻接点
                Vertex adjV = (Vertex) adjIt.currentItem();
                // 返回从v指向adjV的边，不存在则返回null
                Edge e = edgeFromTo(v, adjV);
                // 如果顶点v最迟开始时间大于，邻接点adjV最迟开始时间减去边(v,adjV)的权值
                if (getVL(v) > (getVL(adjV) - e.getWeight())) {
                    // 更新最迟开始时间
                    setVL(v, getVL(adjV) - e.getWeight());
                }
            }
        }

        // 边序列
        Iterator edgeIt = edges.elements();
        // 遍历，求关键活动
        for (edgeIt.first(); !edgeIt.isDone(); edgeIt.next()) {
            // 获取其中一条边
            Edge e = (Edge) edgeIt.currentItem();
            // 获取边e的第一顶点
            Vertex u = e.getFirstVex();
            // 获取边e的第二顶点
            Vertex v = e.getSecondVex();
            // 如果顶点u最早开始时间等于顶点v最迟开始时间减去边e的权值之差
            if (getVE(u) == (getVL(v) - e.getWeight())) {
                // 设置边e为关键路径上的边
                e.setToCritical();
            }
        }
    }

}

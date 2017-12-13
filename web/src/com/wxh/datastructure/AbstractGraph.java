/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 图的抽象定义
 * 抽象类实现接口,抽象出无向图类和有向图类
 * @author wxh
 * @version $Id: AbstractGraph.java, v 0.1 2017年12月4日 上午11:10:13 wxh Exp $
 */
public abstract class AbstractGraph implements Graph {

    /** 所有顶点集合  */
    protected LinkedList vertexs;
    /** 所有边集合 */
    protected LinkedList edges;
    /** 图的边类型  */
    protected int        edgeType;

    /**
     * 深度优先遍历的实现过程--递归算法,每个顶点都只访问一次
     *      思路：用递归算法实现从顶点v 开始的深度优先搜索。然而从顶点v出发深度优先搜索未必能访问到图中所有顶点，
     *           因此还需找到图中下一个未曾访问的顶点，从该顶点开始重新进搜索
     * @param v
     * @param list
     */
    private void DFSRecursion(Vertex v, LinkedList list) {
        // 设置顶点v已经访问过
        v.setToVisited();
        // 将访问过的顶点插入到链接表中
        list.insertLast(v);
        // 获取顶点v的所有邻接点
        Iterator iterator = adjVertex(v);
        // 遍历
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取顶点v的其中一个邻接点
            Vertex adjacent = (Vertex) iterator.currentItem();
            // 如果没有被访问过,递归
            if (!adjacent.isVisited()) {
                DFSRecursion(adjacent, list);
            }
        }
    }

    /**
     * 深度优先遍历的实现过程--栈的形式,每个顶点都只访问一次
     *      思路：首先将初始顶点v 入栈；当堆栈不为空时，重复以下处理，栈顶元素出栈，
     *           若未访问，则访问之并设置访问标志，将其未曾访问的邻接点入栈；
     *           如果图中还有未曾访问的邻接点，选择一个重复以上过程。
     * @param v
     * @param list
     */
    private void DFS(Vertex v, LinkedList list) {
        // 创建一个单链表实现的栈
        Stack stack = new StackSLinked();
        // 将顶点v入栈
        stack.push(v);
        // 遍历
        while (!stack.isEmpty()) {
            // 栈顶元素出栈
            Vertex u = (Vertex) stack.pop();
            // 如果顶点u没有被访问过，进行相关设置
            if (!u.isVisited()) {
                // 设置为访问过
                u.setToVisited();
                // 将顶点u插入到链接表中
                list.insertLast(u);
                // 获取顶点u的邻接点
                Iterator iterator = adjVertex(u);
                // 遍历
                for (iterator.first(); !iterator.isDone(); iterator.next()) {
                    // 获取顶点u的其中一个邻接点
                    Vertex adjacent = (Vertex) iterator.currentItem();
                    // 如果没有被访问过，入栈
                    if (!adjacent.isVisited()) {
                        stack.push(adjacent);
                    }
                }
            }
        }
    }

    /**
     * 广度优先遍历实现的过程--层次遍历,每个顶点都只访问一次
     *      思路：首先访问初始顶点v入队；当队列不为空时，重复以下处理，
     *           队首元素出队，访问其所有未曾访问的邻接点，并它们入队；
     *           如果图中还有未曾访问的邻接点，选择一个重复以上过程。
     * @param v
     * @param list
     */
    private void BFS(Vertex v, LinkedList list) {
        // 创建一个单链表实现的队列
        Queue queue = new QueueSLinked();
        // 设置顶点v为访问过
        v.setToVisited();
        // 将顶点v插入到链接表中
        list.insertLast(v);
        // 顶点v入队
        queue.enqueue(v);
        // 遍历
        while (!queue.isEmpty()) {
            // 队首元素出队
            Vertex u = (Vertex) queue.dequeue();
            // 获取顶点u的邻接点
            Iterator iterator = adjVertex(u);
            // 遍历
            for (iterator.first(); !iterator.isDone(); iterator.next()) {
                // 获取顶点u的其中一个邻接点
                Vertex adjacent = (Vertex) iterator.currentItem();
                // 如果没有被访问过,入队
                if (!adjacent.isVisited()) {
                    // 设置为访问过
                    adjacent.setToVisited();
                    // 将邻接点插入到链接表中
                    list.insertLast(adjacent);
                    // 邻接点入队
                    queue.enqueue(adjacent);
                }
            }
        }
    }

    /**
     * 获取顶点v到其他顶点的最短距离
     * @param v
     * @return
     */
    protected int getDistance(Vertex v) {
        return ((Path) v.getApplication()).getDistance();
    }

    /**
     * 设置顶点v到其他顶点的最短距离
     * @param v
     * @param distance
     */
    protected void setDistance(Vertex v, int distance) {
        ((Path) v.getApplication()).setDistance(distance);
    }

    /**
     * 获取顶点v到其他顶点的最短路径
     * @param v
     * @return
     */
    protected Path getPath(Vertex v) {
        return (Path) v.getApplication();
    }

    /**
     * 设置顶点v到其他顶点的最短路径
     * @param v
     * @param path
     */
    protected void setPath(Vertex v, Path path) {
        v.setApplication(path);
    }

    /**
     * 查找顶点在集合V-S中距离最短距离
     * @param it
     * @return
     */
    protected Vertex selectMin(Iterator it) {
        // 创建一个空的轻边对象
        Vertex min = null;
        // 遍历
        for (it.first(); !it.isDone(); it.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) it.currentItem();
            // 如果没有被访问过，表示该顶点属于集合V-S
            if (!v.isVisited()) {
                min = v;
                /// 结束整个循环
                break;
            }
        }
        // 不设置初始值，开始遍历
        for (; !it.isDone(); it.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) it.currentItem();
            // 如果顶点v没有被访问过，并且顶点v到其他顶点的最短距离小于顶点min到其他顶点最短距离
            if (!v.isVisited() && getDistance(v) < getDistance(min)) {
                min = v;
            }
        }
        return min;
    }

    /**
    * 以顶点mid的路径信息修改为顶点end的路径信息
    * @param mid
    * @param end
    */
    protected void amendPathInfo(Vertex mid, Vertex end) {
        // 获取顶点mid的路径信息
        Iterator it = getPath(mid).getPathInfo();
        // 清空顶点end的路径信息
        getPath(end).clearPathInfo();
        // 遍历
        for (it.first(); !it.isDone(); it.next()) {
            // 设置顶点end的路径信息
            getPath(end).addPathInfo(it.currentItem());
        }
        // 设置顶点end的路径信息
        getPath(end).addPathInfo(mid.getInfo());
    }

    /**
     * 重置图的所有顶点的状态信息
     */
    protected void resetStatus() {
        // 获取所有顶点
        Iterator it = getVertex();
        // 遍历
        for (it.first(); !it.isDone(); it.next()) {
            // 获取其中一个顶点
            Vertex v = (Vertex) it.currentItem();
            // 重置顶点的状态信息
            v.resetStatus();
        }
    }

    /**
     * 重置图的所有边的类型信息
     */
    protected void resetEdgeType() {
        // 获取所有边
        Iterator it = getEdge();
        // 遍历
        for (it.first(); !it.isDone(); it.next()) {
            // 获取其中一条边
            Edge e = (Edge) it.currentItem();
            // 重置边的类型信息
            e.resetEdgeType();
        }
    }

    /**
     * 获取图的类型
     * @return
     */
    public int getType() {
        return edgeType;
    }

    /**
     * 获取图的顶点数
     * @return
     */
    public int getVexNum() {
        return vertexs.getSize();
    }

    /**
     * 获取图边数
     * @return
     */
    public int getEdgeNum() {
        return edges.getSize();
    }

    /**
     * 获取图的所有顶点
     * @return
     */
    public Iterator getVertex() {
        return vertexs.elements();
    }

    /**
     * 获取图的所有边
     * @return
     */
    public Iterator getEdge() {
        return edges.elements();
    }

    /**
     * 在图中添加一个顶点
     * @param v
     * @return
     */
    public Node insert(Vertex v) {
        return vertexs.insertLast(v);
    }

    /**
     * 在图中添加一条边
     * @param e
     * @return
     */
    public Node insert(Edge e) {
        return edges.insertLast(e);
    }

    /**
     * 判断顶点u、v是否邻接，即是否有边从u到v
     * 边(u,v)∈E,顶点u和顶点v互为邻接点
     * @param u
     * @param v
     * @return
     */
    public boolean areAdjacent(Vertex u, Vertex v) {
        return edgeFromTo(u, v) != null;
    }

    /**
     * 算法：DFSTraverse--深度优先遍历
     * 输入：图的顶点v
     * 输出：图的深度优先遍历的结果
     * @param v
     * @return
     */
    public Iterator DFSTraverse(Vertex v) {
        // 创建一个双向链表实现的链接表,存放遍历结果
        LinkedList traverseSequence = new LinkedListDLNode();
        // 重置图的所有顶点状态
        resetStatus();
        // 1.从顶点v出发深度优先搜索--递归算法实现
        DFSRecursion(v, traverseSequence);
        // 2.从顶点v出发深度优先搜索--非递归算法实现
        DFS(v, traverseSequence);
        // 从图未曾访问的其他顶点重新搜索
        Iterator iterator = getVertex();
        // 遍历
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            Vertex u = (Vertex) iterator.currentItem();
            // 如果顶点没有被访问过，深度优先遍历
            if (!u.isVisited()) {
                // 递归
                DFSRecursion(u, traverseSequence);
            }
        }
        // 返回深度优先遍历的结果--迭代器
        return traverseSequence.elements();
    }

    /**
     * 算法：BFSTraverse--广度优先遍历
     * 输入：图的顶点v
     * 输出：图的广度优先遍历的结果
     * @param v
     * @return
     */
    public Iterator BFSTraverse(Vertex v) {
        // 创建一个双向链表实现的链接表,存放遍历结果
        LinkedList traverseSequence = new LinkedListDLNode();
        // 重置图的所有顶点状态
        resetStatus();
        // 从顶点v出发广度优先搜索--层次遍历实现
        BFS(v, traverseSequence);
        // 从图未曾访问的其他顶点重新搜索
        Iterator iterator = getVertex();
        // 遍历
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取顶点v的其中一个邻接点
            Vertex u = (Vertex) iterator.currentItem();
            // 如果顶点没有被访问过，广度优先遍历
            if (!u.isVisited()) {
                BFS(u, traverseSequence);
            }
        }
        // 返回广度优先遍历的结果--迭代器
        return traverseSequence.elements();
    }

    /**
     * 算法：shortestPath--最短路径(Dijkstra算法实现)
     * 输入：顶点v
     * 输出：顶点v到其他顶点的最短路径
     * @param v
     * @return
     */
    public Iterator shortestPath(Vertex v) {
        // 创建一个双向链表实现的链接表，存放顶点v到其他顶点的最短路径集合
        LinkedList shortPath = new LinkedListDLNode();
        // 重置图的所有顶点状态
        resetStatus();
        // 获取所有顶点
        Iterator iterator = getVertex();
        // 遍历
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            // 获取顶点v的其中一个邻接点
            Vertex u = (Vertex) iterator.currentItem();
            // 设置权值
            int weight = Integer.MAX_VALUE;
            // 返回从v指向u的边，不存在则返回null
            Edge edge = edgeFromTo(v, u);
            // 如果边不为空，获取其权值赋值给变量weight
            if (edge != null) {
                weight = edge.getWeight();
            }
            // 如果顶点v和顶点u重合，变量weight为0
            if (u == v) {
                weight = 0;
            }
            // 根据顶点v和顶点u，权值weight构建一个路径对象
            Path path = new Path(weight, v, u);
            // 设置顶点u到其他顶点的最短路径
            setPath(u, path);
        }
        // 设置顶点v为访问过，加入集合S中
        v.setToVisited();
        // 将顶点v到其他顶点的最短路径
        Path vPath = getPath(v);
        // 将顶点v到其他顶点的最短路径插入到链接表中
        shortPath.insertLast(vPath);
        // 进行|V|-1次循环找到|V|-1条最短路径,除去第一个顶点，遍历
        for (int t = 1; t < getVexNum(); t++) {
            // 找出集合V-S中distance最短的顶点k
            Vertex k = selectMin(iterator);
            // 设置顶点k为访问过，加入集合S中
            k.setToVisited();
            // 将顶点k到其他顶点的最短路径插入链接表中
            shortPath.insertLast(getPath(k));
            // 修正集合V-S中顶点k到其他顶点最短距离
            int distanceK = getDistance(k);
            // 获取顶点k的所有邻接点
            Iterator adjIt = adjVertex(k);
            // 遍历
            for (adjIt.first(); !adjIt.isDone(); adjIt.next()) {
                // 获取顶点k其中一个邻接点
                Vertex adjV = (Vertex) adjIt.currentItem();
                // 返回从k指向adjV的边，不存在则返回null
                Edge e = edgeFromTo(k, adjV);
                // 如果顶点k最短距离加上顶点k到邻接点边的权值邻接点到其他顶点最短距离
                if ((long) distanceK + (long) e.getWeight() < (long) getDistance(adjV)) {
                    // 设置邻接点到其他顶点的最短距离
                    setDistance(adjV, distanceK + e.getWeight());
                    // 以k的路径信息修改为adjV的路径信息
                    amendPathInfo(k, adjV);
                }
            }
        }
        // 返回顶点v到其他顶点的最短路径集合，迭代器
        return shortPath.elements();
    }

}

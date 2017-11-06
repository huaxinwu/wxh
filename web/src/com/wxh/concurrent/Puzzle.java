/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 搬箱子的谜题抽象类
 * P--位置，M--移动
 * @author wxh
 * @version $Id: Puzzle.java, v 0.1 2017年11月3日 下午2:49:31 wxh Exp $
 */
public interface Puzzle<P, M> {

    /**
     * 初始化位置
     * @return
     */
    P initialPosition();

    /**
     * 是否是终点位置
     * @param position
     * @return
     */
    boolean isGoal(P position);

    /**
     * 有规律的移动
     * @param position
     * @return
     */
    Set<M> legalMoves(P position);

    /**
     * 移动到指定位置
     * @param position
     * @param move
     * @return
     */
    P move(P position, M move);

    /*
     * 移动达到某一个位置链表节点
     */
    static class Node<P, M> {
        final P          pos;
        final M          move;
        final Node<P, M> prev;

        Node(P pos, M move, Node<P, M> prev) {
            this.pos = pos;
            this.move = move;
            this.prev = prev;
        }

        List<M> asMoveList() {
            List<M> soultion = new LinkedList<M>();
            for (Node<P, M> node = this; node.move != null; node = node.prev) {
                soultion.add(0, node.move);
            }
            return soultion;
        }
    }

}

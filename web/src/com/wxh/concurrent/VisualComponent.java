/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 可视化组件
 * 将线程安全委托给多个状态变量
 * CopyOnWriteArrayList 延迟加载内容
 * CopyOnWrite并发容器用于读多写少的并发场景,称为 写时复制容器--写的时候，才将值复制过去，是Collections.synchronizedList(list)替代方案
 * 该组件使用CopyOnWriteArrayList保存各个监听列表，是一个线程安全链表，用于管理监听器列表。
 * @author wxh
 * @version $Id: VisualComponent.java, v 0.1 2017年10月26日 上午10:45:44 wxh Exp $
 */
public class VisualComponent {
    /** 键盘监听 */
    private final List<KeyListener>   keyListeners   = new CopyOnWriteArrayList<KeyListener>();

    /** 鼠标监听 */
    private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListener>();

    public void addKeyListener(KeyListener keyListener) {
        keyListeners.add(keyListener);
    }

    public void addMouseListener(MouseListener mouseListener) {
        mouseListeners.add(mouseListener);
    }

    public void removeKeyListener(KeyListener keyListener) {
        keyListeners.remove(keyListener);
    }

    public void removeMouseListener(MouseListener mouseListener) {
        mouseListeners.remove(mouseListener);
    }
}

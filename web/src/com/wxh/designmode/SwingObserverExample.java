/**
 * Ambition Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * swing观察者案例
 * @author wxh
 * @version $Id: SwingObserverExample.java, v 0.1 2017年4月10日 下午3:47:08 wxh Exp $
 */
public class SwingObserverExample {
    //一个窗体
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample swingObserverExample = new SwingObserverExample();
        swingObserverExample.go();
    }

    /**
     * 初始化数据
     */
    public void go() {
        frame = new JFrame();
        JButton button = new JButton("Should do it?");
        //创建两个监听者
        button.addActionListener(new AngelListener());
        button.addActionListener(new DevilListener());
        //设置容器的按钮位置
        frame.getContentPane().add(BorderLayout.CENTER, button);
        //设置frame属性

    }

    /**
     * 天使类
     * @author wxh
     * @version $Id: SwingObserverExample.java, v 0.1 2017年4月10日 下午3:52:39 wxh Exp $
     */
    class AngelListener implements ActionListener {

        /** 
         * @param e
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it,you might regret it!");
        }

    }

    /**
     * 恶魔类
     * @author wxh
     * @version $Id: SwingObserverExample.java, v 0.1 2017年4月10日 下午3:52:50 wxh Exp $
     */
    class DevilListener implements ActionListener {

        /** 
         * @param e
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Come on,do it!");
        }

    }
}

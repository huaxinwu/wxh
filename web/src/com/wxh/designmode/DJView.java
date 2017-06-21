/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * DJ视图
 * @author wxh
 * @version $Id: DJView.java, v 0.1 2017年6月20日 下午3:08:14 wxh Exp $
 */
public class DJView implements ActionListener, BeatObserver, BPMObserver {
    BeatModelInterface  model;
    ControllerInterfacr controller;
    JFrame              viewFrame;
    JPanel              viewPanel;
    BeatBar             beatBar;
    JLabel              bpmOutputLabel;
    JFrame              controlFrame;
    JPanel              controlPanel;
    JLabel              bpmLabel;
    JTextField          bpmTextField;
    JButton             setBPMButton;
    /** 增加  */
    JButton             increaseBPMButton;
    /** 减少 */
    JButton             decreaseBPMButton;
    JMenuBar            menuBar;
    JMenu               menu;
    JMenuItem           startMenuItem;
    JMenuItem           stopMenuItem;

    public DJView(ControllerInterfacr controller, BeatModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.regeisterObserver((BeatObserver) this);
        model.regeisterObserver((BPMObserver) this);
    }

    /**
     * 创建视图
     */
    public void createView() {
        // 一行两列
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 二维
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    /**
     * 创建控制器
     */
    public void createControls() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100, 80));
        controlPanel = new JPanel(new GridLayout(1, 2));
        menuBar = new JMenuBar();
        menu = new JMenu("DJ Control");
        startMenuItem = new JMenuItem("start");
        // 菜单添加菜单项
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.start();
            }
        });
        stopMenuItem = new JMenuItem("stop");
        menu.add(stopMenuItem);
        stopMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stop();
            }
        });
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exit);
        // 菜单栏添加菜单
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);
        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
        setBPMButton = new JButton("Set");
        setBPMButton.setSize(new Dimension(10, 40));
        increaseBPMButton = new JButton(">>");
        decreaseBPMButton = new JButton("<<");
        // 监听自己
        setBPMButton.addActionListener(this);
        increaseBPMButton.addActionListener(this);
        decreaseBPMButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(increaseBPMButton);
        buttonPanel.add(decreaseBPMButton);

        JPanel enterPanel = new JPanel(new GridLayout(1, 2));
        enterPanel.add(bpmLabel);
        enterPanel.add(bpmTextField);

        JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
        insideControlPanel.add(enterPanel);
        insideControlPanel.add(setBPMButton);
        insideControlPanel.add(buttonPanel);

        controlPanel.add(insideControlPanel);

        bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        controlFrame.getRootPane().setDefaultButton(setBPMButton);
        controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
    }

    /**
     * 更新BPM
     */
    public void updateBPM() {
        int bpm = model.getBPM();
        if (bpm == 0) {
            bpmOutputLabel.setText("offline");
        } else {
            bpmOutputLabel.setText("Current BPM: " + model.getBPM());
        }
    }

    /**
     * 更新Beat
     */
    public void updateBeat() {
        beatBar.setValue(100);
    }

    /**
     * 启用停止菜单项
     */
    public void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    /**
     * 禁用停止菜单项
     */
    public void disableStopMenuItem() {
        stopMenuItem.setEnabled(false);
    }

    /**
     * 启用开始菜单项
     */
    public void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    /**
     * 禁用开始菜单项
     */
    public void disableStartMenuItem() {
        startMenuItem.setEnabled(false);
    }

    /** 
     * 监听行为
     * @param e
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setBPMButton) {
            int bpm = Integer.parseInt(bpmTextField.getText());
            controller.setBPM(bpm);
        } else if (e.getSource() == increaseBPMButton) {
            controller.increaseBPM();
        } else if (e.getSource() == decreaseBPMButton) {
            controller.decreaseBPM();
        }
    }

}

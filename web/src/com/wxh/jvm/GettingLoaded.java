/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextArea;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 获取一个类加载器
 * @author wxh
 * @version $Id: GettingLoaded.java, v 0.1 2017年12月19日 上午10:59:20 wxh Exp $
 */
public class GettingLoaded extends Applet implements Runnable {

    /** */
    private static final long serialVersionUID      = -5853371495027200534L;

    /** 类文件路径 */
    private URL               theClassFileURL;
    /** 活动文本路径  */
    private URL               theActTextURL;
    private Thread            runner;
    private TextArea          text                  = new TextArea();
    /** 第一步结点  */
    private StepNode          firstNode;
    /** 最后一步结点  */
    private StepNode          lastNode;
    /** 当前步的结点  */
    private StepNode          currentNode;
    /** 默认没有准备好  */
    private boolean           ready                 = false;
    /** 默认JMV没有完成垃圾收集  */
    private boolean           jvmFinishedGobbling   = false;
    /** 当前收集的位置  */
    private int               currentGobblePosition = 0;
    private JVMPacman         jvmPacman;
    private String            titleString           = "Getting Loaded\n\n";
    /** 默认没有引发URL异常  */
    private boolean           urlExceptionWasThrown = false;
    private String            cantGoFurtherString   = "Unfortunately this means the applet cannot go any further.\n";
    private String            ioErrorMsg            = "An IO Error occured while trying to read a file from the server.\n";
    private String            securityErrorMsg      = "An security exception occured while trying to read a file from the server.\n";
    private String            urlErrorMsg           = "This HTML file contains a malformed URL of a file required by this applet.\n";

    /** 
     * 初始化参数
     * @see java.applet.Applet#init()
     */
    public void init() {
        super.init();
        // 设置文本域不可编辑
        text.setEditable(false);
        // 设置背景颜色为蓝色
        setBackground(Color.blue);
        // 获取一个类文件路径
        String url = getParameter("classURL");
        // 设置类文件路径
        try {
            this.theClassFileURL = new URL(getDocumentBase(), url);
        } catch (MalformedURLException e) {
            // 设置引发了异常
            urlExceptionWasThrown = true;
            URL docBase = getDocumentBase();
            // 设置文本域的内容
            text.setText(titleString + "Bad URL: " + docBase.toString() + url + "\n\n"
                         + urlErrorMsg + cantGoFurtherString);
        }
        // 获取一个文本路径
        url = getParameter("textURL");
        // 设置文本路径
        try {
            this.theActTextURL = new URL(getDocumentBase(), url);
        } catch (MalformedURLException e) {
            urlExceptionWasThrown = true;
            URL docBase = getDocumentBase();
            text.setText(titleString + "Bad URL: " + docBase.toString() + url + "\n\n"
                         + urlErrorMsg + cantGoFurtherString);
        }
        // 设置控制器面板
        ControlPanel controlPanel = new ControlPanel();
        jvmPacman = controlPanel.getJVMPacman();
        setLayout(new BorderLayout(5, 5));
        // 设置边界布局上设置各个部分内容
        text.setBackground(Color.white);
        add("North", new ColoredLabel("GETTING LOADED", Label.CENTER, Color.cyan));
        add("South", controlPanel);
        add("Center", text);

    }

    /** 
     * 处理事件
     * @param evt
     * @return
     * @see java.awt.Component#handleEvent(java.awt.Event)
     */
    public boolean handleEvent(Event evt) {
        return super.handleEvent(evt);
    }

    /** 
     * 执行
     * @param evt
     * @param arg
     * @return
     * @see java.awt.Component#action(java.awt.Event, java.lang.Object)
     */
    public boolean action(Event evt, Object arg) {
        // 如果目标是Button的实例
        if (evt.target instanceof Button) {
            // 获取其名称
            String bName = (String) arg;
            // 如果匹配重置按钮，执行相关操作,否则执行其他操作
            if ("Reset".equals(bName)) {
                // 如果文件已经准备好,并且当前步结点不是第一步结点
                if (ready) {
                    if (!currentNode.first()) {
                        // 将其设置为第一步结点
                        currentNode = firstNode;
                        currentGobblePosition = 0;
                        jvmPacman.setGobblePosition(0, currentNode.getByteCount());
                        text.setText(currentNode.getString());
                    }
                }
            } else if ("Step".equals(bName)) {
                // 如果文件已经准备好,并且当前步结点不是最后一步结点
                if (ready) {
                    if (!currentNode.last()) {
                        currentGobblePosition += currentNode.getByteCount();
                        currentNode = currentNode.getNext();
                        jvmPacman.gobbleToPosition(currentGobblePosition,
                            currentNode.getByteCount());
                        text.setText(currentNode.getString());
                    } else {
                        // 如果JVM完成收集
                        if (!jvmFinishedGobbling) {
                            currentGobblePosition += currentNode.getByteCount();
                            jvmPacman.gobbleToPosition(currentGobblePosition, 0);
                            jvmFinishedGobbling = true;
                            text.setText("(The End)");
                        }
                    }
                }
            } else if ("Back".equals(bName)) {
                // 如果文件已经准备好,并且当前步结点不是第一步结点
                if (ready) {
                    if (!currentNode.first()) {
                        // 如果JVM完成收集
                        if (jvmFinishedGobbling) {
                            jvmFinishedGobbling = false;
                            currentGobblePosition -= currentNode.getByteCount();
                        } else {
                            currentNode = currentNode.getPrev();
                            currentGobblePosition -= currentNode.getByteCount();
                        }
                        // 设置收集垃圾的位置
                        jvmPacman.setGobblePosition(currentGobblePosition,
                            currentNode.getByteCount());
                        text.setText(currentNode.getString());
                    }
                }
            }
        }
        return true;
    }

    /** 
     * 获取一个插图
     * @return
     * @see java.awt.Container#insets()
     */
    public Insets insets() {
        // top, left, bottom, right  
        // 从面板上的左上角原点开始
        return new Insets(5, 5, 5, 5);
    }

    /** 
     * 开始
     * @see java.applet.Applet#start()
     */
    public void start() {
        // 如果线程为空，并且准备好，并且引发了异常
        if (runner == null && !ready && !urlExceptionWasThrown) {
            runner = new Thread(this);
            runner.start();
        }
    }

    /** 
     * 停止
     * @see java.applet.Applet#stop()
     */
    public void stop() {
        if (runner != null) {
            runner.stop();
            // 让GC回收
            runner = null;
        }
    }

    /** 
     * 运行
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // 输入流
        InputStream conn = null;
        // 数据输入流，用来装饰流的
        DataInputStream data = null;
        // 读取的行数
        String line;
        // 字符缓冲区
        StringBuffer buf = new StringBuffer();
        // 设置文本域内容
        text.setText(titleString + "Loading First Of Two Files...\n");
        try {
            // 用类路径打开一个流
            conn = this.theClassFileURL.openStream();
            data = new DataInputStream(new BufferedInputStream(conn));
            try {
                // 死循环接收
                while (true) {
                    // 读取无符号的字节
                    int unsignedByte = data.readUnsignedByte();
                    // 十进制转换为字符串
                    HexString hexStr = new HexString(unsignedByte, 2);
                    buf.append(hexStr.getString());
                }
            } catch (EOFException e) {
                jvmPacman.setText(buf.toString());
            }
            try {

                text.setText(titleString + "Loading Second Of Two Files...\n");
                // 用文件路径打开一个流
                conn = this.theActTextURL.openStream();
                data = new DataInputStream(new BufferedInputStream(conn));
                buf.setLength(0);
                // 遍历，读取
                while ((line = data.readLine()) != null) {
                    if (line.length() > 0 && line.charAt(0) == '*') {
                        int starCount = line.length();
                        // 设置一个步结点
                        StepNode nextNode = new StepNode(buf.toString(), starCount);
                        // 如果第一步结点为空，第一步结点和最后一步结点都指向新结点，否则设置相应值
                        if (firstNode == null) {
                            firstNode = nextNode;
                            lastNode = nextNode;
                        } else {
                            lastNode.setNext(nextNode);
                            nextNode.setPrev(lastNode);
                            lastNode = nextNode;
                        }
                        // 清空字符缓冲区
                        buf.setLength(0);
                    } else {
                        buf.append(line + "\n");
                    }
                }
                ready = true;
                currentNode = firstNode;
                // 从哪个位置开始收集垃圾
                jvmPacman.setGobblePosition(0, firstNode.getByteCount());
                text.setText(currentNode.getString());
            } catch (IOException e) {
                text.setText(titleString + "IO Error: " + e.getMessage() + "\n\n" + ioErrorMsg
                             + cantGoFurtherString);
            } catch (SecurityException e) {
                text.setText(titleString + "Security Exception: " + e.getMessage() + "\n\n"
                             + securityErrorMsg + cantGoFurtherString);
            }
        } catch (IOException e) {
            text.setText(titleString + "IO Error: " + e.getMessage() + "\n\n" + ioErrorMsg
                         + cantGoFurtherString);
        } catch (SecurityException e) {
            text.setText(titleString + "Security Exception: " + e.getMessage() + "\n\n"
                         + securityErrorMsg + cantGoFurtherString);
        } finally {
            // 让GC回收
            runner = null;
        }
    }

}

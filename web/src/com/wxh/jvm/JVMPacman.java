/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * 获取一个类加载器
 * JVM收集器
 * @author wxh
 * @version $Id: JVMPacman.java, v 0.1 2017年12月19日 上午10:55:17 wxh Exp $
 */
public class JVMPacman extends Canvas {

    /** */
    private static final long serialVersionUID                   = -5655204471276685883L;

    private String            theString;
    /**默认字符串是无效的  */
    private boolean           stringValid                        = false;
    private int               currentGobblePosition;
    /** 有趣的字符统计  */
    private int               interestingCharsCount;
    /** 矩形数之间的字符  */
    private int               charsThatFitBetweenRectanglesCount = 2;

    public JVMPacman() {
        setBackground(Color.cyan);
    }

    /**
     * 设置文本内容
     * @param passedText
     */
    public void setText(String passedText) {
        theString = passedText;
        stringValid = true;
    }

    /** 
     *  获取维度的最小值
     * @return
     * @see java.awt.Component#minimumSize()
     */
    public Dimension minimumSize() {
        return new Dimension(110, 60);
    }

    /** 
     * 获取维度的首选值
     * @return
     * @see java.awt.Component#preferredSize()
     */
    public Dimension preferredSize() {
        return new Dimension(110, 60);
    }

    /**
     * 设置收集垃圾的位置
     * @param pos
     * @param interesting
     */
    public void setGobblePosition(int pos, int interesting) {
        // 将传递的位置乘以2，因为传递的位置代表 一个字节位置，
        // 而我们要currentgobbleposition表示一个字符的位置，有两个字符的每个字节 
        currentGobblePosition = pos * 2;
        interestingCharsCount = interesting * 2;
        // 重新绘制
        repaint();
    }

    /**
     * 收集垃圾位置
     * @param pos
     * @param interesting
     */
    public void gobbleToPosition(int pos, int interesting) {
        currentGobblePosition = pos * 2;
        interestingCharsCount = interesting * 2;
        repaint();
    }

    /** 
     * 绘制图
     * @param g
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    public void paint(Graphics g) {

        Font font = getFont();
        // 字体画笔
        FontMetrics fm = getFontMetrics(font);
        int heightOfOneLine = fm.getHeight();

        // 计算x的起点  
        Dimension dim = new Dimension();
        dim = size();
        int xStartingPoint = 5;

        // 计算y的起点  
        int totalHeight = heightOfOneLine * 2;
        int yStartingPoint = (dim.height - totalHeight) / 2;
        if (yStartingPoint < 5) {
            yStartingPoint = 5;
        }

        /**
         * 计算JVM矩形的宽度。这将是heightofoneline超过
         * “JVM的stringWidth”我会写在矩形的中间。
         * 这将使“JVM”周围的边界具有相同的宽度和高度。
         * 双方将平等heightofoneline / 2。我要把身高定下来。
         * 矩形heightofoneline * 2 .heightofoneline--行高
         */
        int jvmRectangleWidth = fm.stringWidth("JVM") + heightOfOneLine;

        // 绘制填充矩形 
        g.setColor(Color.green);
        g.fillRoundRect(xStartingPoint, yStartingPoint, jvmRectangleWidth, totalHeight, 5, 5);

        // 给它一个漂亮的黑色轮廓 
        g.setColor(Color.black);
        g.drawRoundRect(xStartingPoint, yStartingPoint, jvmRectangleWidth - 1, totalHeight - 1, 5,
            5);

        /**
         * 计算服务器矩形的宽度。这将是heightofoneline超过
         * “服务器”的stringWidth我会写在矩形的中间。
         * 这将使“服务器”周围的边框具有相同的宽度和高度。
         * 双方将平等heightofoneline / 2。我要把身高定下来。
         * 矩形heightofoneline * 2
         */
        int serverRectangleWidth = fm.stringWidth("Server") + heightOfOneLine;

        /**
         * 绘制填充矩形。x的起始点是画布减去服务器矩形的宽度减去5像素的空白。 
         */
        int xStartingPointServerRect = dim.width - serverRectangleWidth - 5;
        g.setColor(Color.green);
        g.fillRoundRect(xStartingPointServerRect, yStartingPoint, serverRectangleWidth,
            totalHeight, 5, 5);

        // 给这个长方形一个漂亮的黑色轮廓 
        g.setColor(Color.black);
        g.drawRoundRect(xStartingPointServerRect, yStartingPoint, serverRectangleWidth - 1,
            totalHeight - 1, 5, 5);

        // 矩形空白部分的宽度
        int whiteRectangleWidth = xStartingPointServerRect - jvmRectangleWidth - 5;
        if (whiteRectangleWidth > 0) {
            g.setColor(Color.white);
            g.fillRect(jvmRectangleWidth + 5, yStartingPoint + (heightOfOneLine / 2),
                whiteRectangleWidth, heightOfOneLine);
        }

        // 在矩形中绘制“JVM” 
        g.setColor(Color.black);
        xStartingPoint += (heightOfOneLine / 2);
        int ascent = fm.getAscent();
        yStartingPoint += ascent + (heightOfOneLine / 2);
        g.drawString("JVM", xStartingPoint, yStartingPoint);

        // 在矩形内绘制“服务器” 
        int xStartingPointServerText = xStartingPointServerRect + (heightOfOneLine / 2);
        g.drawString("Server", xStartingPointServerText, yStartingPoint);

        /**
         * 应该编写字符串，以便它适合JVM和服务器之间。
         * 矩形和字符串，在矩形和矩形之间 留下至少5像素的空间。
         */
        if (stringValid && currentGobblePosition < theString.length()) {

            /**
             * 首先需要弄清楚有多少字符适合两个矩形之间的空间。 
             */
            int xTextStartingPoint = jvmRectangleWidth + 10;
            int xTextEndingPoint = xStartingPointServerRect - 5;
            // 矩形之间可利用的像素
            int pixelsAvailableBetweenRectangles = xTextEndingPoint - xTextStartingPoint;
            if (pixelsAvailableBetweenRectangles < 0) {
                pixelsAvailableBetweenRectangles = 0;
            }

            /**
             * 将要写入的字符数初始化为其余的字符。
             * 这将减少以下，如果这个数额字符不适合。 
             */
            int charsToWriteCount = theString.length() - currentGobblePosition;

            /**
             * 检查要显示的字符串是否已经在两矩形。
             * 如果是这样，我们只使用字符总数，保留为要写入的字符数 。
             */
            int pixelWidthOfRemainingString = fm.stringWidth(theString
                .substring(currentGobblePosition));
            if (pixelWidthOfRemainingString > pixelsAvailableBetweenRectangles) {

                /**
                 * 第一个while循环增量charsthatfitbetweentworectanglescount
                 * 直到字符串在像素中的宽度刚好超过可用空间 
                 */
                String tryThisString = theString.substring(currentGobblePosition,
                    currentGobblePosition + charsThatFitBetweenRectanglesCount);
                int pixelsEaten = fm.stringWidth(tryThisString);
                while (pixelsEaten <= pixelsAvailableBetweenRectangles) {
                    ++charsThatFitBetweenRectanglesCount;
                    tryThisString = theString.substring(currentGobblePosition,
                        currentGobblePosition + charsThatFitBetweenRectanglesCount);
                    pixelsEaten = fm.stringWidth(tryThisString);
                }

                /**
                 * 第二循环降低charsthatfit变到字符串的像素宽度正好在可用宽度之下 
                 */
                while (pixelsEaten > pixelsAvailableBetweenRectangles) {
                    --charsThatFitBetweenRectanglesCount;
                    tryThisString = theString.substring(currentGobblePosition,
                        currentGobblePosition + charsThatFitBetweenRectanglesCount);
                    pixelsEaten = fm.stringWidth(tryThisString);
                }

                charsToWriteCount = charsThatFitBetweenRectanglesCount;
            }

            // 用红色画出有趣的字 
            g.setColor(Color.red);
            int redCharsCount = interestingCharsCount;
            if (redCharsCount > charsToWriteCount) {
                redCharsCount = charsToWriteCount;
            }
            String redString = theString.substring(currentGobblePosition, currentGobblePosition
                                                                          + redCharsCount);
            g.drawString(redString, xTextStartingPoint, yStartingPoint);

            // 用黑色绘制其余字符 
            int blackStringStartingPosition = currentGobblePosition + redCharsCount;
            int blackCharsCount = charsToWriteCount - redCharsCount;
            if (blackStringStartingPosition < theString.length() && blackCharsCount > 0) {

                xTextStartingPoint += fm.stringWidth(redString);
                g.setColor(Color.black);
                g.drawString(
                    theString.substring(blackStringStartingPosition, blackStringStartingPosition
                                                                     + blackCharsCount),
                    xTextStartingPoint, yStartingPoint);
            }
        }
    }

}

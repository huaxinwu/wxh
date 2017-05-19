/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.snake;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 贪吃蛇实体
 * @author wxh
 * @version $Id: SnakeModel.java, v 0.1 2016年12月8日 下午2:26:08 wxh Exp $
 */
public class SnakeModel extends Observable implements Runnable {
    boolean[][]             matrix;                            // 指示位置上有没蛇体或食物
    LinkedList              nodeArray       = new LinkedList(); // 蛇体
    NodeFood                food;
    int                     maxX;
    int                     maxY;
    int                     direction       = 2;               // 蛇运行的方向
    boolean                 running         = false;           // 运行状态

    int                     timeInterval    = 200;             // 时间间隔，毫秒
    double                  speedChangeRate = 0.75;            // 每次得速度变化率
    boolean                 paused          = false;           // 暂停标志

    int                     score           = 0;               // 得分
    int                     countMove       = 0;               // 吃到食物前移动的次数

    // UP and DOWN should be even
    // RIGHT and LEFT should be odd
    public static final int UP              = 2;
    public static final int DOWN            = 4;
    public static final int LEFT            = 1;
    public static final int RIGHT           = 3;

    public SnakeModel(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        reset();
    }

    public void reset() {
        direction = SnakeModel.UP; // 蛇运行的方向
        timeInterval = 200; // 时间间隔，毫秒
        paused = false; // 暂停标志
        score = 0; // 得分
        countMove = 0; // 吃到食物前移动的次数

        // initial matirx, 全部清0
        matrix = new boolean[maxX][];
        for (int i = 0; i < maxX; ++i) {
            matrix[i] = new boolean[maxY];
            Arrays.fill(matrix[i], false);
        }

        // initial the snake
        // 初始化蛇体，如果横向位置超过20个，长度为10，否则为横向位置的一半
        int initArrayLength = maxX > 20 ? 10 : maxX / 2;
        nodeArray.clear();
        for (int i = 0; i < initArrayLength; ++i) {
            int x = maxX / 2 + i;//maxX被初始化为20
            int y = maxY / 2; //maxY被初始化为30
            //nodeArray[x,y]: [10,15]-[11,15]-[12，15]~~[20,15]
            //默认的运行方向向上，所以游戏一开始nodeArray就变为：
            //       [10，14]-[10，15]-[11，15]-[12，15]~~[19，15]
            nodeArray.addLast(new NodeFood(x, y));
            matrix[x][y] = true;
        }

        // 创建食物
        food = createFood();
        matrix[food.x][food.y] = true;
    }

    public void changeDirection(int newDirection) {
        // 改变的方向不能与原来方向同向或反向
        if (direction % 2 != newDirection % 2) {
            direction = newDirection;
        }
    }

    public boolean moveOn() {
        NodeFood n = (NodeFood) nodeArray.getFirst();
        int x = n.x;
        int y = n.y;

        // 根据方向增减坐标值
        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        // 如果新坐标落在有效范围内，则进行处理
        if ((0 <= x && x < maxX) && (0 <= y && y < maxY)) {

            if (matrix[x][y]) { // 如果新坐标的点上有东西（蛇体或者食物）
                if (x == food.x && y == food.y) { // 吃到食物，成功
                    nodeArray.addFirst(food); // 从蛇头赠长

                    // 分数规则，与移动改变方向的次数和速度两个元素有关
                    int scoreGet = (10000 - 200 * countMove) / timeInterval;
                    score += scoreGet > 0 ? scoreGet : 10;
                    countMove = 0;

                    food = createFood(); // 创建新的食物
                    matrix[food.x][food.y] = true; // 设置食物所在位置
                    return true;
                } else
                    // 吃到蛇体自身，失败
                    return false;

            } else { // 如果新坐标的点上没有东西（蛇体），移动蛇体
                nodeArray.addFirst(new NodeFood(x, y));
                matrix[x][y] = true;
                n = (NodeFood) nodeArray.removeLast();
                matrix[n.x][n.y] = false;
                countMove++;
                return true;
            }
        }
        return false; // 触到边线，失败
    }

    public void run() {
        running = true;
        while (running) {
            try {
                Thread.sleep(timeInterval);
            } catch (Exception e) {
                break;
            }

            if (!paused) {
                if (moveOn()) {
                    setChanged(); // Model通知View数据已经更新
                    notifyObservers();
                } else {
                    JOptionPane.showMessageDialog(null, "you failed", "Game Over",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
        running = false;
    }

    private NodeFood createFood() {
        int x = 0;
        int y = 0;
        // 随机获取一个有效区域内的与蛇体和食物不重叠的位置
        do {
            Random r = new Random();
            x = r.nextInt(maxX);
            y = r.nextInt(maxY);
        } while (matrix[x][y]);

        return new NodeFood(x, y);
    }

    public void speedUp() {
        timeInterval *= speedChangeRate;
    }

    public void speedDown() {
        timeInterval /= speedChangeRate;
    }

    public void changePauseState() {
        paused = !paused;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < nodeArray.size(); ++i) {
            NodeFood n = (NodeFood) nodeArray.get(i);
            result += "[" + n.x + "," + n.y + "]";
        }
        return result;
    }
}

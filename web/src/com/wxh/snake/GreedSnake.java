/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.snake;

/**
 *  贪吃蛇运行类
 * @author wxh
 * @version $Id: GreedSnake.java, v 0.1 2016年12月8日 下午2:24:18 wxh Exp $
 */
public class GreedSnake {
    public static void main(String[] args) {
        SnakeModel model = new SnakeModel(20, 30);
        SnakeControl control = new SnakeControl(model);
        SnakeView view = new SnakeView(model, control);
        //添加一个观察者,让view成为model观察者
        model.addObserver(view);
        //开启线程
        new Thread(model).start();
    }

}

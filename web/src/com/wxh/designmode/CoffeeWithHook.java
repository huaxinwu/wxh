/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 需要钩子的咖啡
 * @author wxh
 * @version $Id: CoffeeWithHook.java, v 0.1 2017年5月27日 上午11:09:12 wxh Exp $
 */
public class CoffeeWithHook extends CoffeeBeverageWithHook {

    /**
     * 冲泡咖啡
     */
    @Override
    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    /**
     * 加糖、牛奶
     */
    @Override
    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    /** 
     * 顾客是否想要饮料
     * @return boolean
     * 
     */
    public boolean customrWantsCondiments() {
        String answer = getUserInput();
        // yes 
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取用户输入的字符串
     * @return
     */
    public String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        // 读取字符 一般用装饰模式中 bufferedreader,java中读取都是字符，应用程序都是字节
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = bufReader.readLine();
        } catch (Exception e) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }

}

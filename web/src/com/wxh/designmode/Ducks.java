/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 鸭子实现Comparable接口比较鸭子的体重
 * @author wxh
 * @version $Id: Ducks.java, v 0.1 2017年5月27日 下午2:45:30 wxh Exp $
 */
public class Ducks implements Comparable<Object> {
    String name;
    int    weight;

    /**
     * 
     */
    public Ducks(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * 重写，适应自己的业务场景
     * @return
     */
    public String toString() {
        return name + " weights " + weight;
    }

    /** 
     * @param o
     * @return
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        Ducks otherDucks = (Ducks) o;
        // 当前鸭子与另一只鸭子比较
        if (this.weight < otherDucks.weight) {
            return -1;
        } else if (this.weight == otherDucks.weight) {
            return 0;
        } else {
            return 1;
        }
    }

}

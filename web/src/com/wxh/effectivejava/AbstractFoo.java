/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 对于为了继承而设计的类，应该考虑提供一个无参构造器
 * @author wxh
 * @version $Id: AbstractFoo.java, v 0.1 2017年9月21日 下午2:51:04 wxh Exp $
 */
public abstract class AbstractFoo {
    private int     x;
    private int     y;
    /** 未初始化   */
    private boolean initialized = false;

    /**
     * 检查是否初始化
     * @throws IllegalStateException
     */
    private void checkInit() throws IllegalStateException {
        if (!initialized) {
            throw new IllegalStateException("Uninitialized");
        }
        // other operation
    }

    /**
     * 无参构造器
     */
    protected AbstractFoo() {

    }

    /**
     * 初始化
     * @param x
     * @param y
     */
    protected final void initalize(int x, int y) {
        if (initialized) {
            throw new IllegalStateException("already ininalized");
        }
        this.x = x;
        this.y = y;
        // 将状态修改为true
        initialized = true;
    }

    protected final int getX() {
        return x;
    }

    protected final int getY() {
        return y;
    }

    public AbstractFoo(int x, int y) {
        initalize(x, y);
    }
}

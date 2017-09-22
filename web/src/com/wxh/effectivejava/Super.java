/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;


/**
 * 构造器一定不能调用可重写方法
 * @author wxh
 * @version $Id: Super.java, v 0.1 2017年9月7日 下午3:02:27 wxh Exp $
 */
public class Super {
    public Super() {
        m();
    }

    public void m() {

    }

}

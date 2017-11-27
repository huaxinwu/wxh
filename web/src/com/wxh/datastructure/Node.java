/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 结点接口
 * 结点：数据域和指针域构成
 * @author wxh
 * @version $Id: Node.java, v 0.1 2017年11月21日 上午10:20:33 wxh Exp $
 */
public interface Node {
    /**
     * 获取结点的数据域
     * @return
     */
    Object getData();

    /**
     * 设置结点的数据域
     * @param ojb
     */
    void setData(Object obj);
}

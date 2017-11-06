/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

/**
 * 不要这样做，不推荐写法
 * @author wxh
 * @version $Id: MutablePoint.java, v 0.1 2017年10月25日 下午3:27:55 wxh Exp $
 */
@NotThreadSafe
public class MutablePoint {
    public int x;
    public int y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    /**
     * 自己封装自己
     * @param p
     */
    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }

}

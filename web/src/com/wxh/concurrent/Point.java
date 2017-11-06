/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.concurrent;

import org.hibernate.annotations.Immutable;

/**
 * 
 * @author wxh
 * @version $Id: Point.java, v 0.1 2017年10月26日 上午9:58:45 wxh Exp $
 */
@Immutable
public class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

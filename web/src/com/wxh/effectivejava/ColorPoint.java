/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.awt.Color;

/**
 * 子类扩展成员变量，equals得重写
 * @author wxh
 * @version $Id: ColorPoint.java, v 0.1 2017年9月5日 下午4:10:26 wxh Exp $
 */
public class ColorPoint {
    private Color color;
    /** 复合模式 */
    private Point point;

    /**
     * @param x
     * @param y
     */
    public ColorPoint(int x, int y, Color color) {
        //        super(x, y);
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        ColorPoint colorPoint = (ColorPoint) o;
        return super.equals(o) && colorPoint.color == color;
    }

}

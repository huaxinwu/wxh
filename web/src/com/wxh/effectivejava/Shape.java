/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 图形形状
 * 类层次比起联合的好处：提供类型的安全性,代码非常简洁
 * C语言联合结构体：
 * #include 'math.h'
 * typedef enum {RECTANGLE,CIRCLE} shapeType_t;
 * typedef struct{
 *  double length;
 *  double width;
 * } rectangleDimensions_t
 * typedef struct{
 *  double radius;
 * } circleDimensions_t
 * typedef struct{
 *  shapeType_t tag;
 *  union{
 *      rectangleDimensions_t rectangle;
 *      circleDimensions_t circle;
 *  } dimensions
 * } shape_t
 * double area(shape_t *shape){
 *  switch(shap->tag){
 *      case RECTANGLE:{
 *          double length = shape->dimensions.rectangle.length;
 *          double width = shape->dimensions.rectangle.width;
 *          return length*width;
 *      }
 *      case CIRCLE:{
 *          double r = shape->dimensions.circle.radius;
 *          return Math.PI*r*r;
 *      }
 *      default:return -1.0;
 *  }
 * }
 * @author wxh
 * @version $Id: Shape.java, v 0.1 2017年9月8日 下午2:28:04 wxh Exp $
 */
public abstract class Shape {
    /**
     * 计算图形面积
     * @return
     */
    abstract double area();
}

/**
 * 图形圆
 */
class Circle extends Shape {
    /** 圆的半径  */
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    /** 
     * @return
     * @see com.wxh.effectivejava.Shape#area()
     */
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

/**
* 图形矩形
*/
class Rectangle extends Shape {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /** 
     * @return
     * @see com.wxh.effectivejava.Shape#area()
     */
    @Override
    double area() {
        return length * width;
    }
}

/**
 * 图形正方形
 * 类与类之间的层次关系
 * @author wxh
 * @version $Id: Shape.java, v 0.1 2017年9月8日 下午2:56:36 wxh Exp $
 */
class Square extends Rectangle {

    /**
     * @param side
     */
    Square(double side) {
        super(side, side);
    }

    double side() {
        return length;
    }
}
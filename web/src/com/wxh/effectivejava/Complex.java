/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

/**
 * 非可变的类
 * 1.不能拥有修改它方法
 * 2.保证子类没有可重写方法
 * 3.所有属性都是final，其实也不一定Stirng中就有非final
 * 4.所有属性都是私有
 * 5.保证对于任何可变组件互斥访问？？？
 * 
 * 复数z=x+iy，满足等式  ,其中x，y是任意实数，x称为复数z的实部，y称为复数z的虚部
 * @author wxh
 * @version $Id: Complex.java, v 0.1 2017年9月7日 上午10:44:05 wxh Exp $
 */
public class Complex {

    /** 实部  */
    private final float readPart;
    /** 虚部  */
    private final float imaginaryPart;

    //    public Complex(float readPart, float imaginaryPart) {
    //        this.readPart = readPart;
    //        this.imaginaryPart = imaginaryPart;
    //    }
    /**
     * 私有化构造器，防止子类实例化
     * 提供获取该实例的公共方法
     * @param readPart
     * @param imaginaryPart
     */
    private Complex(float readPart, float imaginaryPart) {
        this.readPart = readPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static Complex valueOf(float readPart, float imaginaryPart) {
        return new Complex(readPart, imaginaryPart);
    }

    // 公有访问方法
    public float readPart() {
        return readPart;
    }

    public float imaginaryPart() {
        return imaginaryPart;
    }

    /**
     * 相加
     * @param complex
     * @return Complex
     */
    public Complex add(Complex complex) {
        return new Complex(readPart + complex.readPart, imaginaryPart + complex.imaginaryPart);
    }

    /**
     * 相减
     * @param complex
     * @return Complex
     */
    public Complex subtract(Complex complex) {
        return new Complex(readPart - complex.readPart, imaginaryPart - complex.imaginaryPart);
    }

    /**
     * 相乘
     * @param complex
     * @return Complex
     */
    public Complex multiply(Complex complex) {
        return new Complex(readPart * complex.readPart - imaginaryPart * complex.imaginaryPart,
            readPart * complex.readPart + imaginaryPart * complex.imaginaryPart);
    }

    /**
     * 相除
     * @param complex
     * @return Complex
     */
    public Complex divide(Complex complex) {
        float temp = complex.readPart * complex.readPart + complex.imaginaryPart
                     * complex.imaginaryPart;
        return new Complex((readPart * complex.readPart + imaginaryPart * complex.imaginaryPart)
                           / temp, (imaginaryPart * complex.imaginaryPart - readPart
                                                                            * complex.readPart)
                                   / temp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        // 这样编写目的就是防止出现if else 多种情况出现，最好一层逻辑处理而不是多分支
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex complex = (Complex) o;
        // 把类中属性与形参对象属性比较，必须转换运算过程会精度损失出现误差
        return (Float.floatToIntBits(readPart) == Float.floatToIntBits(complex.readPart))
               && (Float.floatToIntBits(imaginaryPart) == Float
                   .floatToIntBits(complex.imaginaryPart));

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + Float.floatToIntBits(readPart);
        result = 37 * result + Float.floatToIntBits(imaginaryPart);
        return result;
    }

    @Override
    public String toString() {
        return "(" + readPart + "+" + imaginaryPart + ")";
    }

}

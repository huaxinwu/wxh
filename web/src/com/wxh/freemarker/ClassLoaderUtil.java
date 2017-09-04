/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.freemarker;

import java.io.File;

/**
 * 获取各种Java文件路径(相对路径，绝对路径)
 * @author wxh
 * @version $Id: ClassLoaderUtil.java, v 0.1 2017年9月4日 下午1:57:22 wxh Exp $
 */
public class ClassLoaderUtil {

    /**
     * 根据工程目录获取文件路径
     * JavaEE下getProperty:D:\github\web
     * @return String
     */
    public static String getProperty() {
        return System.getProperty("user.dir");
    }

    /**
     * 根据/获取文件路径
     * JavaEE下getFileAbsolutePath: D:\
     * @return String
     */
    public static String getFileAbsolutePath() {
        return new File("/").getAbsolutePath();
    }

    /**
     * 根据当前类所在线程获取文件路径
     * classpath下file:/D:/github/web/WebRoot/WEB-INF/classes/
     * @return String
     */
    public static String getContextClassLoaderResource() {
        return Thread.currentThread().getContextClassLoader().getResource("").toString();
    }

    /**
     * 根据类加载路径获取文件路径
     * classpath下file:/D:/github/web/WebRoot/WEB-INF/classes/
     * @return String
     */
    public static String getSystemResource() {
        return ClassLoader.getSystemResource("").toString();
    }

    /**
     * 根据反射获取文件路径
     * classpath下getClassReflect: file:/D:/github/web/WebRoot/WEB-INF/classes/com/wxh/freemarker/
     * @param clazz
     * @return String
     */
    public static String getClassReflect(Class<?> clazz) {
        return clazz.getResource("").toString();
    }

    /**
     * 根据反射获取class文件路径
     * classpath下getClassReflectResource: file:/D:/github/web/WebRoot/WEB-INF/classes/
     * @param clazz
     * @return String
     */
    public static String getClassReflectResource(Class<?> clazz) {
        return clazz.getResource("/").toString();
    }

    /**
     * 适用于静态方法
     * 获取该类全限定名
     * @return String
     */
    public static String getThreadClassName() {
        return Thread.currentThread().getStackTrace()[1].getClassName();
    }

    /**
     * 获取该类的文件名
     * @return String
     */
    public static String getThreadFileName() {
        return Thread.currentThread().getStackTrace()[1].getFileName();
    }

    /**
     * 适用于非静态方法
     * @return String
     */
    public String getClassName() {
        return this.getClass().getName();
    }

    public static void main(String[] args) {
        System.out.println("getProperty: " + getProperty());
        System.out.println("getFileAbsolutePath: " + getFileAbsolutePath());
        System.out.println("getContextClassLoaderResource: " + getContextClassLoaderResource());
        System.out.println("getSystemResource: " + getSystemResource());
        System.out.println("getClassReflect: " + getClassReflect(ClassLoaderUtil.class));
        System.out.println("getClassReflectResource: "
                           + getClassReflectResource(ClassLoaderUtil.class));
    }

}

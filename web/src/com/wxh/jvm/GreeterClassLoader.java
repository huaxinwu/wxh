/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 用户自定义类装载器
 * @author wxh
 * @version $Id: GreeterClassLoader.java, v 0.1 2017年12月14日 下午2:58:13 wxh Exp $
 */
public class GreeterClassLoader extends ClassLoader {

    private String basePath;

    public GreeterClassLoader() {

    }

    public GreeterClassLoader(String basePath) {
        this.basePath = basePath;
    }

    /**
    * 从基础路径获取类型：处理方式一般是通过流的输入输出实现
    * @param tyepName
    * @return byte[]
    */
    private byte[] getTypeFromBasePath(String tyepName) {
        // 文件读取流
        FileInputStream fis;
        // 文件路径,拼接class文件路径
        String fileName = basePath + File.separator + tyepName.replace(".", File.separator)
                          + ".class";
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("文件没有找到异常!");
            return null;
        }

        // 缓冲读取流--装饰模式
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 字节数组写出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            int len = bis.read();
            while (len != -1) {
                out.write(len);
                len = bis.read();
            }
        } catch (IOException e) {
            System.out.println("读取写出流异常!");
            return null;
        }
        return out.toByteArray();
    }

    /**
     * 加载类整个过程
     * 启动类装载器(java_home\\lib)--标准扩展类装载器(java_home\\lib\\ext)---系统类装载器(classpath下所有类)--用户自定义类装载器
     * 系统类装载器--> 类路径类装载器
     * jdk1.1 是这个方法是个抽象方法
     * @param className
     * @param resolveIt
     * @return Class
     * @throws ClassNotFoundException
     * @see java.lang.ClassLoader#loadClass(java.lang.String, boolean)
     */
    public synchronized Class loadClass(String className, boolean resolveIt)
                                                                            throws ClassNotFoundException {
        Class result;
        byte[] classData;
        // 类装载器
        result = findLoadedClass(className);
        if (result != null) {
            // 不为空，把结果返回
            return result;
        }
        // 不用委托对象处理
        if (className.compareTo("Spoofed") != 0) {
            try {
                // 系统类装载器
                result = super.findSystemClass(className);
                return result;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("类没有找到异常!");
            }
        }
        // 以某个字符串开头
        if (className.startsWith("java.")) {
            throw new ClassNotFoundException();
        }

        // 获取字节数组
        classData = getTypeFromBasePath(className);
        if (classData == null) {
            System.out.println("GCL--Can't load class: " + className);
            throw new ClassNotFoundException();
        }
        // 解释类
        result = defineClass(className, classData, 0, classData.length);
        if (result == null) {
            System.out.println("GCL--Class format error: " + className);
            throw new ClassFormatError();
        }
        // 解析类
        if (resolveIt) {
            resolveClass(result);
        }
        return result;

    }
}

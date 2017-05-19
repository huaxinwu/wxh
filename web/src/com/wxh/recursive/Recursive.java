/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.recursive;

import java.io.File;

/**
 * 递归算法删除指定目录下子文件
 * @author wxh
 * @version $Id: Recursive.java, v 0.1 2016年12月9日 下午3:56:20 wxh Exp $
 */
public class Recursive {
    private static final String FILENAME = "1111";

    public static void main(String[] agrs) {
        System.out.println("----------");
        String path = "e:\\recursive";
        File file = new File(path);
        searchFile(file);
        System.out.println("--------------");
    }

    /**
     * 搜索文件，搜索到就删除(递归的临界点即出口)
     * @param file
     */
    public static void searchFile(File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                //匹配到扩展名文件删除
                if (f.getName().equals(FILENAME)) {
                    System.out.println("文件的绝对路径：" + f.getAbsolutePath());
                    deleteDirectory(f);
                } else {
                    //否则继续查找所要匹配文件
                    searchFile(f);
                }
            }
        }
    }

    /**
     * 删除匹配目录
     * @param file
     */
    public static void deleteDirectory(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    //是目录删除目录
                    deleteDirectory(f);
                } else {
                    //不是目录删除文件
                    f.delete();
                }
            }
        } else {
            file.delete();
        }

    }
}

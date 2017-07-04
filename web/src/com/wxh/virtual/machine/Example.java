/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.virtual.machine;

import java.io.File;
import java.io.FilePermission;
import java.security.Permission;

/**
 * implies代表permission一个权限，将一个permission作为参数，返回一个布尔类型
 * @author wxh
 * @version $Id: Example.java, v 0.1 2017年7月4日 上午11:23:17 wxh Exp $
 */
public class Example {

    public static void main(String[] args) {
        char sep = File.separatorChar;
        Permission file = new FilePermission(sep + "tmp" + sep + "f", "read");
        Permission star = new FilePermission(sep + "tmp" + sep + "*", "read");
        boolean starImpliesFile = star.implies(file);
        boolean fileImpliesStar = file.implies(star);
        System.out.println("Star implies file=" + starImpliesFile);
        System.out.println("File implies star=" + fileImpliesStar);
    }
}

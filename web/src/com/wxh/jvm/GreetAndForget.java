/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 卸载无法触及的greeter类
 * 动态装载的类型变为无法触及而要被虚拟机卸载
 * @author wxh
 * @version $Id: GreetAndForget.java, v 0.1 2017年12月14日 下午4:22:38 wxh Exp $
 */
public class GreetAndForget {

    public static void main(String[] args) {
        if (args.length <= 1) {
            System.out.println("Enter base path and greeter class names as args.");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            try {
                // 用户自定义类装载器
                GreeterClassLoader gcl = new GreeterClassLoader(args[0]);
                Class c = gcl.loadClass(args[i]);
                Object o = c.newInstance();
                Greeter greeter = (Greeter) o;
                greeter.greet();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

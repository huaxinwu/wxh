/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 用户自定义类装载器执行动态扩展的例子
 * @author wxh
 * @version $Id: Greet.java, v 0.1 2017年12月14日 下午2:54:12 wxh Exp $
 */
public class Greet {

    public static void main(String[] args) {
        if (args.length <= 1) {
            System.out.println("Enter base path and greeter class names as args.");
            return;
        }

        // 用户自定义类装载器
        GreeterClassLoader gcl = new GreeterClassLoader(args[0]);

        for (int i = 0; i < args.length; i++) {
            try {
                // 获取传入参数的类类型--反射机制
                Class c = gcl.loadClass(args[i]);
                Object obj = c.newInstance();
                // 接口实例化
                Greeter greeter = (Greeter) obj;
                greeter.greet();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("类没有找到异常！");
            } catch (InstantiationException e) {
                e.printStackTrace();
                System.out.println("类实例化异常！");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.out.println("类非法访问异常！");
            }
        }
    }
}

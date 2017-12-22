/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 使用forName的动态扩展
 * @author wxh
 * @version $Id: EasyGreet.java, v 0.1 2017年12月14日 下午4:07:48 wxh Exp $
 */
public class EasyGreet {

    public static void main(String[] args) {
        if (args.length <= 1) {
            System.out.println("Enter base path and greeter class names as args.");
            return;
        }
        for (int i = 0; i < args.length; i++) {
            try {
                // forName获取一个类类型--反射
                Class c = Class.forName(args[i]);
                Object obj = c.newInstance();
                Greeter greeter = (Greeter) obj;
                greeter.greet();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

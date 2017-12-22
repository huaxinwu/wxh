/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * Java连接模型的例子
 * Java虚拟机装载Salutation类，并且已经装载、连接、初始化它的所有超类，现在虚拟机来准备连接Salutation类
 * 连接过程：第一步，就是验证Salutation的二进制形式的完整性
 * 1.Salutation的二进制数据结构的上是正确的
 * 2.Salutation正确地实现了Java语言的语义
 * 3.Salutation字节码不会导致虚拟机崩溃
 *      第二步，验证完，给Salutation准备内存空间；第三步，Salutation初始化
 * @author wxh
 * @version $Id: Salutation.java, v 0.1 2017年12月14日 上午10:59:13 wxh Exp $
 */
public class Salutation {

    private static final String HELLO      = "Hello,World";
    private static final String GREETING   = "Greetings,planet";
    private static final String SALUTATION = "Salutaionts,orb!";

    private static int          choice     = (int) (Math.random() * 2.99);

    public static void main(String[] args) {
        String str = HELLO;
        if (choice == 1) {
            str = GREETING;
        } else if (choice == 2) {
            str = SALUTATION;
        }
        System.out.println(str);
    }
}

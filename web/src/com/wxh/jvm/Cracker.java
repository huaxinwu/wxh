/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.jvm;

/**
 * 类型混淆及其装载约束解决方案的例子
 * 类型混淆：一个类实例冒充另一个类实例
 * @author wxh
 * @version $Id: Cracker.java, v 0.1 2017年12月15日 上午10:29:42 wxh Exp $
 */
public class Cracker implements Greeter {

    /** 
     * 
     * @see com.wxh.jvm.Greeter#greet()
     */
    @Override
    public void greet() {
        Spoofed spoofed = new Spoofed();
        System.out.println("secret val=" + spoofed.giveMeFive());

        // 调用静态方法
        spoofed = Delegated.getSpoofed();
        System.out.println("secret val=" + spoofed.giveMeFive());
    }

}

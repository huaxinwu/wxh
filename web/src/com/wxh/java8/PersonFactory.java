/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

/**
 * 创建Person对象的工厂接口
 * @author wxh
 * @version $Id: PersonFactory.java, v 0.1 2018年2月6日 下午3:06:15 wxh Exp $
 */
public interface PersonFactory<P extends Person> {

    // 用Person类或它的子类来构建一个Person对象
    P create(String firstName, String lastName);
}

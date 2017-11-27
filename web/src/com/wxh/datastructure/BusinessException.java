/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 业务异常处理方式
 * @author wxh
 * @version $Id: BusinessException.java, v 0.1 2017年11月17日 下午2:00:47 wxh Exp $
 */
public class BusinessException {

    /**
     * 1.try...catch处理方式
     */
    public void operation() {
        try {
            System.out.println("正确操作");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误操作");
        }
    }

    /**
     * 2.throws处理方式
     * @throws Exception
     */
    public void operation2() throws Exception {
        System.out.println("测试异常");
    }

    /**
     * 3.throw 处理方式
     * @return
     */
    public boolean operation23() {
        int result = 4;
        if (result > 0) {
            System.out.println("正确结果");
            return true;
        } else {
            throw new RuntimeException();
        }
    }
}

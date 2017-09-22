/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.effectivejava;

import java.util.Date;

/**
 * 不可改变时间周期
 * @author wxh
 * @version $Id: Period.java, v 0.1 2017年9月11日 下午2:18:23 wxh Exp $
 */
public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        //        this.start = start;
        //        this.end = end;
        // 对构造器的可变参数进行保护性拷贝是有必要的
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        // 一般不这样处理，在service层处理
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + "after" + end);
        }

    }

    public Date start() {
        //        return start;
        return (Date) start.clone();
    }

    public Date end() {
        //        return end;
        return (Date) end.clone();
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        System.out.println("修改前：" + end.getYear());
        Period period = new Period(start, end);
        // 这种约束条件还是容易被违反的
        end.setYear(78);
        System.out.println("修改后：" + end.getYear());
        // 防止恶意篡改参数值
        period.end().setYear(78);
        System.out.println("修改后2：" + end.getYear());
    }
}

/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.datastructure;

/**
 * 教师比较策略
 * @author wxh
 * @version $Id: StudentStrategy.java, v 0.1 2017年11月20日 下午3:16:23 wxh Exp $
 */
public class TeacherStrategy implements Strategy {

    /** 
     * @param obj1
     * @param obj2
     * @return boolean
     */
    @Override
    public boolean equals(Object obj1, Object obj2) {
        // 如果比较两个对象都是Teacher实例即子类
        if (obj1 instanceof Teacher && obj2 instanceof Teacher) {
            Teacher t1 = (Teacher) obj1;
            Teacher t2 = (Teacher) obj2;
            return t1.gettId().equals(t2.gettId());
        }
        return false;
    }

    /** 
     * @param obj1
     * @param obj2
     * @return int
     */
    @Override
    public int compare(Object obj1, Object obj2) {
        if (obj1 instanceof Teacher && obj2 instanceof Teacher) {
            Teacher t1 = (Teacher) obj1;
            Teacher t2 = (Teacher) obj2;
            return t1.gettId().compareTo(t2.gettId());
        }
        return obj1.toString().compareTo(obj2.toString());
    }

}

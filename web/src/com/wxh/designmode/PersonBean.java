/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 保护代理
 * @author wxh
 * @version $Id: PersonBean.java, v 0.1 2017年6月14日 上午10:44:39 wxh Exp $
 */
public interface PersonBean {

    /**
     * 获取名字
     * @return
     */
    String getName();

    /**
     * 获取性别
     * @return
     */
    String getGender();

    /**
     * 获取兴趣
     * @return
     */
    String getInterests();

    /**
     * 喜欢或者不喜欢状态
     * @return
     */
    int getHotOrNotRating();

    /**
     * 给名字赋值
     * @param name
     */
    void setName(String name);

    /**
     * 给性别赋值
     * @param gender
     */
    void setGender(String gender);

    /**
     * 给兴趣赋值
     * @param interests
     */
    void setInterests(String interests);

    /**
     * 给喜欢或者不喜欢状态赋值
     * @param rating
     */
    void setHotOrNotRating(int rating);

}

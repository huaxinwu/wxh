/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

/**
 * 个人Bean实现
 * @author wxh
 * @version $Id: PersonBeanImpl.java, v 0.1 2017年6月14日 上午10:52:55 wxh Exp $
 */
public class PersonBeanImpl implements PersonBean {
    String name;
    String gender;
    String interests;
    int    rating;
    int    ratingCount = 0;

    /** 
     * @return
     * @see com.wxh.designmode.PersonBean#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /** 
     * @return
     * @see com.wxh.designmode.PersonBean#getGender()
     */
    @Override
    public String getGender() {
        return gender;
    }

    /** 
     * @return
     * @see com.wxh.designmode.PersonBean#getInterests()
     */
    @Override
    public String getInterests() {
        return interests;
    }

    /** 
     * @return
     * @see com.wxh.designmode.PersonBean#getHotOrNotRating()
     */
    @Override
    public int getHotOrNotRating() {
        if (ratingCount == 0) {
            return 0;
        }
        return (rating / ratingCount);
    }

    /** 
     * @param name
     * @see com.wxh.designmode.PersonBean#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * @param gender
     * @see com.wxh.designmode.PersonBean#setGender(java.lang.String)
     */
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** 
     * @param interests
     * @see com.wxh.designmode.PersonBean#setInterests(java.lang.String)
     */
    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /** 
     * 增加计数器
     * @param rating
     * @see com.wxh.designmode.PersonBean#setHotOrNotRating(int)
     */
    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount++;
    }

}

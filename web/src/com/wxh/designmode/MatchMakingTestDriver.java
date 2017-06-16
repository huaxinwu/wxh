/**
 * wxh Inc.
 * Copyright (c) 2006-2017 All Rights Reserved.
 */
package com.wxh.designmode;

import java.lang.reflect.Proxy;

/**
 * 
 * @author wxh
 * @version $Id: MatchMakingTestDriver.java, v 0.1 2017年6月16日 下午4:00:56 wxh Exp $
 */
public class MatchMakingTestDriver {

    public static void main(String[] args) {
        MatchMakingTestDriver test = new MatchMakingTestDriver();
        test.drive();
    }

    public MatchMakingTestDriver() {
        initializeDatabase();
    }

    /**
     * 驱动器
     */
    public void drive() {
        PersonBean joe = getPersonFromDatabase("Joe JavaBean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling,Go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("bowling,Go");
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Interests set from owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());

        // 其他方法
    }

    /**
     * 初始化数据库
     */
    public void initializeDatabase() {

    }

    public PersonBean getPersonFromDatabase(String name) {
        return null;
    }

    /**
     * 获取一个personBean
     * @param person
     * @return
     */
    public PersonBean getOwnerProxy(PersonBean person) {

        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person
            .getClass().getInterfaces(), new OwnerInvocationhandler(person));
    }

}

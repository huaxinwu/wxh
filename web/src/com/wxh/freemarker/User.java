/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.freemarker;

import java.io.Serializable;

/**
 * 用户信息类
 * @author wxh
 * @version $Id: User.java, v 0.1 2017年9月4日 下午3:17:03 wxh Exp $
 */
public class User implements Serializable {

    /** */
    private static final long serialVersionUID = 5749760782923490494L;
    /** 姓名 */
    private String            name;
    /** 地址信息 */
    private Address           address;

    /**
     * 
     */
    public User() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param name
     * @param address
     */
    public User(String name, Address address) {
        super();
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

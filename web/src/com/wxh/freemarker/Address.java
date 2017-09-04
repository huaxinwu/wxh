/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.freemarker;

import java.io.Serializable;

/**
 * 地址信息类
 * @author wxh
 * @version $Id: Address.java, v 0.1 2017年9月4日 下午3:18:17 wxh Exp $
 */
public class Address implements Serializable {

    /** */
    private static final long serialVersionUID = 653786781826378847L;

    /** 国家  */
    private String            country;
    /** 城市  */
    private String            city;

    /**
     * 
     */
    public Address() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param country
     * @param city
     */
    public Address(String country, String city) {
        super();
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

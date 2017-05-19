/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.model;

import java.util.Date;

/**
 * 女神实体类
 * @author wxh
 * @version $Id: Goddess.java, v 0.1 2016年12月20日 上午10:26:16 wxh Exp $
 */
public class Goddess {

    private Integer id;
    private String  userName;  //姓名
    private Integer sex;       //性别
    private Integer age;       //年龄
    private Date    birthday;  //生日
    private String  email;     //邮箱
    private String  mobile;    //手机号码
    private String  createUser; //创建人
    private Date    createDate; //创建时间
    private String  updateUser; //修改人
    private Date    updateDate; //修改时间
    private Integer isdel;     //删除标记：0：否  1：是

    /**
     * 
     */
    public Goddess() {

    }

    /**
     * @param id
     * @param userName
     * @param sex
     * @param age
     * @param birthday
     * @param email
     * @param mobile
     * @param createUser
     * @param createDate
     * @param updateUser
     * @param updateDate
     * @param isdel
     */
    public Goddess(Integer id, String userName, Integer sex, Integer age, Date birthday,
                   String email, String mobile, String createUser, Date createDate,
                   String updateUser, Date updateDate, Integer isdel) {
        super();
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.mobile = mobile;
        this.createUser = createUser;
        this.createDate = createDate;
        this.updateUser = updateUser;
        this.updateDate = updateDate;
        this.isdel = isdel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

}

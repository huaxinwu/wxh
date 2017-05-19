/**
 * Ambition Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wxh.model.Goddess;
import com.wxh.util.DBUtils;

/**
 * 数据访问层
 * @author wxh
 * @version $Id: GoddessDAO.java, v 0.1 2016年12月20日 上午10:57:56 wxh Exp $
 */
public class GoddessDAO {

    /**
     * 添加女神信息
     * @param goddess
     * @throws SQLException
     */
    public void addGoddess(Goddess goddess) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "insert into goddess(user_name,sex,age,birthday,email,"
                     + "mobile,create_user,create_date,update_user,update_date,isdel) "
                     + "values(?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, goddess.getUserName());
        pstmt.setInt(2, goddess.getSex());
        pstmt.setInt(3, goddess.getAge());
        pstmt.setDate(4, new Date(goddess.getBirthday().getTime()));
        pstmt.setString(5, goddess.getEmail());
        pstmt.setString(6, goddess.getMobile());
        pstmt.setString(7, goddess.getCreateUser());
        pstmt.setString(8, goddess.getUpdateUser());
        pstmt.setInt(9, goddess.getIsdel());
        pstmt.execute();
    }

    /**
     * 更新女神信息
     * @param goddess
     * @throws SQLException
     */
    public void updateGoddess(Goddess goddess) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "update goddess set user_name=?,age=?,birthday=?,email=?,"
                     + "mobile=?,update_user=?,update_date=current_date() where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, goddess.getUserName());
        pstmt.setInt(2, goddess.getAge());
        pstmt.setDate(3, new Date(goddess.getBirthday().getTime()));
        pstmt.setString(4, goddess.getEmail());
        pstmt.setString(5, goddess.getMobile());
        pstmt.setString(6, goddess.getUpdateUser());
        pstmt.setInt(7, goddess.getId());
        pstmt.execute();
    }

    /**
     * 根据ID删除女神信息
     * @param id
     * @throws SQLException
     */
    public void deleteGoddess(Integer id) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "delete from goddess where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.execute();
    }

    /**
     * 批量刪除女神信息
     * @param ids
     * @throws SQLException
     */
    public void deleteGoddess(Integer[] ids) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "update goddess set isdel =1 where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        for (int i = 0; i < ids.length; i++) {
            pstmt.setInt(1, ids[i]);
            //批量添加
            pstmt.addBatch();
        }
        pstmt.executeBatch();

    }

    /**
     * 查询所有女神信息
     * @return
     * @throws SQLException
     */
    public List<Goddess> queryGoddess() throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "select * from goddess where isdel=0";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Goddess> list = new ArrayList<Goddess>();
        while (rs.next()) {
            Goddess god = new Goddess();
            god.setId(rs.getInt(1));
            god.setUserName(rs.getString(2));
            god.setSex(rs.getInt(3));
            god.setAge(rs.getInt(4));
            god.setBirthday(rs.getDate(5));
            god.setEmail(rs.getString(6));
            god.setMobile(rs.getString(7));
            god.setCreateUser(rs.getString(8));
            god.setCreateDate(rs.getDate(9));
            god.setUpdateUser(rs.getString(10));
            god.setUpdateDate(rs.getDate(11));
            god.setIsdel(rs.getInt(12));
            list.add(god);
        }
        return list;
    }

    /**
     * 根据姓名查询女神信息
     * @param userName
     * @return
     * @throws SQLException
     */
    public List<Goddess> queryGoddess(String userName) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "select * from goddess where isdel=0 and user_name like ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + userName + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Goddess> list = new ArrayList<Goddess>();
        while (rs.next()) {
            Goddess god = new Goddess();
            god.setId(rs.getInt(1));
            god.setUserName(rs.getString(2));
            god.setSex(rs.getInt(3));
            god.setAge(rs.getInt(4));
            god.setBirthday(rs.getDate(5));
            god.setEmail(rs.getString(6));
            god.setMobile(rs.getString(7));
            god.setCreateUser(rs.getString(8));
            god.setCreateDate(rs.getDate(9));
            god.setUpdateUser(rs.getString(10));
            god.setUpdateDate(rs.getDate(11));
            god.setIsdel(rs.getInt(12));
            list.add(god);
        }
        return list;
    }

    /**
     * 根据ID获取女神信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Goddess getGoddess(Integer id) throws SQLException {
        Connection conn = DBUtils.getConn();
        String sql = "select * from goddess where isdel=0 and id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        Goddess god = null;
        if (rs.next()) {
            god = new Goddess();
            god.setId(rs.getInt(1));
            god.setUserName(rs.getString(2));
            god.setSex(rs.getInt(3));
            god.setAge(rs.getInt(4));
            god.setBirthday(rs.getDate(5));
            god.setEmail(rs.getString(6));
            god.setMobile(rs.getString(7));
            god.setCreateUser(rs.getString(8));
            god.setCreateDate(rs.getDate(9));
            god.setUpdateUser(rs.getString(10));
            god.setUpdateDate(rs.getDate(11));
            god.setIsdel(rs.getInt(12));

        }
        return god;
    }

    /**
     * 根据参数列表查询女神信息
     * @param params
     * @return
     * @throws SQLException
     */
    public List<Goddess> queryGoddess(List<Map<String, Object>> params) throws SQLException {
        Connection conn = DBUtils.getConn();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from goddess where 1=1 ");
        if (params != null && params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                Map<String, Object> map = new HashMap<String, Object>();
                // and name like %小溪%
                sb.append(" and " + map.get("name") + " " + map.get("relation") + " "
                          + map.get("value"));
            }
        }
        PreparedStatement pstmt = conn.prepareStatement(sb.toString());
        ResultSet rs = pstmt.executeQuery();
        List<Goddess> list = new ArrayList<Goddess>();
        while (rs.next()) {
            Goddess god = new Goddess();
            god.setId(rs.getInt(1));
            god.setUserName(rs.getString(2));
            god.setSex(rs.getInt(3));
            god.setAge(rs.getInt(4));
            god.setBirthday(rs.getDate(5));
            god.setEmail(rs.getString(6));
            god.setMobile(rs.getString(7));
            god.setCreateUser(rs.getString(8));
            god.setCreateDate(rs.getDate(9));
            god.setUpdateUser(rs.getString(10));
            god.setUpdateDate(rs.getDate(11));
            god.setIsdel(rs.getInt(12));
            list.add(god);
        }
        return list;
    }

}

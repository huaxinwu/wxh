/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.action;

import java.sql.SQLException;
import java.util.List;

import com.wxh.dao.GoddessDAO;
import com.wxh.model.Goddess;

/**
 *
 * @author wxh
 * @version $Id: GoddessAction.java, v 0.1 2016年12月20日 上午11:59:03 wxh Exp $
 */
public class GoddessAction {

    /**
     * 添加女神信息
     * @param god
     * @throws SQLException
     */
    public void add(Goddess goddess) throws SQLException {
        GoddessDAO godDao = new GoddessDAO();
        goddess.setSex(1);
        goddess.setCreateUser("admin");
        goddess.setUpdateUser("admin");
        goddess.setIsdel(0);
        godDao.addGoddess(goddess);
    }

    /**
     * 批量删除女神信息
     * @param ids
     * @throws SQLException
     */
    public void delete(Integer[] ids) throws SQLException {
        GoddessDAO godDao = new GoddessDAO();
        godDao.deleteGoddess(ids);
    }

    /**
     * 更新女神信息
     * @param goddess
     * @throws SQLException
     */
    public void update(Goddess goddess) throws SQLException {
        GoddessDAO godDao = new GoddessDAO();
        goddess.setUpdateUser("admin");
        godDao.updateGoddess(goddess);
    }

    /**
     * 查询全部女神信息
     * @return
     * @throws SQLException
     */
    public List<Goddess> query() throws SQLException {
        GoddessDAO godDao = new GoddessDAO();
        List<Goddess> list = godDao.queryGoddess();
        return list;
    }

    /**
     * 根据姓名模糊查询女神信息
     * @param userName
     * @return
     * @throws SQLException
     */
    public List<Goddess> query(String userName) throws SQLException {
        GoddessDAO godDao = new GoddessDAO();
        List<Goddess> list = godDao.queryGoddess(userName);
        return list;
    }

    /**
     * 根据ID查询女神信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Goddess getGoddess(Integer id) throws SQLException {
        GoddessDAO godDao = new GoddessDAO();
        Goddess goddess = godDao.getGoddess(id);
        return goddess;
    }
}

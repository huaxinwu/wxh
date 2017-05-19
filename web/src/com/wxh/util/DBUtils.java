/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * @author wxh
 * @version $Id: DBUtils.java, v 0.1 2016年12月20日 上午10:40:19 wxh Exp $
 */
public class DBUtils {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL    = "jdbc:mysql://127.0.0.1:3306/demomq";
    private static final String USER   = "root";
    private static final String PWD    = "cqabj208";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("加载驱动失败！");
        } catch (SQLException e) {
            throw new RuntimeException("读取数据库配置文件失败！");
        }
        return conn;
    }

    /**
     * 关闭数据库连接对象
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getConn());
    }

}

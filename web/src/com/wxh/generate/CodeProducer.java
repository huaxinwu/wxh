/**
 * wxh Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 */
package com.wxh.generate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 代码自动生成实体类
 * @author wxh
 * @version $Id: CodeProducer.java, v 0.1 2016年12月8日 下午5:22:18 wxh Exp $
 */
public class CodeProducer {
    private static final String SRC_PATH = System.getProperty("user.dir") + "/src/";
    private static String       entityName;
    private static String       packageName;
    private static String       entitySetter;
    private static String       entityGetter;

    private static final String DRIVER   = "com.mysql.jdbc.Driver";
    private static final String URL      = "jdbc:mysql://127.0.0.1:3306/demomq";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "cqabj208";
    static Connection           conn;
    static ResultSet            rs;
    static String               sql;

    static {
        //        loadProperties();
        loadSQLConfig();
    }

    /**
     * 加载sql文件配置信息
     */
    public static void loadSQLConfig() {
        try {
            entityName = "student";
            packageName = "com.wxh.model";
            conn = getConn();
            sql = "select * from t_code";
            rs = exeQuery(conn, sql);
            while (rs.next()) {
                entitySetter = rs.getString("entity_setter");
                entityGetter = rs.getString("entity_getter");
            }
        } catch (Exception e) {
            throw new RuntimeException("连接数据库失败");
        }
    }

    /**
     * 加载配置文件信息
     */
    public static void loadProperties() {
        Properties prop = new Properties();
        InputStream in = CodeProducer.class.getResourceAsStream("prop.properties");
        try {
            prop.load(in);
            entityName = prop.getProperty("entityName");
            packageName = prop.getProperty("packageName");
            entitySetter = prop.getProperty("entitySetter");
            entityGetter = prop.getProperty("entityGetter");
        } catch (IOException e) {
            throw new RuntimeException("读取配置文件失败");
        }
    }

    /**
     * 通过读取配置文件生成相应的类和包
     * @param map
     * @throws IOException 
     */
    public static void createEntityByConfig(Map<String, String> map) throws IOException {
        if (!isFirstUpper(entityName)) {
            System.out.println("实体类第一个字符必须大写");
            //将该字符串的第一个字符转成大写
            entityName = setFirstUpper(entityName);
        }
        String filePath = SRC_PATH + packageName.replace(".", "/");
        String fileName = SRC_PATH + packageName.replace(".", "/") + "/" + entityName + ".java";

        File file = new File(filePath);
        //创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        } else {
            file.delete();
            System.out.println("文件目录已存在");
        }
        file = new File(fileName);
        //创建文件
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            System.out.println("文件已存在");
        }
        System.out.println("文件创建成功");
        //将条件写入到对应文件
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("package " + packageName + ";\n\n");
        //遍历map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("Date".equals(entry.getValue())) {
                out.write("import java.util.Date;\n\n");
            }
        }
        out.write("public class " + entityName + " {\n\n");
        //添加成员变量
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.write("\tprivate " + entry.getValue() + " " + entry.getKey() + ";\n\n");
        }
        //添加setter getter方法
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.write("\t"
                      + entityGetter.replace("##PROPERTY_TYPE##", entry.getValue())
                          .replace("##PROPERTY_NAME_FirstUp##", setFirstUpper(entry.getKey()))
                          .replace("##PROPERTY_NAME##", entry.getKey()));
            out.write("\n\n");

            out.write("\t"
                      + entitySetter
                          .replace("##PROPERTY_NAME_FirstUp##", setFirstUpper(entry.getKey()))
                          .replace("##PROPERTY_TYPE##", entry.getValue())
                          .replace("##PROPERTY_NAME##", entry.getKey()));
            out.write("\n\n");
        }
        out.write("}");
        out.flush();
        out.close();

    }

    /**
     * 通过类名和包名生成相应类和包
     * @param entityName
     * @param packageName
     * @throws IOException 
     */
    public static void createEntity(String entityName, String packageName, Map<String, String> map)
                                                                                                   throws IOException {
        //判断第一个字符是否是大写
        if (!isFirstUpper(entityName)) {
            System.out.println("实体类第一个字符必须大写");
            //将该字符串的第一个字符转成大写
            entityName = setFirstUpper(entityName);
        }

        String filePath = SRC_PATH + packageName.replace(".", "/");
        String fileName = SRC_PATH + packageName.replace(".", "/") + "/" + entityName + ".java";

        File file = new File(filePath);
        //创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        } else {
            file.delete();
            System.out.println("文件目录已存在");
        }
        file = new File(fileName);
        //创建文件
        if (!file.exists()) {
            file.createNewFile();
        } else {
            file.delete();
            System.out.println("文件已存在");
        }
        System.out.println("文件创建成功");
        //将条件写入到对应文件
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write("package " + packageName + ";\n\n");
        //遍历map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("Date".equals(entry.getValue())) {
                out.write("import java.util.Date;\n\n");
            }
        }
        out.write("public class " + entityName + " {\n\n");
        //添加成员变量
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.write("\t private " + entry.getValue() + " " + entry.getKey() + ";\n\n");
        }
        //添加setter getter 方法
        for (Map.Entry<String, String> entry : map.entrySet()) {
            //--------------getter-----------------
            out.write("\t public " + entry.getValue() + " " + "get" + setFirstUpper(entry.getKey())
                      + "(){\n");
            out.write("\t\t return " + entry.getKey() + ";\n");
            out.write("\t }\n\n");

            //-------------setter-------------
            out.write("\t public void " + "set" + setFirstUpper(entry.getKey()) + "("
                      + entry.getValue() + " " + entry.getKey() + "){\n");
            out.write("\t\t this." + entry.getKey() + " " + "=" + " " + entry.getKey() + ";\n");
            out.write("\t }\n\n");
        }
        out.write("}");
        out.flush();
        out.close();
    }

    /**
     * 判断第一个字符是否是大写
     * @param entityName
     * @return
     */
    public static boolean isFirstUpper(String entityName) {
        return Character.isUpperCase(entityName.charAt(0));
    }

    /**
     * 将字符串第一个字符转成大写
     * @param entityName
     * @return
     */
    public static String setFirstUpper(String entityName) {
        return (entityName.charAt(0) + "").toUpperCase() + entityName.substring(1);
    }

    /**
     * 获取一个连接
     * @return
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    public static Connection getConn() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 释放连接
     * @param conn
     * @param rs
     */
    public static void releaseConn(Connection conn, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
    * 根据conn和sql得到一个结果集
    * @param conn2
    * @param sql2
    * @return
     * @throws SQLException 
    */
    public static ResultSet exeQuery(Connection conn, String sql) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    /**
     * 测试自动生成实体类
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String entityName = "student";
        String packageName = "com.wxh.model";
        //字符串键值对存取
        Map<String, String> map = new HashMap<String, String>();
        map.put("studentId", "int");
        map.put("studentName", "String");
        map.put("studentNum", "String");
        map.put("studentGrade", "String");
        map.put("birth", "Date");
        try {
            //            CodeProducer.createEntity(entityName, packageName, map);
            CodeProducer.createEntityByConfig(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

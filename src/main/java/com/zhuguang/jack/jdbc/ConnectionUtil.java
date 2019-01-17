package com.zhuguang.jack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://192.168.88.139:3307/zg";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD = "123456";

    public static Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Connection con = null;
        Class.forName(DB_DRIVER_CLASS);
        con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        System.out.println("DB Connection created successfully");
        return con;
    }
}

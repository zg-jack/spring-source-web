package com.zhuguang.jack.jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://192.168.88.139:3307/zg?useUnicode=true&amp;characterEncoding=utf-8";
        String USER = "root";
        String PASSWORD = "123456";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from test");
        while (rs.next()) {
            System.out.println(rs.getString("num"));
        }
        rs.close();
        st.close();
        conn.close();
    }
}

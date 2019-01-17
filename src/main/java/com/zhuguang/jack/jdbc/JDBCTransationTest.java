package com.zhuguang.jack.jdbc;

import java.sql.*;

public class JDBCTransationTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionUtil.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            insertTest(connection);
            insertTest1(connection);
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
                System.out.println("JDBC Transaction rolled back successfully");
            } catch (SQLException e1) {
                System.out.println("JDBC Transaction rolled back fail" + e1.getMessage());
            }
        } finally {
            if (connection != null) {
                try {
                    selectAll(connection);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void insertTest(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("insert into test(num) values (?)");
        stmt.setString(1, "JACK2");
        stmt.executeUpdate();
        System.out.println("Data inserted successfully");
        stmt.close();
    }

    public static void insertTest1(Connection con) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("insert into test1(num) values (?)");
        stmt.setString(1, "JACK22222222222222222222");
        stmt.executeUpdate();
        System.out.println("Data inserted successfully");
        stmt.close();
    }

    public static void selectAll(Connection con) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from test");
        System.out.println("============test============");
        while (rs.next()) {
            System.out.println(rs.getString("num"));
        }
        ResultSet rs1 = st.executeQuery("select * from test1");
        System.out.println("============test1============");
        while (rs1.next()) {
            System.out.println(rs1.getString("num"));
        }
        st.close();
    }
}

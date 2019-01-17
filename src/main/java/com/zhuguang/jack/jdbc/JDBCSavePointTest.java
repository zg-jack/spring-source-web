package com.zhuguang.jack.jdbc;

import java.sql.*;

public class JDBCSavePointTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionUtil.getConnection();
            connection.setAutoCommit(false);
            insertTest(connection);
            insertTest1(connection);
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public static void insertTest(Connection con){
        PreparedStatement stmt = null;
        Savepoint a1 = null;
        try {
            stmt = con.prepareStatement("insert into test(num) values (?)");
            stmt.setString(1, "q2");
            stmt.executeUpdate();
            System.out.println("Data inserted successfully");
            stmt.close();
            a1 = con.setSavepoint("a1");
        } catch (SQLException e) {
            e.printStackTrace();
            if(a1 != null) {
                try {
                    con.rollback(a1);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void insertTest1(Connection con) throws SQLException {
        PreparedStatement stmt = null;
        Savepoint a2 = null;
        try {
            stmt = con.prepareStatement("insert into test1(num) values (?)");
            stmt.setString(1, "q2222222222222222222");
            stmt.executeUpdate();
            System.out.println("Data inserted successfully");
            stmt.close();
            a2 = con.setSavepoint("a2");
        } catch (SQLException e) {
            e.printStackTrace();
            if(a2 != null) {
                try {
                    con.rollback(a2);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
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

package com.hj.util;

import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Author: hj
 * Date: 2019-04-24 18:05
 * Description: jdbc连接数据库
 */
public class JdbcUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/micro_message?useSSL=false";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "13647920281hj";

    private static Connection connection = null;


    //1.加载驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.获取连接
    public static Connection getConnection() {
        try {
            if (connection == null) {
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭资源
    public static void close(PreparedStatement ps, Connection connection) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        Connection connection = JdbcUtil.getConnection();
        if (connection != null) {
            System.out.println("数据库连接成功");
        }
    }
}

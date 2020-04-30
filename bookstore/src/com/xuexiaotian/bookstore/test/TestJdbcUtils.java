package com.xuexiaotian.bookstore.test;

import com.xuexiaotian.bookstore.utils.JdbcUtils;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestJdbcUtils {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            //获取数据库的连接
             connection = JdbcUtils.getConnection();
             System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            JdbcUtils.release(connection);
            //com.mchange.v2.c3p0.impl.NewProxyConnection@5e4c8041
        }
    }
}

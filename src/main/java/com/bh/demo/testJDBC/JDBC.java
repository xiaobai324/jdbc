package com.bh.demo.testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author:JL
 * @Date:2021/1/22
 */
public class JDBC {
    public static Connection getConnection(){
        Connection connection = null;
            //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }
        //获取连接
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
            String username = "root";
            String password = "123456";
        try {
             connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        }
        if (connection!=null){
            return connection;
        }
        return null;
    }

}

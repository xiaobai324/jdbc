package com.bh.demo.TestJdbcUtil;
import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * @Author:JL
 * @Date:2021/1/22
 */

public class JDBCUtil {
    private static String url;      //url连接
    private static String username;//用户名
    private static String password;//密码
    private static String driver;//驱动
    static{

            Properties properties = new Properties();
            //加载配置文件
        //FileInputStream fis = null;
        try {
            //fis = new FileInputStream(new File("jdbcconfig.properties"));
            InputStream fis = JDBCUtil.class.getResourceAsStream("/dbconfig.properties");

            properties.load(fis);

        } catch (FileNotFoundException e) {
            System.out.println("找不到文件");
        } catch (IOException e) {
            System.out.println("加载配置文件失败");
        }

            //读取文件中的变量
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {

            //System.out.println("加载驱动失败");
        }

    }

    public static Connection getConnection(){
        //连接数据库
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
        }
        return connection;
    }
    //释放资源
    public static void close(ResultSet resultSet, Statement statement,
                             Connection connection){
//判断是否存在释放资源
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(statement != null ){
                statement.close();
            }
            if(connection != null ){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
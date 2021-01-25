package com.bh.demo.testJDBC;

import org.junit.Test;

import java.sql.*;

/**
 * @Author:JL
 * @Date:2021/1/22
 * jdbc连接数据库
 */
public class TestJDBC {
    @Test
    public void test() throws Exception{
        //加载驱动
        //JDBC.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url,username,password);
        //System.out.println(connection);
        //生成语句发送器
        Statement statement = connection.createStatement();
        //Statement statement = connection.createStatement();
        //执行Sql语句
        String sql = "select * from product_info";
        ResultSet resultSet = statement.executeQuery(sql);

        /*String sql2 = "INSERT INTO product_info (product_id,product_name,product_price,product_stock," +
                "product_description,category_type) VALUES('3','平板', '3000', 88, '这是平板',3)";
        int row = statement.executeUpdate(sql2);
        System.out.println(row);*/

        while (resultSet.next()){
            int pno = resultSet.getInt(1);
            String product_name = resultSet.getString("product_name");
            String product_price = resultSet.getString("product_price");
            String product_stock = resultSet.getString("product_stock");
            String product_description = resultSet.getString("product_description");
            String product_icon = resultSet.getString("product_icon");
            String product_status = resultSet.getString("product_status");
            String category_type = resultSet.getString("category_type");
            String create_time = resultSet.getString("create_time");
            String update_time = resultSet.getString("update_time");
            System.out.println(pno+","+product_name+","+product_price+","+product_stock+","+
                    product_description+","+product_icon+","+product_status+","+category_type+","+
                    create_time+","+update_time);
        }
        //释放资源
        resultSet.close();
        connection.close();
        statement.close();
    }
}

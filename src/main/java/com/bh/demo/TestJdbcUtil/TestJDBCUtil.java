package com.bh.demo.TestJdbcUtil;


import org.junit.Test;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

/**
 * @Author:JL
 * @Date:2021/1/22
 */
public class TestJDBCUtil {
    @Test
    public void test() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        //System.out.println(connection);
        //生成语句发送器
        String sql = "select * from product_info";

        Statement statement = connection.createStatement();
        //执行Sql语句
        ResultSet resultSet = statement.executeQuery(sql);
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
        JDBCUtil.close(resultSet,statement,connection);
    }
    @Test
    public void fun() throws SQLException, IOException {
        //把MP3保存到数据库中
        //把文件转换成byte[]
        Connection con=JDBCUtil.getConnection();
        File file = new File("music.mp3");
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.close();

        //使用byte[]创建Blob
        Blob blob=new SerialBlob(bytes);
        //插入的sql语句
        String sql="insert into music values(1,'music.mp3','blob')";
        Statement statement=con.createStatement();
        int row = statement.executeUpdate(sql);//执行SQL语句
        System.out.println(row);//输出影响的行数
    }
}

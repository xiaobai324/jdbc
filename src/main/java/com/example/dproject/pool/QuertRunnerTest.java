package com.example.dproject.pool;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author:JL
 * @Date:2021/1/25
 */
public class QuertRunnerTest {
    @Test
    //MapHandler：单行处理器
    public void fun1(){
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from student where id=?";
        Map<String,Object> map = null;
        try {
            map = qr.query(sql,new MapHandler(),"3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }
    //MapListHandler：多行处理器
    @Test
    public void fun2(){
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from student";
        List<Map<String,Object>> list = null;
        try {
            list = qr.query(sql,new MapListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map<String,Object> map : list){
            System.out.println(map);
        }
    }
    //BeanHandler：单行处理器,把结果集转换成 Bean，该处理器需要 Class 参数，即 Bean 的类型；
    //@Test
    //public void fun3(){
    //    DataSource ds = JdbcUtils.getDataSource();
    //    QueryRunner qr = new QueryRunner(ds);
    //    String sql = "";
    //    Student stu = qr.query(sql, new BeanHandler<Student>(Student.class),"3");
    //    System.out.println(stu);
    //}
    //BeanListHandler：多行处理器！把结果集转换成 List<Bean>；
    //@Test
    //public void fun4(){
    //    DataSource ds = JdbcUtils.getDataSource();
    //    QueryRunner qr = new QueryRunner(ds);
    //    String sql = "select * from student";
    //    List<Student> list = qr.query(sql,new BeanListHandler<Student>(Student.class));
    //    for (Student stu : list){
    //        System.out.println(stu);
    //    }
    //}
    //ColumnListHandler：多行单列处理器！把结果集转换成 List<Object>，使用 ColumnListHandler时需要指定某一列的名称或编号，
    @Test
    public void fun5() throws SQLException {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from student";
        List<Object> list = qr.query(sql, new ColumnListHandler<Object>("name"));
        for(Object s : list) {
            System.out.println(s);
        }
    }
    //ScalarHandler：单行单列处理器！把结果集转换成 Object。
    @Test
    public void fun6() throws SQLException {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select count(*) from student";
        Number number = (Number)qr.query(sql, new ScalarHandler());
        int cnt = number.intValue();
        System.out.println(cnt);
    }
}

package com.lut.propertyleasing.uitls;

import java.sql.*;

/**
 * @program: FreshShop
 * @description:JDBC工具类
 * @author: GuXue
 * @create: 2022-09-19 15:32
 **/
public class JdbcUtils {
    protected Connection conn;
    //连接数据库方法
    public void openConnection() throws Exception {
        if (conn == null || conn.isClosed()){
            //步骤1：加载驱动,使用Class类的forName方法，将驱动程序类加载到JVM（Java虚拟机）中；
            Class.forName("com.mysql.cj.jdbc.Driver");  //mysql8.0
            //Class.forName("com.mysql.jdbc.Driver"); //mysql5.x

            //步骤2：获取数据库连接 ,成功加载驱动后，必须使用DriverManager类的静态方法getConnection来获得连接对象；
            // Connection  conn=DriverManager.getConnection(数据库URL,数据库用户名,密码)
            String  url = "jdbc:mysql://localhost:3306/property_leasing?serverTimezone=UTC"; //数据库的地址
            String userName = "root";  //数据库用户名
            String pwd = "root"; //数据库密码
            conn = DriverManager.getConnection(url,userName,pwd);
        }
    }
    //关闭资源
    //只关闭conn对象
    public void closeConnection(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    //关闭conn pst
    public void closeConnection(Connection conn, PreparedStatement pst){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    //关闭conn pst rs
    public void closeConnection(Connection conn,PreparedStatement pst, ResultSet rs){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    //关闭pst
    public void closeConnection(PreparedStatement pst){
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    //关闭 pst rs
    public void closeConnection(PreparedStatement pst, ResultSet rs){
        if (pst!=null){
            try {
                pst.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
    //打开事务
    public void beginTransaction() throws Exception {
        openConnection();  //创建数据库连接
        conn.setAutoCommit(false); //设置事务提交为手动。true(默认)--自动提交事务  false--手动提交事务
    }
    //提交事务
    public void commit(){
        try {
            conn.commit(); //提交事务
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    //回滚事务
    public void rollback(){
        try {
            conn.rollback();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}

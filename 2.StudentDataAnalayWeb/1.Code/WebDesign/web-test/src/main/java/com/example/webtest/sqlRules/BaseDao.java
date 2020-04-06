package com.example.webtest.sqlRules;

import java.sql.*;

public interface BaseDao {
    public static Connection getConnection() {
        String driver = "com.mysql.jc.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("启动数据库失败");
        }
        return conn;
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static StringBuffer sb1 = new StringBuffer(); // StringBuffer便于字符串的增删改查操作
    public static StringBuffer sb2 = new StringBuffer(); // StringBuffer便于字符串的增删改查操作
    public static StringBuffer sb3 = new StringBuffer(); // StringBuffer便于字符串的增删改查操作

    public static String[] students = null; // 存储学生基本信息表信息
    public static String[] webs = null; // 存储网站基本信息表信息
    public static String[] times = null; // 存储网站基本信息表信息



    //获取学生基本信息表
    public static String[] getNames() throws SQLException {
        Connection con = BaseDao.getConnection(); //建立数据库连接
        Statement stat = con.createStatement();
        String sql = "select * from stu"; // 将数据从数据库中读取出来
        ResultSet rs = stat.executeQuery(sql);// 从ResultSet中将数据取出(每条数据有4列)

        try {
            while (rs.next()) {
                sb1.append(rs.getString(1)); // 读出每一列的数据
                sb1.append("#"); // 在每列数据后面做标记，将来便于做拆分
                sb1.append(rs.getString(2));
                sb1.append("#");
                sb1.append(rs.getString(3));
                sb1.append("#");
                sb1.append(rs.getString(4));
                sb1.append("%"); // 在每条数据后面做标记，便于拆分
            }
            String str = sb1.toString(); // 将数据由StringBuffer类型转化成String类型
            String datas;// 将总数据以指定字符分割成数组，每条数据为数组的一项
            String[] students = str.split("%"); //将每条数据再拆分，则param数据保存的是一条数据的每一项数据
            BaseDao.closeAll(con, stat, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    public static  String[] getWeb() throws SQLException {
        Connection con = BaseDao.getConnection(); //建立数据库连接
        Statement stat = con.createStatement();
        String sql = "select * from web"; // 将数据从数据库中读取出来
        ResultSet rs = stat.executeQuery(sql);// 从ResultSet中将数据取出(每条数据有4列)

        try {
            while (rs.next()) {
                sb2.append(rs.getString(1)); // 读出每一列的数据
                sb2.append("%"); // 在每列数据后面做标记，将来便于做拆分
            }
            String str = sb2.toString(); // 将数据由StringBuffer类型转化成String类型
            String datas;// 将总数据以指定字符分割成数组，每条数据为数组的一项
            String[] webs = str.split("%"); //将每条数据再拆分，则param数据保存的是一条数据的每一项数据*/
            BaseDao.closeAll(con,stat,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webs;
}
    public static  String[] getTimes() throws SQLException {
        Connection con = BaseDao.getConnection(); //建立数据库连接
        Statement stat = con.createStatement();
        String sql = "select * from Times"; // 将数据从数据库中读取出来
        ResultSet rs = stat.executeQuery(sql);// 从ResultSet中将数据取出(每条数据有4列)

        try {
            while (rs.next()) {
                sb3.append(rs.getString(1)); // 读出每一列的数据
                sb3.append("%"); // 在每列数据后面做标记，将来便于做拆分
            }
            String str = sb3.toString(); // 将数据由StringBuffer类型转化成String类型
            String datas;// 将总数据以指定字符分割成数组，每条数据为数组的一项
            String[] Times = str.split("%"); //将每条数据再拆分，则param数据保存的是一条数据的每一项数据*/
            BaseDao.closeAll(con,stat,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return times;
    }
}



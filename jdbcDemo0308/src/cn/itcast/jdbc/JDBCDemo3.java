package cn.itcast.jdbc;

import cn.itcast.utils.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        boolean login = new JDBCDemo3().loginByPrepare(username, password);
        if(login)
            System.out.println("登录成功！");
        else
            System.out.println("用户名密码错误.");
    }


    public boolean login(String username, String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = String.format("select * from user where username='%s' and password='%s'",username,password);
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtil.close(stmt,conn,rs);
        }
        return false;
    }

    /**
     * 使用 PreparedStatement 防止SQL注入
     * @param username
     * @param password
     * @return
     */
    public boolean loginByPrepare(String username, String password){
        if(username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = String.format("select * from user where username=? and password=?",username,password);
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtil.close(pstmt,conn,rs);
        }
        return false;
    }
}

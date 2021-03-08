package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.定义SQL
            String sql = "insert into account values(null,'王五',300)";
            // 3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://10.16.163.76:3306/dbtest","hhyu","Yhh920205");
            // 4.获取SQL执行对象 Statement
            stmt = conn.createStatement();
            // 5.执行
            int count = stmt.executeUpdate(sql);
            // 6.结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
            }
            else{
                System.out.println("添加失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn !=null){
                try {
                    // 7.释放
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt !=null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}

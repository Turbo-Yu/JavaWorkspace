package cn.itcast.jdbc;

import cn.itcast.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC 事务
 */
public class JDBCTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        String sql1 = "update user set username='NewJerry' where id = ?";
        String sql2 = "update user set username='NewTom' where id = ?";
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);//开启事务
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt1.setInt(1,1);
            pstmt2.setInt(1,2);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            conn.commit();//提交事务
        } catch (SQLException throwables) {
            try {
                if(conn != null)
                    conn.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        }
        finally {
            JDBCUtil.close(pstmt1,conn);
            JDBCUtil.close(pstmt2,null);
        }
    }
}

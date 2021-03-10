package cn.itcast.jdbc;

import cn.itcast.utils.DruidUtil;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidConnectionPool {

    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DruidUtil.getConnection();
            String sql = "insert into account values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"张三");
            pstmt.setInt(2,10000);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DruidUtil.close(pstmt,conn);
        }
    }
}

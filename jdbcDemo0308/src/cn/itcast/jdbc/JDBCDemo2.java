package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo2 {
    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo2().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }


    /**
     * 查询所有emp对象
     * @return
     */
    public List<Emp> findAll(){
        ResultSet rs = null;
        Connection conn = null;
        Statement statement = null;
        List<Emp> list = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:mysql://10.16.163.76:3306/dbtest", "hhyu", "Yhh920205");
            conn = JDBCUtil.getConnection();
            String sql = "select * from emp";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (rs.next()){
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bounds = rs.getDouble("bounds");
                int dept_id = rs.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setJob_id(job_id);
                emp.setEname(ename);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBounds(bounds);
                emp.setDept_id(dept_id);
                list.add(emp);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            JDBCUtil.close(statement,conn,rs);
        }
        return list;
    }
}

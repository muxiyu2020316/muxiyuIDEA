package LearnJdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessLock {
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    public static void main(String[] args) {
        Quality();
    }
    public static  void Quality(){
        try {

            conn=DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="select loginName,loginPwd,realName from user where id= ? for update";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,5);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("loginName")
                +"->"+rs.getString("loginPwd")+"->"+rs.getString("realName"));
            }
            conn.commit();
        } catch (SQLException throwables) {
            if (conn == null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }finally {

            DBUtil.close(conn,ps,rs);
        }
    }

}

package LearnJdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OptiLock {
    static Connection conn=null;
    static PreparedStatement ps=null;
    public static void main(String[] args) {
        try {

            conn=DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="update user set loginName=? where id=5";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"Alabama");
            int count=ps.executeUpdate();
            System.out.println(count+"–– ‹”∞œÏ");
            conn.commit();
        } catch (SQLException throwables) {
            if (conn == null) {
                try {

                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                throwables.printStackTrace();
            }
        }finally {

            DBUtil.close(conn,ps,null);
        }

    }
}

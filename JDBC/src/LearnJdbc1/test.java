package LearnJdbc1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class test {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        ResultSet rs=null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取链接
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3.获取数据对象
            stmt= (Statement) conn.createStatement();
            System.out.println(conn);
            //4.执行sql
            String sql="select * from boys";
            //专门查询dql语句的方法
            rs=stmt.executeQuery(sql);
            //5.处理查询结果集,ddl返回数量,dql返回数据
            boolean flag=rs.next();
            System.out.println(flag);
            while(rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("boyName");
                String cp = rs.getString("userCP");
                System.out.println("编号:"+id+" 男朋友:"+name+" CP:"+cp);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            //6.释放资源
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
            }
            try {
                if(stmt!=null)
                    stmt.close();
            }catch (Exception e2) {
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (Exception e2) {
            }
        }
    }
}

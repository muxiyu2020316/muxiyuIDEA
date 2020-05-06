package LearnJdbc2;

import java.sql.*;
import java.util.ResourceBundle;
public class jdbctest {

    public static void main(String[] args) {
        //使用资绑定器,绑定属性配置文件
        Statement stmt=null;
        Connection  conn=null;
        ResultSet rs=null;
        ResourceBundle bundle=ResourceBundle.getBundle("db");
        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");
        try {
            //1.注册驱动
            Class.forName(driver);
            //获取链接
            conn=DriverManager.getConnection(url,user,password);
            //获取数据库操作哟对象
            stmt=conn.createStatement();
            //执行sql语句
            String sql="insert into admin values(22,'ARyu','123456')";
            int count=stmt.executeUpdate(sql);
            System.out.println(count==1?"添加成功":"失败");
        } catch (Exception e) {
            System.out.println("失败");
        }finally{
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

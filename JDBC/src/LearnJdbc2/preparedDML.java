package LearnJdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class preparedDML {
    public static void main(String[] args) {
        //jdbc编程6步
        PreparedStatement ps=null;//预编译的数据库操作对象
        //接口需要替换
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2获取链接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3获取预编译的数据操作对象
            /*String sql="insert into user(loginName,loginPwd,realName) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"彤离");
            ps.setString(2,"111111");
            ps.setString(3,"江小白");*/
            /*String sql="update user set loginName=?,loginPwd=? ,realName=? where id=?";
            //先预编译执行得到模板,如果换位置就无效
            ps=conn.prepareStatement(sql);
            ps.setString(1,"江小白");
            ps.setString(2,"12994");
            ps.setString(3,"李丹霞");
            ps.setInt(4,11);*/
            String sql="delete from user where loginName=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"江小白");
            //4执行sql
            int count=ps.executeUpdate();
            System.out.println(count+"行受到影响");
        }catch(Exception e){
            System.out.println("添加失败");
        }finally {
            //6释放资源
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
                System.out.println("关闭失败");
            }
            try {
                if(ps!=null)
                    ps.close();
            }catch (Exception e2) {
                System.out.println("关闭失败");
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (Exception e2) {
                System.out.println("关闭失败");
            }
        }
    }

}

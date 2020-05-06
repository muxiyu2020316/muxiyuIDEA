package LearnJdbc2;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLAdd {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("请输入desc升序,asc降序");
        System.out.println("请输入");
        String key=s.nextLine();
        //执行sql语句
        //jdbc编程6步
        Statement ps=null;//预编译的数据库操作对象
        //接口需要替换
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2获取链接
            conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3获取预编译的数据操作对象
            ps= conn.createStatement();
            //4执行sql
            String sql="select loginPwd from user order by loginPwd "+key;
            //5处理结果集
            rs=ps.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("loginPwd"));
            }
        }catch(Exception e){

        }finally {
            //6释放资源
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
            }
            try {
                if(ps!=null)
                    ps.close();
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

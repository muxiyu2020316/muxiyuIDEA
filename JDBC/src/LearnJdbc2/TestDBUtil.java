package LearnJdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试DBUtil是否好用
 * 测试模糊查询
 * 测试增删改查
 */
public class TestDBUtil {
    public static void main(String[] args) {
        //jdbc编程6步
        //获取链接
        Connection conn=null;
        int count = 0;
        //接口需要替换
        PreparedStatement ps=null;//预编译的数据库操作对象
        ResultSet rs=null;
        try {
            //获取链接
            conn=DB.getConnection();
            //获取预编译操作对象,先写sql语句
            /**通用查询
            String sql="select * from admin";
            //获取预先编译对象
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("password"));
            }*/
            /**模糊查询
            特点：
            ①一般和通配符搭配使用
                通配符：
                % 任意多个字符,包含0个字符
                _ 任意单个字符
           */
            //模糊查找
            String sql=" select * from user where loginName like ?";
            //获取预先编译对象
            ps=conn.prepareStatement(sql);
            ps.setString(1,"A%");
            rs=ps.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString("loginName"));
                    //System.out.println(rs.getString("loginPwd"));
                }
            /**
             * //批量添加数据操作
            String sql="insert into user(loginName,loginPwd,realName) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            for (int i = 0; i <5 ; i++) {
                int rd= (int) (Math.random()*100);
                ps.setString(1,"Akr"+rd);
                ps.setString(2,""+rd*100);
                ps.setString(3,"tongliy"+rd);
               count+=ps.executeUpdate();
            }
            System.out.println(count+"行受到影响");*/


            /** //更新操作
            String sql="update user set loginName=?,loginPwd=? where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"muxiyu");
            ps.setString(2,"11111111");
            ps.setInt(3,12);
            //4执行sql
            int count=ps.executeUpdate();
            System.out.println(count+"行受到影响");
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DB.close(conn,ps,rs);
        }
    }
}
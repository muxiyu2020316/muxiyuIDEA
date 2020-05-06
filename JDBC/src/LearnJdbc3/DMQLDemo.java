package LearnJdbc3;

import LearnJdbc2.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DMQLDemo {
    static Scanner s=new Scanner(System.in);
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    static int count=0;
    static String name;
    static String pwd;
    public static void main(String[] args) {
        //add(1);
        //update(1);
        //delete(password,"999");
        //Quality();

    }
    public static void scanner(){
        System.out.print("用户名:");
         name=s.nextLine();
        System.out.print("密码:");
         pwd=s.nextLine();
    }

    /**
     * 数据插入,注意尽量不要中文,会乱码,展示不知怎么解决
     * @param n,插入的数据
     */
    public static void add(int n){
        try {
            conn= DBUtil.getConnection();
            String sql="insert into admin(username,password) values(?,?)";
            ps=conn.prepareStatement(sql);
            for (int i = 0; i <n; i++) {
                scanner();
                ps.setString(1,name);
                ps.setString(2,pwd);

                count+=ps.executeUpdate();
            }
            System.out.println(count+"条受影响");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6释放资源
            DBUtil.close(conn,ps,rs);
        }
    }
    public static<T> void delete(T condition,Object args2){
        try {
            conn=DBUtil.getConnection();
            String sql="delete from admin where '"+ condition+"'=? ";
            ps=conn.prepareStatement(sql);
            ps.setObject(1,args2);
            count=ps.executeUpdate();
            System.out.println(count+"条受影响");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6释放资源
            DBUtil.close(conn,ps,rs);
        }

    }
    /**
     * 数据库更新
     * @param index,要修改的编号
     */
    public static void update(int index){
        try {
            conn=DBUtil.getConnection();
            String sql="update admin set username=?,password=? where id=?";
            ps=conn.prepareStatement(sql);
            scanner();
            ps.setString(1,name);
            ps.setString(2,pwd);
            ps.setInt(3,index);
            count=ps.executeUpdate();
            System.out.println(count+"条受影响");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6释放资源
            DBUtil.close(conn,ps,rs);
        }

    }

    public static void Quality(){
        try {
            conn=DBUtil.getConnection();
            String sql="select *from admin";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("密码="+rs.getString("password")+"用户名="+rs.getString("username"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //6释放资源
            DBUtil.close(conn, ps, rs);
        }
    }
}

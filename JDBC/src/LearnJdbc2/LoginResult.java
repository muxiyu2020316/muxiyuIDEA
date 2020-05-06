package LearnJdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * sql注入问题解决
 * 只要用户提供信息不参与sql的编译
 * 及时含有呢关键字也不会变异
 * 需要使用preparedStatement  ,预编译操作对象
 *  PreparedStatement ps=null;
 */

/**
 * 对比preparedStatement和Statement.
 * 后者存在sql注入,前者不会
 */
public class LoginResult {
    public static void main(String[] args) {
        //初始化一个界面
        //界面初始化方法
        Map<String,String> logininfo=initUI();
        //验证用户名密码
        boolean loginsuccess= login(logininfo);
        System.out.println(loginsuccess?"成功":"失败");
    }
    /**
     * 用户登录信息
     * @param logininfo
     * @return
     */
    private static boolean login(Map<String, String> logininfo) {
        //打标记
        boolean loginsuccess=false;
        //单独定义变量,拼接
        String loginname=logininfo.get("loginname");
        String loginpwd=logininfo.get("loginpwd");
        System.out.println(loginname+" "+loginpwd);
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
            //3获取预编译的数据操作对象,sql语句框架
            String sql="select * from user where loginName=? and loginPwd=?";
            //一个?表示一个占位符,不能使用''括起来 用来作为占位符,loginName=?
            ps= conn.prepareStatement(sql);
            /**传的是编译好的框架,如何传递值?
             * 给占位符传值,第一个问号是1,第二个问号是2,jdbc所有的下标都是从1开始的
             * 使用set传递,传的关键字不参与编译
             */
            //4执行sql,执行预处理后的sql语句
            ps.setString(1,loginname);
            ps.setString(2,loginpwd);
            rs = ps.executeQuery(sql);
            //5处理结果集
            if (rs.next()) {
                loginsuccess=true;
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
        return loginsuccess;
    }
    /**
     * 初始化用户界面
     * @return返回信息
     * 怎么凭借变量"+变量+"
     */
    private static Map<String, String> initUI() {
        Scanner s=new Scanner(System.in);
        System.out.print("用户名:");
        String username=s.nextLine();
        System.out.print("密码:");
        String userpwd=s.nextLine();
        Map<String,String> userLogininfo=new HashMap<>();
        userLogininfo.put("loginname",username);
        userLogininfo.put("loginpwd",userpwd);
        return userLogininfo;
    }
}

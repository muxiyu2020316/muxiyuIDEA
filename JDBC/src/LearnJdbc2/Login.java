package LearnJdbc2;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 实现功能:
     * 1.模拟用户登录
     * 2.业务逻辑
         *  程序运行,提示用户输入密码和用户名
         *  用户输入后,提交信息,后台验证,判断是否可用
 *    3.实际开发会使用专门的建模工具,安装powerdesigner,使用pd工具建表
 *      使用sybase工具
 *    4.存在的问题
 *    用户名:
 *    密码: xxxx  or yyy
 *    登录成功
 *    sql注入问题(黑客漏洞)
 *    用户输入的信息含有sql'语句关键字
 *    关键字参与sql语句变异过程,导致语句变化,从而使得非法数据合法化
 *
 */
public class Login {
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
        //jdbc编程6步
        Statement stmt=null;
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2获取链接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3获取数据对象
            stmt= conn.createStatement();
            //4执行sql
            String sql="select * from user where loginName='"+ loginname+"' and longinPwd='"+loginpwd+"'";
            //xxxx  or yyy 密码设为这个就导致sql语句含义扭曲,以上sql语句的完成凭借,下面代码的含义
            //是发送sql语句给dbns,进行编译,将用户非法信息也变异进去了
            //5处理结果集
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                loginsuccess=true;
            }else{
                System.out.println("比对不到数据");
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

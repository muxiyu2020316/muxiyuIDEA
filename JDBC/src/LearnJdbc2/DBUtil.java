package LearnJdbc2;

import java.sql.*;

/**
 * jdbc工具类.简化操作
 */
public class DBUtil {
    //工具类的构造方法都是私有的,不需要new对象,类直接调用
    static String user="root";
    static String pwd="123456";
    static String url="jdbc:mysql://localhost:3306/girls";
    private  DBUtil(){}

    /**
     * 静态代码块在类加载执行,只执行一次
     */
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getConnection() throws SQLException {
             Connection conn= DriverManager.getConnection(url,user,pwd);
             return conn;
    }
    /**
     * 关闭资源
     * @param conn 链接
     * @param ps 数据操作对象
     * @param rs   结果集
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        //释放资源
        try {
            if(rs!=null)
                rs.close();
        }catch (Exception e2) {
            System.out.println("rs关闭失败");
        }
        try {
            if(ps!=null)
                ps.close();
        }catch (Exception e2) {
            System.out.println("stmt关闭失败");
        }
        try {
            if(conn!=null)
                conn.close();
        } catch (Exception e2) {
            System.out.println("conn关闭失败");
        }
    }
}

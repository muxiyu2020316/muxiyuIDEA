package LearnJdbc2;
import java.sql.*;
import java.util.ResourceBundle;
/**
 * jdbc工具类.简化操作
 */
public class DB {
    //工具类的构造方法都是私有的,不需要new对象,类直接调用
    private DB(){}
    //获取配置文件的信息
    static ResourceBundle bundle=ResourceBundle.getBundle("db");
    static String driver=bundle.getString("driver");
    static String url=bundle.getString("url");
    static String user=bundle.getString("user");
    static String pwd=bundle.getString("password");
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库链接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pwd);
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
